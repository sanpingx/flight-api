package com.example.flightapi.dal.dataobject;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.flightapi.core.dataobject.BaseDO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 预订信息 DO
 *
 * @author 
 */
@TableName("booking")
@KeySequence("booking_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDO extends BaseDO {

    /**
     * 预订ID
     */
    @TableId
    private Long bookingId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 航班ID
     */
    private Long flightId;
    /**
     * 参考
     */
    private String reference;
    /**
     * 状态
     */
    private String stauts;
    /**
     * 预计时间
     */
    private LocalDateTime bookingTime;
    /**
     * 总价
     */
    private BigDecimal totalPrice;

}