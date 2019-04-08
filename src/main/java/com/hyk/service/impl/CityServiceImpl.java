package com.hyk.service.impl;

import com.hyk.mapper.CityMapper;
import com.hyk.pojo.City;
import com.hyk.service.CityService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Description:
 * Author: ykhuang
 * Version: 1.0
 * Create Date Time: 2019/4/4 9:23.
 * Update Date Time:
 */
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public City getCityById(BigDecimal id) {

        return cityMapper.getCityById(id);
    }
}
