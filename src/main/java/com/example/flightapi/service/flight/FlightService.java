package com.example.flightapi.service.flight;

import com.example.flightapi.controller.flight.vo.FlightPageReqVO;
import com.example.flightapi.controller.flight.vo.FlightSaveReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.FlightDO;
import jakarta.validation.Valid;

/**
 * 航班信息 Service 接口
 *
 * @author 
 */
public interface FlightService {

    /**
     * 创建航班信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFlight(@Valid FlightSaveReqVO createReqVO);

    /**
     * 更新航班信息
     *
     * @param updateReqVO 更新信息
     */
    void updateFlight(@Valid FlightSaveReqVO updateReqVO);

    /**
     * 删除航班信息
     *
     * @param id 编号
     */
    void deleteFlight(Long id);

    /**
     * 获得航班信息
     *
     * @param id 编号
     * @return 航班信息
     */
    FlightDO getFlight(Long id);

    /**
     * 获得航班信息分页
     *
     * @param pageReqVO 分页查询
     * @return 航班信息分页
     */
    PageResult<FlightDO> getFlightPage(FlightPageReqVO pageReqVO);

}