package com.example.flightapi.controller.passenger.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 乘客信息 Response VO")
@Data
public class PassengerRespVO {

    @Schema(description = "乘客ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "21620")
    private Long passengerId;

    @Schema(description = "航班ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "27123")
    private Long flightId;

    @Schema(description = "姓", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    private String firstName;

    @Schema(description = "名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    private String lastName;

    @Schema(description = "用户邮箱", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}