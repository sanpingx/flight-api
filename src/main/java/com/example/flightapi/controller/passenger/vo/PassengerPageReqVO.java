package com.example.flightapi.controller.passenger.vo;

import com.example.flightapi.core.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.example.flightapi.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 乘客信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PassengerPageReqVO extends PageParam {

    @Schema(description = "航班ID", example = "27123")
    private Long flightId;

    @Schema(description = "姓", example = "张三")
    private String firstName;

    @Schema(description = "名", example = "张三")
    private String lastName;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}