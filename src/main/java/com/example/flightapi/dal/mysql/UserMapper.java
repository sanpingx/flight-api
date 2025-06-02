package com.example.flightapi.dal.mysql;

import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.core.query.LambdaQueryWrapperX;
import com.example.flightapi.core.repository.BaseMapperX;
import com.example.flightapi.dal.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息 Mapper
 *
 * @author 
 */
@Mapper
public interface UserMapper extends BaseMapperX<UserDO> {

    default PageResult<UserDO> selectPage(com.example.flightapi.controller.user.vo.UserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<UserDO>().eqIfPresent(UserDO::getEmail, reqVO.getEmail())
            .eqIfPresent(UserDO::getPassword, reqVO.getPassword())
            .likeIfPresent(UserDO::getFirstName, reqVO.getFirstName())
            .likeIfPresent(UserDO::getLastName, reqVO.getLastName()).eqIfPresent(UserDO::getCountry, reqVO.getCountry())
            .eqIfPresent(UserDO::getPhone, reqVO.getPhone()).eqIfPresent(UserDO::getSex, reqVO.getSex())
            .eqIfPresent(UserDO::getStatus, reqVO.getStatus()).eqIfPresent(UserDO::getLoginIp, reqVO.getLoginIp())
            .betweenIfPresent(UserDO::getLoginDate, reqVO.getLoginDate())
            .betweenIfPresent(UserDO::getCreateTime, reqVO.getCreateTime()).orderByDesc(UserDO::getUserId));
    }

}