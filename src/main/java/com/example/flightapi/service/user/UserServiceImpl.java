package com.example.flightapi.service.user;

import com.example.flightapi.controller.user.vo.UserPageReqVO;
import com.example.flightapi.controller.user.vo.UserSaveReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.UserDO;
import com.example.flightapi.dal.mysql.UserMapper;
import com.example.flightapi.util.object.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static com.example.flightapi.core.enums.ErrorCodeConstants.USER_NOT_EXISTS;
import static com.example.flightapi.core.exception.util.ServiceExceptionUtil.exception;

/**
 * 用户信息 Service 实现类
 *
 * @author
 */
@Service
@Validated
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

//    @jakarta.annotation.Resource
//    private PasswordEncoder passwordEncoder;

    @Override
    public Long createUser(UserSaveReqVO createReqVO) {
        // 插入
        UserDO user = BeanUtils.toBean(createReqVO, UserDO.class);
        userMapper.insert(user);
        // 返回
        return user.getUserId();
    }

    @Override
    public void updateUser(UserSaveReqVO updateReqVO) {
        // 校验存在
        validateUserExists(updateReqVO.getUserId());
        // 更新
        UserDO updateObj = BeanUtils.toBean(updateReqVO, UserDO.class);
        userMapper.updateById(updateObj);
    }

    @Override
    public void deleteUser(Long id) {
        // 校验存在
        validateUserExists(id);
        // 删除
        userMapper.deleteById(id);
    }

    private void validateUserExists(Long id) {
        if (userMapper.selectById(id) == null) {
            throw exception(USER_NOT_EXISTS);
        }
    }

    @Override
    public UserDO getUser(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public PageResult<UserDO> getUserPage(UserPageReqVO pageReqVO) {
        return userMapper.selectPage(pageReqVO);
    }

    @Override
    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        return true;
//        passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 对密码进行加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
    private String encodePassword(String password) {
        return "123456";
//        passwordEncoder.encode(password);
    }

}