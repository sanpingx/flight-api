package com.example.flightapi.controller.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Schema(description = "管理后台 - Register Request VO")
@Data
public class AuthRegisterReqVO extends CaptchaVerificationReqVO {

    @Schema(description = "用户邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "stock")
    @NotBlank(message = "用户邮箱不能为空")
//    @Pattern(regexp = "^+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "用户邮箱格式为test@example.com")
    @Size(min = 4, max = 30, message = "用户邮箱长度为 4-30 个字符")
    private String email;

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

    @Schema(description = "用户姓", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotBlank(message = "用户姓不能为空")
    @Size(max = 30, message = "用户姓长度不能超过 30 个字符")
    private String firstName;

    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotBlank(message = "用户名不能为空")
    @Size(max = 30, message = "用户名长度不能超过 30 个字符")
    private String lastName;

    @Schema(description = "国家名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotBlank(message = "国家名不能为空")
    @Size(max = 30, message = "国家名长度不能超过 30 个字符")
    private String country;

    @Schema(description = "电话号码", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotBlank(message = "电话号码不能为空")
    @Pattern(regexp = "^[0-9]{1,11}$", message = "电话号码由数字组成")
    @Size(max = 11, message = "长度不能超过 11 个字符")
    private String phone;
}