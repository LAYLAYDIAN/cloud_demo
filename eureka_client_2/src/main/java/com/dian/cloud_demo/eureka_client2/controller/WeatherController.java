package com.dian.cloud_demo.eureka_client2.controller;

import com.dian.cloud_demo.eureka_client2.service.WeatherDataService;
import com.dian.cloud_demo.eureka_client2.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 天气数据action
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 16:42
 * @Version: 1.0
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;


    @GetMapping("/cityid/{cityid}")
    public WeatherResponse getReportByCityid(@PathVariable("cityid") String cityid) {
        return weatherDataService.getDataByCityid(cityid);
    }
    @GetMapping ("/cityName/{cityName}")
    public WeatherResponse getReportByCityName(@PathVariable ("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
