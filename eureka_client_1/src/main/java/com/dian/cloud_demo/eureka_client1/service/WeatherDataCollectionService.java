package com.dian.cloud_demo.eureka_client1.service;

/**
 * @Description: 天气数据采集服务
 * @Author: Liu Guo Dian
 * @Date: 2020/8/5 19:55
 * @Version: 1.0
 */
public interface WeatherDataCollectionService {
    /**
     * 根据城市代码同步天气数据
     * */
    void syncDataByCityid(String cityid);
}
