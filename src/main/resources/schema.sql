-- flight.airport definition

CREATE TABLE `airport`
(
    `airport_id`  bigint                                  NOT NULL AUTO_INCREMENT COMMENT '机场ID',
    `code`        bigint                                  NOT NULL COMMENT '机场编号',
    `name`        varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '机场名称',
    `city`        varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '所在城市',
    `creator`     varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
    `create_time` datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`     varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
    `update_time` datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     bit(1)                                 DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint                                 DEFAULT '0' COMMENT '租户编号',
    PRIMARY KEY (`airport_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='机场信息表';


-- flight.booking definition

CREATE TABLE `booking`
(
    `booking_id`   bigint                                 NOT NULL AUTO_INCREMENT COMMENT '预订ID',
    `user_id`      bigint                                 NOT NULL COMMENT '用户ID',
    `flight_id`    bigint                                 NOT NULL COMMENT '航班ID',
    `reference`    varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参考',
    `stauts`       varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态',
    `booking_time` datetime                               NOT NULL COMMENT '预计时间',
    `total_price`  decimal(10, 2)                         NOT NULL COMMENT '总价',
    `creator`      varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
    `create_time`  datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`      varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
    `update_time`  datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`      bit(1)                                 DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`    bigint                                 DEFAULT '0' COMMENT '租户编号',
    PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='预订信息表';


-- flight.flight definition

CREATE TABLE `flight`
(
    `flight_id`              bigint                                 NOT NULL AUTO_INCREMENT COMMENT '航班ID',
    `flight_number`          varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '航班号',
    `departure_airport_id`   bigint                                 NOT NULL COMMENT '出发机场ID',
    `destination_airport_id` bigint                                 NOT NULL COMMENT '到达机场ID',
    `department_date`        date                                   NOT NULL COMMENT '出发日',
    `department_time`        time                                   NOT NULL COMMENT '出发时间',
    `arrival_date`           date                                   DEFAULT NULL COMMENT '到达日',
    `arrival_time`           time                                   DEFAULT NULL COMMENT '到达时间',
    `duration`               bigint                                 DEFAULT '0' COMMENT '飞行时间',
    `price`                  decimal(10, 2)                         NOT NULL COMMENT '总价',
    `creator`                varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
    `create_time`            datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`                varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
    `update_time`            datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`                bit(1)                                 DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`              bigint                                 DEFAULT '0' COMMENT '租户编号',
    PRIMARY KEY (`flight_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='航班信息表';


-- flight.passenger definition

CREATE TABLE `passenger`
(
    `passenger_id` bigint                                  NOT NULL AUTO_INCREMENT COMMENT '乘客ID',
    `flight_id`    bigint                                  NOT NULL COMMENT '航班ID',
    `first_name`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '姓',
    `last_name`    varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '名',
    `email`        varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户邮箱',
    `creator`      varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
    `create_time`  datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`      varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
    `update_time`  datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`      bit(1)                                 DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`    bigint                                 DEFAULT '0' COMMENT '租户编号',
    PRIMARY KEY (`passenger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='乘客信息表';


-- flight.`user` definition

CREATE TABLE `user`
(
    `user_id`     bigint                                  NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `email`       varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户邮箱',
    `password`    varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
    `first_name`  varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '姓',
    `last_name`   varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '名',
    `country`     varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '国家',
    `phone`       bigint                                  NOT NULL COMMENT '电话号码',
    `sex`         tinyint                                DEFAULT '0' COMMENT '性别',
    `status`      tinyint                                DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
    `login_ip`    varchar(50) COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '最后登录IP',
    `login_date`  datetime                                NOT NULL COMMENT '最后登录时间',
    `creator`     varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
    `create_time` datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`     varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
    `update_time` datetime                               DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     bit(1)                                 DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1928982677353742339 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';