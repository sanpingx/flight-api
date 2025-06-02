package com.example.flightapi.service.passenger;

import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.PassengerDO;
import com.example.flightapi.dal.mysql.PassengerMapper;
import com.example.flightapi.util.object.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static com.example.flightapi.core.enums.ErrorCodeConstants.PASSENGER_NOT_EXISTS;
import static com.example.flightapi.core.exception.util.ServiceExceptionUtil.exception;

/**
 * 乘客信息 Service 实现类
 *
 * @author 
 */
@Service
@Validated
public class PassengerServiceImpl implements PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    @Override
    public Long createPassenger(com.example.flightapi.controller.passenger.vo.PassengerSaveReqVO createReqVO) {
        // 插入
        PassengerDO passenger = BeanUtils.toBean(createReqVO, PassengerDO.class);
        passengerMapper.insert(passenger);
        // 返回
        return passenger.getPassengerId();
    }

    @Override
    public void updatePassenger(com.example.flightapi.controller.passenger.vo.PassengerSaveReqVO updateReqVO) {
        // 校验存在
        validatePassengerExists(updateReqVO.getPassengerId());
        // 更新
        PassengerDO updateObj = BeanUtils.toBean(updateReqVO, PassengerDO.class);
        passengerMapper.updateById(updateObj);
    }

    @Override
    public void deletePassenger(Long id) {
        // 校验存在
        validatePassengerExists(id);
        // 删除
        passengerMapper.deleteById(id);
    }

    private void validatePassengerExists(Long id) {
        if (passengerMapper.selectById(id) == null) {
            throw exception(PASSENGER_NOT_EXISTS);
        }
    }

    @Override
    public PassengerDO getPassenger(Long id) {
        return passengerMapper.selectById(id);
    }

    @Override
    public PageResult<PassengerDO> getPassengerPage(
        com.example.flightapi.controller.passenger.vo.PassengerPageReqVO pageReqVO) {
        return passengerMapper.selectPage(pageReqVO);
    }

}