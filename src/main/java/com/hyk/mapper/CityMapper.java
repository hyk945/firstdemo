package com.hyk.mapper;

import com.hyk.pojo.City;

import java.math.BigDecimal;

/**
 * Description:
 * Author: ykhuang
 * Version: 1.0
 * Create Date Time: 2019/4/4 9:15.
 * Update Date Time:
 *
 * @see
 */
public interface CityMapper {

    City getCityById(BigDecimal id);
}
