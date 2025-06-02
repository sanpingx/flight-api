package com.example.flightapi.dal.dataobject;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.flightapi.core.dataobject.BaseDO;
import lombok.*;

/**
 * 机场信息 DO
 *
 * @author 
 */
@TableName("airport")
@KeySequence("airport_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportDO extends BaseDO {

    /**
     * 机场ID
     */
    @TableId
    private Long airportId;
    /**
     * 机场编号
     */
    private Long code;
    /**
     * 机场名称
     */
    private String name;
    /**
     * 所在城市
     */
    private String city;

}