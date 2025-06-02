package com.example.flightapi.service.airport;

import com.example.flightapi.controller.airport.vo.AirportPageReqVO;
import com.example.flightapi.controller.airport.vo.AirportSaveReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.AirportDO;
import com.example.flightapi.dal.mysql.AirportMapper;
import com.example.flightapi.util.object.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static com.example.flightapi.core.enums.ErrorCodeConstants.AIRPORT_NOT_EXISTS;
import static com.example.flightapi.core.exception.util.ServiceExceptionUtil.exception;

/**
 * 机场信息 Service 实现类
 *
 * @author 
 */
@Service
@Validated
public class AirportServiceImpl implements AirportService {

    @Resource
    private AirportMapper airportMapper;

    @Override
    public Long createAirport(AirportSaveReqVO createReqVO) {
        // 插入
        AirportDO airport = BeanUtils.toBean(createReqVO, AirportDO.class);
        airportMapper.insert(airport);
        // 返回
        return airport.getAirportId();
    }

    @Override
    public void updateAirport(AirportSaveReqVO updateReqVO) {
        // 校验存在
        validateAirportExists(updateReqVO.getAirportId());
        // 更新
        AirportDO updateObj = BeanUtils.toBean(updateReqVO, AirportDO.class);
        airportMapper.updateById(updateObj);
    }

    @Override
    public void deleteAirport(Long id) {
        // 校验存在
        validateAirportExists(id);
        // 删除
        airportMapper.deleteById(id);
    }

    private void validateAirportExists(Long id) {
        if (airportMapper.selectById(id) == null) {
            throw exception(AIRPORT_NOT_EXISTS);
        }
    }

    @Override
    public AirportDO getAirport(Long id) {
        return airportMapper.selectById(id);
    }

    @Override
    public PageResult<AirportDO> getAirportPage(AirportPageReqVO pageReqVO) {
        return airportMapper.selectPage(pageReqVO);
    }

}