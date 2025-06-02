package com.example.flightapi.controller.passenger.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 乘客信息新增/修改 Request VO")
@Data
public class PassengerSaveReqVO {

    @Schema(description = "乘客ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "21620")
    private Long passengerId;

    @Schema(description = "航班ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "27123")
    @NotNull(message = "航班ID不能为空")
    private Long flightId;

    @Schema(description = "姓", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "姓不能为空")
    private String firstName;

    @Schema(description = "名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "名不能为空")
    private String lastName;

    @Schema(description = "用户邮箱", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "用户邮箱不能为空")
    private String email;

}