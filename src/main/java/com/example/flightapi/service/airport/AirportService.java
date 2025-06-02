package com.example.flightapi.service.airport;

import com.example.flightapi.controller.airport.vo.AirportPageReqVO;
import com.example.flightapi.controller.airport.vo.AirportSaveReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.AirportDO;
import jakarta.validation.Valid;

/**
 * 机场信息 Service 接口
 *
 * @author 
 */
public interface AirportService {

    /**
     * 创建机场信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAirport(@Valid AirportSaveReqVO createReqVO);

    /**
     * 更新机场信息
     *
     * @param updateReqVO 更新信息
     */
    void updateAirport(@Valid AirportSaveReqVO updateReqVO);

    /**
     * 删除机场信息
     *
     * @param id 编号
     */
    void deleteAirport(Long id);

    /**
     * 获得机场信息
     *
     * @param id 编号
     * @return 机场信息
     */
    AirportDO getAirport(Long id);

    /**
     * 获得机场信息分页
     *
     * @param pageReqVO 分页查询
     * @return 机场信息分页
     */
    PageResult<AirportDO> getAirportPage(AirportPageReqVO pageReqVO);

}