package com.example.flightapi.controller.booking.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 预订信息新增/修改 Request VO")
@Data
public class BookingSaveReqVO {

    @Schema(description = "预订ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "16321")
    private Long bookingId;

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "23958")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @Schema(description = "航班ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "12925")
    @NotNull(message = "航班ID不能为空")
    private Long flightId;

    @Schema(description = "参考")
    private String reference;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "状态不能为空")
    private String stauts;

    @Schema(description = "预计时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "预计时间不能为空")
    private LocalDateTime bookingTime;

    @Schema(description = "总价", requiredMode = Schema.RequiredMode.REQUIRED, example = "24894")
    @NotNull(message = "总价不能为空")
    private BigDecimal totalPrice;

}