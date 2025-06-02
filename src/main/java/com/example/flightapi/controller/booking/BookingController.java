package com.example.flightapi.controller.booking;

import com.example.flightapi.controller.booking.vo.BookingPageReqVO;
import com.example.flightapi.controller.booking.vo.BookingRespVO;
import com.example.flightapi.controller.booking.vo.BookingSaveReqVO;
import com.example.flightapi.core.pojo.CommonResult;
import com.example.flightapi.core.pojo.PageParam;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.BookingDO;
import com.example.flightapi.service.airport.AirportService;
import com.example.flightapi.service.booking.BookingService;
import com.example.flightapi.service.flight.FlightService;
import com.example.flightapi.util.object.BeanUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.example.flightapi.core.pojo.CommonResult.success;

@Tag(name = "管理后台 - 预订信息")
@RestController
@RequestMapping("/booking")
@Validated
public class BookingController {

    @Resource
    private BookingService bookingService;

    @Resource
    private FlightService flightService;

    @Resource
    private AirportService airportService;

    @PostMapping("/create")
    @Operation(summary = "创建预订信息")
    public CommonResult<Long> createBooking(@Valid @RequestBody BookingSaveReqVO createReqVO) {
        return success(bookingService.createBooking(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新预订信息")
    public CommonResult<Boolean> updateBooking(@Valid @RequestBody BookingSaveReqVO updateReqVO) {
        bookingService.updateBooking(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除预订信息")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteBooking(@RequestParam("id") Long id) {
        bookingService.deleteBooking(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得预订信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<BookingRespVO> getBooking(@RequestParam("id") Long id) {
        BookingDO booking = bookingService.getBooking(id);
        return success(BeanUtils.toBean(booking, BookingRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得预订信息分页")
    public CommonResult<PageResult<BookingRespVO>> getBookingPage(@Valid BookingPageReqVO pageReqVO) {
        PageResult<BookingDO> pageResult = bookingService.getBookingPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BookingRespVO.class));
    }

    @GetMapping("/getBookings")
    @Operation(summary = "获得预订信息分页")
    public CommonResult<PageResult<BookingRespVO>> getBookings(@Valid BookingPageReqVO pageReqVO) {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        PageResult<BookingDO> pageResult = bookingService.getBookingPage(pageReqVO);
        var bookingList = BeanUtils.toBean(pageResult, BookingRespVO.class);
        bookingList.getList().forEach(book -> {
            var flight = flightService.getFlight(book.getFlightId());
            var depAirport = airportService.getAirport(flight.getDepartureAirportId());
            var desAirport = airportService.getAirport(flight.getDestinationAirportId());
            book.setFlightNumber(flight.getFlightNumber());
            book.setDepartureCity(depAirport.getCity());
            book.setDestinationCity(desAirport.getCity());
            book.setDepartmentDate(flight.getDepartmentDate());
            book.setDepartmentTime(flight.getDepartmentTime());
            book.setArrivalDate(flight.getArrivalDate());
            book.setArrivalTime(flight.getArrivalTime());
        });
        return success(bookingList);
    }

}