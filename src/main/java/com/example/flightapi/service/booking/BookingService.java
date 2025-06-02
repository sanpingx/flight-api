package com.example.flightapi.service.booking;

import com.example.flightapi.controller.booking.vo.BookingPageReqVO;
import com.example.flightapi.controller.booking.vo.BookingSaveReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.BookingDO;
import jakarta.validation.Valid;

/**
 * 预订信息 Service 接口
 *
 * @author 
 */
public interface BookingService {

    /**
     * 创建预订信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBooking(@Valid BookingSaveReqVO createReqVO);

    /**
     * 更新预订信息
     *
     * @param updateReqVO 更新信息
     */
    void updateBooking(@Valid BookingSaveReqVO updateReqVO);

    /**
     * 删除预订信息
     *
     * @param id 编号
     */
    void deleteBooking(Long id);

    /**
     * 获得预订信息
     *
     * @param id 编号
     * @return 预订信息
     */
    BookingDO getBooking(Long id);

    /**
     * 获得预订信息分页
     *
     * @param pageReqVO 分页查询
     * @return 预订信息分页
     */
    PageResult<BookingDO> getBookingPage(BookingPageReqVO pageReqVO);

}