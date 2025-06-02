package com.example.flightapi.dal.mysql;

import com.example.flightapi.controller.booking.vo.BookingPageReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.core.query.LambdaQueryWrapperX;
import com.example.flightapi.core.repository.BaseMapperX;
import com.example.flightapi.dal.dataobject.BookingDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 预订信息 Mapper
 *
 * @author 
 */
@Mapper
public interface BookingMapper extends BaseMapperX<BookingDO> {

    default PageResult<BookingDO> selectPage(BookingPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BookingDO>()
                .eqIfPresent(BookingDO::getUserId, reqVO.getUserId())
                .eqIfPresent(BookingDO::getFlightId, reqVO.getFlightId())
                .eqIfPresent(BookingDO::getReference, reqVO.getReference())
                .eqIfPresent(BookingDO::getStauts, reqVO.getStauts())
                .betweenIfPresent(BookingDO::getBookingTime, reqVO.getBookingTime())
                .eqIfPresent(BookingDO::getTotalPrice, reqVO.getTotalPrice())
                .betweenIfPresent(BookingDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BookingDO::getBookingId));
    }

}