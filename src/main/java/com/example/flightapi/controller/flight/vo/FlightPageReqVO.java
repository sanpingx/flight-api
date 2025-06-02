package com.example.flightapi.controller.flight.vo;

import com.example.flightapi.core.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.example.flightapi.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 航班信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FlightPageReqVO extends PageParam {

    @Schema(description = "航班号")
    private String flightNumber;

    @Schema(description = "出发机场ID", example = "26313")
    private Long departureAirportId;

    @Schema(description = "到达机场ID", example = "6353")
    private Long destinationAirportId;

    @Schema(description = "出发日")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] departmentDate;

    @Schema(description = "出发时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalTime[] departmentTime;

    @Schema(description = "到达日")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] arrivalDate;

    @Schema(description = "到达时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalTime[] arrivalTime;

    @Schema(description = "飞行时间")
    private Long duration;

    @Schema(description = "总价", example = "27990")
    private BigDecimal price;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}