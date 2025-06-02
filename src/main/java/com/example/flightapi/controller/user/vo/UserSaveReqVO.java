package com.example.flightapi.controller.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 用户信息新增/修改 Request VO")
@Data
public class UserSaveReqVO {

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "20376")
    private Long userId;

    @Schema(description = "用户邮箱", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "用户邮箱不能为空")
    private String email;

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "密码不能为空")
    private String password;

    @Schema(description = "姓", requiredMode = Schema.RequiredMode.REQUIRED, example = " 测试")
    @NotEmpty(message = "姓不能为空")
    private String firstName;

    @Schema(description = "名", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "名不能为空")
    private String lastName;

    @Schema(description = "国家", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "国家不能为空")
    private String country;

    @Schema(description = "电话号码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "电话号码不能为空")
    private Long phone;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "帐号状态（0正常 1停用）", example = "2")
    private Integer status;

    @Schema(description = "最后登录IP", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "最后登录IP不能为空")
    private String loginIp;

    @Schema(description = "最后登录时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "最后登录时间不能为空")
    private LocalDateTime loginDate;

}