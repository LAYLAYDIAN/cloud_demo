package com.dian.cloud_demo.eureka_client2.service.impl;


import com.dian.cloud_demo.eureka_client2.service.WeatherDataService;
import com.dian.cloud_demo.eureka_client2.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Description: 天气数据实现类
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 16:32
 * @Version: 1.0
 */
@Service
public class WeatherDataServiceImpl  implements WeatherDataService {
    private final String WEATHER_API ="http://wthrcdn.etouch.cn/weather_mini";
    private final Long TIME_OUT= 1800L; //缓存超时时间
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final static Logger logger= LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    @Override
    public WeatherResponse getDataByCityid(String cityid){
        String uri = WEATHER_API + "?citykey="+ cityid;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName){
        String uri =WEATHER_API +"?city="+ cityName;
        return this.doGetWeatherData(uri);
    }

    private WeatherResponse doGetWeatherData(String uri) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String key = uri;
        String strBody = null;

        if ( !this.stringRedisTemplate.hasKey(key)){
            logger.error("不存在 key "+ key);
            throw new RuntimeException ("没有相应的天气信息");
        }else {
            logger.error("存在 key "+ key+", value="+ops.get (key));
            strBody = ops.get(key);
        }

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            logger.error("JSON反序列化异常",e);
            throw new RuntimeException("”天气信息解析失败”");
        }
        return weather;
    }
}
