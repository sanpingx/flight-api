package com.example.flightapi.controller.airport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 机场信息 Response VO")
@Data
public class AirportRespVO {

    @Schema(description = "机场ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "10345")
    private Long airportId;

    @Schema(description = "机场编号", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long code;

    @Schema(description = "机场名称", requiredMode = Schema.RequiredMode.REQUIRED, example = " 测试")
    private String name;

    @Schema(description = "所在城市", requiredMode = Schema.RequiredMode.REQUIRED)
    private String city;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}