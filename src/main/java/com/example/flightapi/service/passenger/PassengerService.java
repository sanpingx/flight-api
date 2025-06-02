package com.example.flightapi.service.passenger;

import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.PassengerDO;
import jakarta.validation.Valid;

/**
 * 乘客信息 Service 接口
 *
 * @author 
 */
public interface PassengerService {

    /**
     * 创建乘客信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPassenger(@Valid com.example.flightapi.controller.passenger.vo.PassengerSaveReqVO createReqVO);

    /**
     * 更新乘客信息
     *
     * @param updateReqVO 更新信息
     */
    void updatePassenger(@Valid com.example.flightapi.controller.passenger.vo.PassengerSaveReqVO updateReqVO);

    /**
     * 删除乘客信息
     *
     * @param id 编号
     */
    void deletePassenger(Long id);

    /**
     * 获得乘客信息
     *
     * @param id 编号
     * @return 乘客信息
     */
    PassengerDO getPassenger(Long id);

    /**
     * 获得乘客信息分页
     *
     * @param pageReqVO 分页查询
     * @return 乘客信息分页
     */
    PageResult<PassengerDO> getPassengerPage(
        com.example.flightapi.controller.passenger.vo.PassengerPageReqVO pageReqVO);

}