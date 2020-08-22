package com.dian.cloud_demo.eureka_client1.service.impl;

import com.dian.cloud_demo.eureka_client1.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 天气数据采集服务实现类
 * @Author: Liu Guo Dian
 * @Date: 2020/8/5 19:56
 * @Version: 1.0
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
    @Autowired
    private RestTemplate restTemplate ;
    private final String WEATHER_API ="http://wthrcdn.etouch.cn/weather_mini";
    //缓存超时时间
    private final Long TIME_OUT= 1800L;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void syncDataByCityid(String cityid) {
        String uri = WEATHER_API + "?citykey="+ cityid;
        this.saveWeatherData(uri);
    }

    private void saveWeatherData(String uri) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String key = uri;
        String strBody = null;
        ResponseEntity<String> response= restTemplate.getForEntity(uri, String.class);
        if (response.getStatusCodeValue () == 200 ) {
            strBody = response.getBody();
        }
        ops.set(key,strBody,TIME_OUT, TimeUnit.SECONDS);
    }
}
