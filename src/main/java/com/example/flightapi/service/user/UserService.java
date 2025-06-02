package com.example.flightapi.service.user;

import com.example.flightapi.controller.user.vo.UserPageReqVO;
import com.example.flightapi.controller.user.vo.UserSaveReqVO;
import com.example.flightapi.core.pojo.PageResult;
import com.example.flightapi.dal.dataobject.UserDO;
import jakarta.validation.Valid;

/**
 * 用户信息 Service 接口
 *
 * @author 
 */
public interface UserService {

    /**
     * 创建用户信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUser(@Valid UserSaveReqVO createReqVO);

    /**
     * 更新用户信息
     *
     * @param updateReqVO 更新信息
     */
    void updateUser(@Valid UserSaveReqVO updateReqVO);

    /**
     * 删除用户信息
     *
     * @param id 编号
     */
    void deleteUser(Long id);

    /**
     * 获得用户信息
     *
     * @param id 编号
     * @return 用户信息
     */
    UserDO getUser(Long id);

    /**
     * 获得用户信息分页
     *
     * @param pageReqVO 分页查询
     * @return 用户信息分页
     */
    PageResult<UserDO> getUserPage(UserPageReqVO pageReqVO);

    /**
     * 判断密码是否匹配
     *
     * @param rawPassword 未加密的密码
     * @param encodedPassword 加密后的密码
     * @return 是否匹配
     */
    boolean isPasswordMatch(String rawPassword, String encodedPassword);

}