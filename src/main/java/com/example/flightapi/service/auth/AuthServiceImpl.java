package com.example.flightapi.service.auth;

import com.example.flightapi.controller.auth.vo.AuthLoginReqVO;
import com.example.flightapi.controller.auth.vo.AuthLoginRespVO;
import com.example.flightapi.controller.auth.vo.AuthRegisterReqVO;
import com.example.flightapi.controller.user.vo.UserSaveReqVO;
import com.example.flightapi.core.enums.CommonStatusEnum;
import com.example.flightapi.core.enums.UserTypeEnum;
import com.example.flightapi.core.enums.logger.LoginLogTypeEnum;
import com.example.flightapi.dal.dataobject.UserDO;
import com.example.flightapi.dal.mysql.UserMapper;
import com.example.flightapi.service.user.UserService;
import com.example.flightapi.util.object.BeanUtils;
import jakarta.annotation.Resource;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.flightapi.core.constant.ErrorCodeConstants.AUTH_LOGIN_BAD_CREDENTIALS;
import static com.example.flightapi.core.constant.ErrorCodeConstants.AUTH_LOGIN_USER_DISABLED;
import static com.example.flightapi.core.exception.util.ServiceExceptionUtil.exception;

/**
 * Auth Service 实现类
 *
 * @author 
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    /**
     * 验证码的开关，默认为 true
     */
    @Value("${stock.captcha.enable:false}")
    @Setter // 为了单测：开启或者关闭验证码
    private Boolean captchaEnable;

    @Override
    public UserDO authenticate(String mail, String password) {
        // 校验账号是否存在
        UserDO user = userMapper.selectOne(UserDO::getEmail, mail);
        if (user == null) {
            throw exception(AUTH_LOGIN_BAD_CREDENTIALS);
        }
        if (!userService.isPasswordMatch(password, user.getPassword())) {
            throw exception(AUTH_LOGIN_BAD_CREDENTIALS);
        }
        // 校验是否禁用
        if (CommonStatusEnum.isDisable(user.getStatus())) {
            throw exception(AUTH_LOGIN_USER_DISABLED);
        }
        return user;
    }

    @Override
    public AuthLoginRespVO login(AuthLoginReqVO reqVO) {
        // 校验验证码
        //        validateCaptcha(reqVO);

        // 使用账号密码，进行登录
        UserDO user = authenticate(reqVO.getUsername(), reqVO.getPassword());

        return new AuthLoginRespVO();
        // 创建 Token 令牌，记录登录日志
//        return createTokenAfterLoginSuccess(user.getId(), reqVO.getUsername(), LoginLogTypeEnum.LOGIN_USERNAME);
    }

    private AuthLoginRespVO createTokenAfterLoginSuccess(Long userId, String username, LoginLogTypeEnum logType) {
//        // 创建访问令牌
//        OAuth2AccessTokenDO accessTokenDO = oauth2TokenService.createAccessToken(userId, getUserType().getValue(),
//            OAuth2ClientConstants.CLIENT_ID_DEFAULT, null);
//        // 构建返回结果
//        return AuthConvert.INSTANCE.convert(accessTokenDO);
        return new AuthLoginRespVO();
    }

    @Override
    public AuthLoginRespVO refreshToken(String refreshToken) {
//        OAuth2AccessTokenDO accessTokenDO =
//            oauth2TokenService.refreshAccessToken(refreshToken, OAuth2ClientConstants.CLIENT_ID_DEFAULT);
//        return AuthConvert.INSTANCE.convert(accessTokenDO);

        return new AuthLoginRespVO();
    }

    @Override
    public void logout(String token, Integer logType) {
        // 删除访问令牌
//        OAuth2AccessTokenDO accessTokenDO = oauth2TokenService.removeAccessToken(token);
//        if (accessTokenDO == null) {
//            return;
//        }
    }

    private UserTypeEnum getUserType() {
        return UserTypeEnum.ADMIN;
    }

    @Override
    public AuthLoginRespVO register(AuthRegisterReqVO registerReqVO) {
//        // 1. 校验验证码
//        validateCaptcha(registerReqVO);

//        // 2. 校验用户名是否已存在
//        Long userId = userService.registerUser(registerReqVO);

        // 3. 创建 Token 令牌，记录登录日志
//        return createTokenAfterLoginSuccess(userId, registerReqVO.getUsername(), LoginLogTypeEnum.LOGIN_USERNAME);
        UserSaveReqVO user = BeanUtils.toBean(registerReqVO, UserSaveReqVO.class);
        user.setLoginDate(LocalDateTime.now());
        user.setLoginIp("127.0.0.1");
        userService.createUser(user);
        return new AuthLoginRespVO();
    }

//    @VisibleForTesting
//    void validateCaptcha(AuthRegisterReqVO reqVO) {
//        ResponseModel response = doValidateCaptcha(reqVO);
//        // 验证不通过
//        if (!response.isSuccess()) {
//            throw exception(AUTH_REGISTER_CAPTCHA_CODE_ERROR, response.getRepMsg());
//        }
//    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void resetPassword(AuthResetPasswordReqVO reqVO) {
//        AdminUserDO userByMobile = userService.getUserByMobile(reqVO.getMobile());
//        if (userByMobile == null) {
//            throw exception(USER_MOBILE_NOT_EXISTS);
//        }
//
//        smsCodeApi.useSmsCode(new SmsCodeUseReqDTO().setCode(reqVO.getCode()).setMobile(reqVO.getMobile())
//            .setScene(SmsSceneEnum.ADMIN_MEMBER_RESET_PASSWORD.getScene()).setUsedIp(getClientIP()));
//
//        userService.updateUserPassword(userByMobile.getId(), reqVO.getPassword());
//    }
}
