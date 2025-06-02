package com.example.flightapi.dal.dataobject;


import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.flightapi.core.dataobject.BaseDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.flightapi.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 航班信息 DO
 *
 * @author 
 */
@TableName("flight")
@KeySequence("flight_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDO extends BaseDO {

    /**
     * 航班ID
     */
    @TableId
    private Long flightId;
    /**
     * 航班号
     */
    private String flightNumber;
    /**
     * 出发机场ID
     */
    private Long departureAirportId;
    /**
     * 到达机场ID
     */
    private Long destinationAirportId;
    /**
     * 出发日
     */
    private LocalDate departmentDate;
    /**
     * 出发时间
     */
    private LocalTime departmentTime;
    /**
     * 到达日
     */
    private LocalDate arrivalDate;
    /**
     * 到达时间
     */
    private LocalTime arrivalTime;
    /**
     * 飞行时间
     */
    private Long duration;
    /**
     * 总价
     */
    private BigDecimal price;

}