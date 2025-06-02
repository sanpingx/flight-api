package com.example.flightapi.controller.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 用户信息 Response VO")
@Data
public class UserRespVO {

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "20376")
    private Long userId;

    @Schema(description = "用户邮箱", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @Schema(description = "姓", requiredMode = Schema.RequiredMode.REQUIRED, example = " 测试")
    private String firstName;

    @Schema(description = "名", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    private String lastName;

    @Schema(description = "国家", requiredMode = Schema.RequiredMode.REQUIRED)
    private String country;

    @Schema(description = "电话号码", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long phone;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "帐号状态（0正常 1停用）", example = "2")
    private Integer status;

    @Schema(description = "最后登录IP", requiredMode = Schema.RequiredMode.REQUIRED)
    private String loginIp;

    @Schema(description = "最后登录时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime loginDate;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}