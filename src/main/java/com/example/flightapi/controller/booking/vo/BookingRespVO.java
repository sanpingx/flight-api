package com.example.flightapi.controller.booking.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Schema(description = "管理后台 - 预订信息 Response VO")
@Data
public class BookingRespVO {

    @Schema(description = "预订ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "16321")
    private Long bookingId;

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "23958")
    private Long userId;

    @Schema(description = "航班ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "12925")
    private Long flightId;

    @Schema(description = "航班号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String flightNumber;

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

    @Schema(description = "参考")
    private String reference;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED)
    private String stauts;

    @Schema(description = "预计时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime bookingTime;

    @Schema(description = "总价", requiredMode = Schema.RequiredMode.REQUIRED, example = "24894")
    private BigDecimal totalPrice;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}