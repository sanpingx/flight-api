package com.example.flightapi.controller.flight.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

import static com.example.flightapi.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 航班信息新增/修改 Request VO")
@Data
public class FlightSaveReqVO {

    @Schema(description = "航班ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "18150")
    private Long flightId;

    @Schema(description = "航班号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "航班号不能为空")
    private String flightNumber;

    @Schema(description = "出发机场ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "26313")
    @NotNull(message = "出发机场ID不能为空")
    private Long departureAirportId;

    @Schema(description = "到达机场ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "6353")
    @NotNull(message = "到达机场ID不能为空")
    private Long destinationAirportId;

    @Schema(description = "出发日", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "出发日不能为空")
    private LocalDate departmentDate;

    @Schema(description = "出发时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "出发时间不能为空")
    private LocalTime departmentTime;

    @Schema(description = "到达日")
    private LocalDate arrivalDate;

    @Schema(description = "到达时间")
    private LocalTime arrivalTime;

    @Schema(description = "飞行时间")
    private Long duration;

    @Schema(description = "总价", requiredMode = Schema.RequiredMode.REQUIRED, example = "27990")
    @NotNull(message = "总价不能为空")
    private BigDecimal price;

}