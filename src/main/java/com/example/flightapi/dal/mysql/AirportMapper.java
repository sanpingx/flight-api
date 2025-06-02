package com.example.flightapi.dal.mysql;

import com.example.flightapi.controller.airport.vo.AirportPageReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.core.query.LambdaQueryWrapperX;
import com.example.flightapi.core.repository.BaseMapperX;
import com.example.flightapi.dal.dataobject.AirportDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 机场信息 Mapper
 *
 * @author 
 */
@Mapper
public interface AirportMapper extends BaseMapperX<AirportDO> {

    default PageResult<AirportDO> selectPage(AirportPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AirportDO>().eqIfPresent(AirportDO::getCode, reqVO.getCode())
            .likeIfPresent(AirportDO::getName, reqVO.getName()).eqIfPresent(AirportDO::getCity, reqVO.getCity())
            .betweenIfPresent(AirportDO::getCreateTime, reqVO.getCreateTime()).orderByDesc(AirportDO::getAirportId));
    }

}