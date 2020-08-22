package com.dian.cloud_demo.eureka_client3.controller;

import com.dian.cloud_demo.eureka_client3.service.WeatherReportService;
import com.dian.cloud_demo.eureka_client3.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Liu Guo Dian
 * @Date: 2020/8/12 19:57
 * @Version: 1.0
 */
public class WeatherReportController {
    @Autowired
    private WeatherReportService weatherReportService;
    @GetMapping("/cityid/{cityid}")
    public ModelAndView getReportByCityid(@PathVariable("cityid") String cityid, Model model) {
        List<City> cityList = new ArrayList<>();
        cityList =new ArrayList<>();
        City city = new City() ;
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);
        model.addAttribute("title","老卫的天气预报");
        return new ModelAndView("weather/report","reportModel", model);
    }
}
