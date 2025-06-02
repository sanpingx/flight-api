package com.example.flightapi.service.booking;

import com.example.flightapi.controller.booking.vo.BookingPageReqVO;
import com.example.flightapi.controller.booking.vo.BookingSaveReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.BookingDO;
import com.example.flightapi.dal.mysql.BookingMapper;
import com.example.flightapi.util.object.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static com.example.flightapi.core.enums.ErrorCodeConstants.BOOKING_NOT_EXISTS;
import static com.example.flightapi.core.exception.util.ServiceExceptionUtil.exception;

/**
 * 预订信息 Service 实现类
 *
 * @author 
 */
@Service
@Validated
public class BookingServiceImpl implements BookingService {

    @Resource
    private BookingMapper bookingMapper;

    @Override
    public Long createBooking(BookingSaveReqVO createReqVO) {
        // 插入
        BookingDO booking = BeanUtils.toBean(createReqVO, BookingDO.class);
        bookingMapper.insert(booking);
        // 返回
        return booking.getBookingId();
    }

    @Override
    public void updateBooking(BookingSaveReqVO updateReqVO) {
        // 校验存在
        validateBookingExists(updateReqVO.getBookingId());
        // 更新
        BookingDO updateObj = BeanUtils.toBean(updateReqVO, BookingDO.class);
        bookingMapper.updateById(updateObj);
    }

    @Override
    public void deleteBooking(Long id) {
        // 校验存在
        validateBookingExists(id);
        // 删除
        bookingMapper.deleteById(id);
    }

    private void validateBookingExists(Long id) {
        if (bookingMapper.selectById(id) == null) {
            throw exception(BOOKING_NOT_EXISTS);
        }
    }

    @Override
    public BookingDO getBooking(Long id) {
        return bookingMapper.selectById(id);
    }

    @Override
    public PageResult<BookingDO> getBookingPage(BookingPageReqVO pageReqVO) {
        return bookingMapper.selectPage(pageReqVO);
    }

}