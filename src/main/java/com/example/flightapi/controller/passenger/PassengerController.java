package com.example.flightapi.controller.passenger;

import com.example.flightapi.controller.passenger.vo.PassengerPageReqVO;
import com.example.flightapi.controller.passenger.vo.PassengerRespVO;
import com.example.flightapi.controller.passenger.vo.PassengerSaveReqVO;
import com.example.flightapi.core.pojo.CommonResult;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.PassengerDO;
import com.example.flightapi.service.passenger.PassengerService;
import com.example.flightapi.util.object.BeanUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.example.flightapi.core.pojo.CommonResult.success;

@Tag(name = "管理后台 - 乘客信息")
@RestController
@RequestMapping("/passenger")
@Validated
public class PassengerController {

    @Resource
    private PassengerService passengerService;

    @PostMapping("/create")
    @Operation(summary = "创建乘客信息")
    public CommonResult<Long> createPassenger(@Valid @RequestBody PassengerSaveReqVO createReqVO) {
        return success(passengerService.createPassenger(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新乘客信息")
    public CommonResult<Boolean> updatePassenger(@Valid @RequestBody PassengerSaveReqVO updateReqVO) {
        passengerService.updatePassenger(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除乘客信息")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deletePassenger(@RequestParam("id") Long id) {
        passengerService.deletePassenger(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得乘客信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<PassengerRespVO> getPassenger(@RequestParam("id") Long id) {
        PassengerDO passenger = passengerService.getPassenger(id);
        return success(BeanUtils.toBean(passenger, PassengerRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得乘客信息分页")
    public CommonResult<PageResult<PassengerRespVO>> getPassengerPage(@Valid PassengerPageReqVO pageReqVO) {
        PageResult<PassengerDO> pageResult = passengerService.getPassengerPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PassengerRespVO.class));
    }

}