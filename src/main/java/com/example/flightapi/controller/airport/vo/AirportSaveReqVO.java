package com.example.flightapi.controller.airport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 机场信息新增/修改 Request VO")
@Data
public class AirportSaveReqVO {

    @Schema(description = "机场ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "10345")
    private Long airportId;

    @Schema(description = "机场编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "机场编号不能为空")
    private Long code;

    @Schema(description = "机场名称", requiredMode = Schema.RequiredMode.REQUIRED, example = " 测试")
    @NotEmpty(message = "机场名称不能为空")
    private String name;

    @Schema(description = "所在城市", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "所在城市不能为空")
    private String city;

}