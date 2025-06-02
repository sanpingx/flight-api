package com.example.flightapi.dal.dataobject;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.flightapi.core.dataobject.BaseDO;
import lombok.*;

/**
 * 乘客信息 DO
 *
 * @author 
 */
@TableName("passenger")
@KeySequence("passenger_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDO extends BaseDO {

    /**
     * 乘客ID
     */
    @TableId
    private Long passengerId;
    /**
     * 航班ID
     */
    private Long flightId;
    /**
     * 姓
     */
    private String firstName;
    /**
     * 名
     */
    private String lastName;
    /**
     * 用户邮箱
     */
    private String email;

}