package com.dian.cloud_demo.eureka_client4.controller;

import com.dian.cloud_demo.eureka_client4.service.CityDataService;
import com.dian.cloud_demo.eureka_client4.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Description:
 * @Author: Liu Guo Dian
 * @Date: 2020/8/12 20:12
 * @Version: 1.0
 */
public class CityController {
    @Autowired
    private CityDataService cityDataService ;
    @GetMapping
    public List<City> listCity(){
        return null;
    }
}
