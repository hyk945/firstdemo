package com.hyk.controller;

import com.hyk.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Description:
 * Author: ykhuang
 * Version: 1.0
 * Create Date Time: 2019/4/4 9:56.
 * Update Date Time:
 */
@RestController
@RequestMapping("city")
@Slf4j
public class CityController {

    @Resource
    private CityService cityService;

    @GetMapping(value = "/getById")
    public String getCityById(BigDecimal id){
        return  "带斜杠的返回值:"+cityService.getCityById(id).toString();
    }

    @GetMapping(value = "getById")
    public String getCityByIdNoSign(BigDecimal id){
        return  "不带斜杠的返回值:"+cityService.getCityById(id).toString();
    }
}
