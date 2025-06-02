package com.example.flightapi.service.flight;

import com.example.flightapi.controller.flight.vo.FlightPageReqVO;
import com.example.flightapi.controller.flight.vo.FlightSaveReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.FlightDO;
import com.example.flightapi.dal.mysql.FlightMapper;
import com.example.flightapi.util.object.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static com.example.flightapi.core.enums.ErrorCodeConstants.FLIGHT_NOT_EXISTS;
import static com.example.flightapi.core.exception.util.ServiceExceptionUtil.exception;

/**
 * 航班信息 Service 实现类
 *
 * @author
 */
@Service
@Validated
public class FlightServiceImpl implements FlightService {

    @Resource
    private FlightMapper flightMapper;

    @Override
    public Long createFlight(FlightSaveReqVO createReqVO) {
        // 插入
        FlightDO flight = BeanUtils.toBean(createReqVO, FlightDO.class);
        flightMapper.insert(flight);
        // 返回
        return flight.getFlightId();
    }

    @Override
    public void updateFlight(FlightSaveReqVO updateReqVO) {
        // 校验存在
        validateFlightExists(updateReqVO.getFlightId());
        // 更新
        FlightDO updateObj = BeanUtils.toBean(updateReqVO, FlightDO.class);
        flightMapper.updateById(updateObj);
    }

    @Override
    public void deleteFlight(Long id) {
        // 校验存在
        validateFlightExists(id);
        // 删除
        flightMapper.deleteById(id);
    }

    private void validateFlightExists(Long id) {
        if (flightMapper.selectById(id) == null) {
            throw exception(FLIGHT_NOT_EXISTS);
        }
    }

    @Override
    public FlightDO getFlight(Long id) {
        return flightMapper.selectById(id);
    }

    @Override
    public PageResult<FlightDO> getFlightPage(FlightPageReqVO pageReqVO) {
        return flightMapper.selectPage(pageReqVO);
    }

}