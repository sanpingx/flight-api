package com.example.flightapi.dal.mysql;


import com.example.flightapi.controller.flight.vo.FlightPageReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.core.query.LambdaQueryWrapperX;
import com.example.flightapi.core.repository.BaseMapperX;
import com.example.flightapi.dal.dataobject.FlightDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 航班信息 Mapper
 *
 * @author 
 */
@Mapper
public interface FlightMapper extends BaseMapperX<FlightDO> {

    default PageResult<FlightDO> selectPage(FlightPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FlightDO>()
                .eqIfPresent(FlightDO::getFlightNumber, reqVO.getFlightNumber())
                .eqIfPresent(FlightDO::getDepartureAirportId, reqVO.getDepartureAirportId())
                .eqIfPresent(FlightDO::getDestinationAirportId, reqVO.getDestinationAirportId())
                .betweenIfPresent(FlightDO::getDepartmentDate, reqVO.getDepartmentDate())
                .betweenIfPresent(FlightDO::getDepartmentTime, reqVO.getDepartmentTime())
                .eqIfPresent(FlightDO::getPrice, reqVO.getPrice())
                .betweenIfPresent(FlightDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FlightDO::getFlightId));
    }

}