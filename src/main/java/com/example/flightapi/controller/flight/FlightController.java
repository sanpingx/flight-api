package com.example.flightapi.controller.flight;

import com.example.flightapi.controller.flight.vo.FlightPageReqVO;
import com.example.flightapi.controller.flight.vo.FlightRespVO;
import com.example.flightapi.controller.flight.vo.FlightSaveReqVO;
import com.example.flightapi.core.pojo.CommonResult;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.AirportDO;
import com.example.flightapi.dal.dataobject.FlightDO;
import com.example.flightapi.service.airport.AirportService;
import com.example.flightapi.service.flight.FlightService;
import com.example.flightapi.util.object.BeanUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.stream.Stream;

import static com.example.flightapi.core.pojo.CommonResult.success;

@Tag(name = "管理后台 - 航班信息")
@RestController
@RequestMapping("/flight")
@Validated
public class FlightController {

    @Resource
    private FlightService flightService;

    @Resource
    private AirportService airportService;

    @PostMapping("/create")
    @Operation(summary = "创建航班信息")
    public CommonResult<Long> createFlight(@Valid @RequestBody FlightSaveReqVO createReqVO) {
        return success(flightService.createFlight(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新航班信息")
    public CommonResult<Boolean> updateFlight(@Valid @RequestBody FlightSaveReqVO updateReqVO) {
        flightService.updateFlight(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除航班信息")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteFlight(@RequestParam("id") Long id) {
        flightService.deleteFlight(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得航班信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<FlightRespVO> getFlight(@RequestParam("id") Long id) {
        FlightDO flight = flightService.getFlight(id);
        return success(BeanUtils.toBean(flight, FlightRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得航班信息分页")
    public CommonResult<PageResult<FlightRespVO>> getFlightPage(@Valid FlightPageReqVO pageReqVO) {
        PageResult<FlightDO> pageResult = flightService.getFlightPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FlightRespVO.class));
    }

    @GetMapping("/getFlights")
    @Operation(summary = "获得航班信息")
    public CommonResult<PageResult<FlightRespVO>> getFlightList(@Valid FlightPageReqVO pageReqVO) {
        var pageResult = flightService.getFlightPage(pageReqVO);
        var departureAirportIdList =
            pageResult.getList().stream().map(r -> r.getDepartureAirportId()).distinct().toList();
        var destinationAirportIdList =
            pageResult.getList().stream().map(r -> r.getDestinationAirportId()).distinct().toList();
        var airportIdList = Stream.concat(departureAirportIdList.stream(), destinationAirportIdList.stream()).toList();
        var airportList = airportIdList.stream().map(airportId -> airportService.getAirport(airportId)).toList();
        var flightList = BeanUtils.toBean(pageResult, FlightRespVO.class);
        flightList.getList().forEach(flight -> {
            flight.setDepartureCity(
                airportList.stream().filter(d -> d.getAirportId().equals(flight.getDepartureAirportId()))
                    .map(AirportDO::getCity).findFirst().get().toString());
            flight.setDestinationCity(
                airportList.stream().filter(d -> d.getAirportId().equals(flight.getDestinationAirportId()))
                    .map(AirportDO::getCity).findFirst().get().toString());
        });
        return success(flightList);
    }

}