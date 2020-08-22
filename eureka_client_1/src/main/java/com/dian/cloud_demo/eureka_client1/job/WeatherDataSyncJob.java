package com.dian.cloud_demo.eureka_client1.job;

import com.dian.cloud_demo.eureka_client1.service.WeatherDataCollectionService;
import com.dian.cloud_demo.eureka_client1.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 天气数据同步
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 17:10
 * @Version: 1.0
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    private final static Logger logger= LoggerFactory.getLogger(WeatherDataSyncJob.class);
    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("开始同步");
        List<City> cityList = new ArrayList<>();
        try {
            City city=new City();
            city.setCityId("101280601");
            cityList.add(city);
        }catch (Exception e) {
            throw new RuntimeException("获取城市信息异常",e);
        }
        for (City city:cityList){
               String cityId =city.getCityId();
            weatherDataCollectionService.syncDataByCityid(cityId);
        }
    }
}
