package com.example.flightapi.controller.auth;

import com.example.flightapi.controller.auth.vo.AuthLoginReqVO;
import com.example.flightapi.controller.auth.vo.AuthLoginRespVO;
import com.example.flightapi.controller.auth.vo.AuthRegisterReqVO;
import com.example.flightapi.core.pojo.CommonResult;
import com.example.flightapi.service.auth.AuthService;
import com.example.flightapi.util.object.BeanUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.example.flightapi.core.pojo.CommonResult.success;

@Tag(name = "管理后台 - 登录")
@RestController
@RequestMapping("/auth")
@Validated
public class LoginController {

    @Resource
    private AuthService authService;

    @GetMapping("/login")
    @Operation(summary = "获得登录日志分页列表")
    public CommonResult<AuthLoginRespVO> getLoginLogPage(@Valid AuthLoginReqVO authLoginReqVO) {
        AuthLoginRespVO pageResult = authService.login(authLoginReqVO);
        return success(BeanUtils.toBean(pageResult, AuthLoginRespVO.class));
    }

    @PostMapping("/register")
    @PermitAll
    @Operation(summary = "注册用户")
    public CommonResult<AuthLoginRespVO> register(@RequestBody @Valid AuthRegisterReqVO registerReqVO) {
        return success(authService.register(registerReqVO));
    }
}
