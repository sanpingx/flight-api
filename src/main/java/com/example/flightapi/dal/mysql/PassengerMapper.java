package com.example.flightapi.dal.mysql;

import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.core.query.LambdaQueryWrapperX;
import com.example.flightapi.core.repository.BaseMapperX;
import com.example.flightapi.dal.dataobject.PassengerDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 乘客信息 Mapper
 *
 * @author 
 */
@Mapper
public interface PassengerMapper extends BaseMapperX<PassengerDO> {

    default PageResult<PassengerDO> selectPage(com.example.flightapi.controller.passenger.vo.PassengerPageReqVO reqVO) {
        return selectPage(reqVO,
            new LambdaQueryWrapperX<PassengerDO>().eqIfPresent(PassengerDO::getFlightId, reqVO.getFlightId())
                .likeIfPresent(PassengerDO::getFirstName, reqVO.getFirstName())
                .likeIfPresent(PassengerDO::getLastName, reqVO.getLastName())
                .eqIfPresent(PassengerDO::getEmail, reqVO.getEmail())
                .betweenIfPresent(PassengerDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PassengerDO::getPassengerId));
    }

}