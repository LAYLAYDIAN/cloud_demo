package com.dian.cloud_demo.eureka_client3.service.impl;

import com.dian.cloud_demo.eureka_client3.service.WeatherReportService;
import com.dian.cloud_demo.eureka_client3.vo.Forecast;
import com.dian.cloud_demo.eureka_client3.vo.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 天气预报实现类
 * @Author: Liu Guo Dian
 * @Date: 2020/8/12 19:45
 * @Version: 1.0
 */
public class WeatherReportServ卐icelmpl implements WeatherReportService {
    @Override
    public Weather getDataByCityid(String cityid) {
        Weather data= new Weather() ;
        data.setAqi ("81");
        data.setCity("深圳");
        data.setGanmao("各项气象条件适宜，无明显降温过程，发生感冒机率较低。");
        data.setWendu("22");
        List<Forecast> forecastList =new ArrayList<>();
        Forecast forecast =new Forecast();
        forecast.setDate("29 日星期天”");
        forecast.setType("多云");
        forecast.setFengxiang("无持续风向");
        forecast.setHigh("高温 27·c ");
        forecast.setLow("低 20 ");
        forecastList.add(forecast) ;
        forecast =new Forecast();
        forecast.setDate("28 日星期天”");
        forecast.setType("多云");
        forecast.setFengxiang("无持续风向");
        forecast.setHigh("高温 27·c ");
        forecast.setLow("低 20 ");
        forecastList.add(forecast) ;
        return data ;
    }
}
