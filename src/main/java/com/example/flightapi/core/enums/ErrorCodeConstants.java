package com.example.flightapi.core.enums;

import com.example.flightapi.core.exception.ErrorCode;

/**
 * System 错误码枚举类
 *
 * system 系统，使用 1-002-000-000 段
 */
public interface ErrorCodeConstants {

    ErrorCode FLIGHT_NOT_EXISTS = new ErrorCode(1_002_000_001, "航班信息不存在");
    ErrorCode BOOKING_NOT_EXISTS = new ErrorCode(1_002_000_002, "预订信息不存在");
    ErrorCode AIRPORT_NOT_EXISTS = new ErrorCode(1_002_000_003, "机场信息不存在");
    ErrorCode PASSENGER_NOT_EXISTS = new ErrorCode(1_002_000_004, "乘客信息不存在");
    ErrorCode USER_NOT_EXISTS = new ErrorCode(1_002_000_005, "用户信息不存在");
}
