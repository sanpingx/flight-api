package com.example.flightapi.controller.user.vo;

import com.example.flightapi.core.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.example.flightapi.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 用户信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserPageReqVO extends PageParam {

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "姓", example = " 测试")
    private String firstName;

    @Schema(description = "名", example = "王五")
    private String lastName;

    @Schema(description = "国家")
    private String country;

    @Schema(description = "电话号码")
    private Long phone;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "帐号状态（0正常 1停用）", example = "2")
    private Integer status;

    @Schema(description = "最后登录IP")
    private String loginIp;

    @Schema(description = "最后登录时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] loginDate;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}