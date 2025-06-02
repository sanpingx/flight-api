package com.example.flightapi.controller.booking.vo;

import com.example.flightapi.core.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.example.flightapi.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 预订信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BookingPageReqVO extends PageParam {

    @Schema(description = "用户ID", example = "23958")
    private Long userId;

    @Schema(description = "航班ID", example = "12925")
    private Long flightId;

    @Schema(description = "参考")
    private String reference;

    @Schema(description = "状态")
    private String stauts;

    @Schema(description = "预计时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] bookingTime;

    @Schema(description = "总价", example = "24894")
    private BigDecimal totalPrice;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}