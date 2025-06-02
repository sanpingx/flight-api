package com.example.flightapi.controller.airport;

import com.example.flightapi.controller.airport.vo.AirportPageReqVO;
import com.example.flightapi.controller.airport.vo.AirportRespVO;
import com.example.flightapi.controller.airport.vo.AirportSaveReqVO;
import com.example.flightapi.core.pojo.CommonResult;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.AirportDO;
import com.example.flightapi.service.airport.AirportService;
import com.example.flightapi.util.object.BeanUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.example.flightapi.core.pojo.CommonResult.success;

@Tag(name = "管理后台 - 机场信息")
@RestController
@RequestMapping("/airport")
@Validated
public class AirportController {

    @Resource
    private AirportService airportService;

    @PostMapping("/create")
    @Operation(summary = "创建机场信息")
    public CommonResult<Long> createAirport(@Valid @RequestBody AirportSaveReqVO createReqVO) {
        return success(airportService.createAirport(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新机场信息")
    public CommonResult<Boolean> updateAirport(@Valid @RequestBody AirportSaveReqVO updateReqVO) {
        airportService.updateAirport(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除机场信息")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteAirport(@RequestParam("id") Long id) {
        airportService.deleteAirport(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得机场信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AirportRespVO> getAirport(@RequestParam("id") Long id) {
        AirportDO airport = airportService.getAirport(id);
        return success(BeanUtils.toBean(airport, AirportRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得机场信息分页")
    public CommonResult<PageResult<AirportRespVO>> getAirportPage(@Valid AirportPageReqVO pageReqVO) {
        PageResult<AirportDO> pageResult = airportService.getAirportPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AirportRespVO.class));
    }

}