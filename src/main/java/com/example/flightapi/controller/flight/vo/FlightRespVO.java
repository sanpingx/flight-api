package com.example.flightapi.controller.flight.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.example.flightapi.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 航班信息 Response VO")
@Data
public class FlightRespVO {

    @Schema(description = "航班ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "18150")
    private Long flightId;

    @Schema(description = "航班号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String flightNumber;

    @Schema(description = "出发机场ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "26313")
    private Long departureAirportId;

    @Schema(description = "到达机场ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "6353")
    private Long destinationAirportId;

    @Schema(description = "出发城市", requiredMode = Schema.RequiredMode.REQUIRED)
    private String departureCity;

    @Schema(description = "到达城市", requiredMode = Schema.RequiredMode.REQUIRED)
    private String destinationCity;

    @Schema(description = "出发日", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate departmentDate;

    @Schema(description = "出发时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalTime departmentTime;

    @Schema(description = "到达日")
    private LocalDate arrivalDate;

    @Schema(description = "到达时间")
    private LocalTime arrivalTime;

    @Schema(description = "飞行时间")
    private Long duration;

    @Schema(description = "总价", requiredMode = Schema.RequiredMode.REQUIRED, example = "27990")
    private BigDecimal price;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}