package com.hyk.service;

import com.hyk.pojo.City;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Description:
 * Author: ykhuang
 * Version: 1.0
 * Create Date Time: 2019/4/4 9:19.
 * Update Date Time:
 *
 * @see
 */
@Service
public interface CityService {

    City getCityById(BigDecimal id);
}
