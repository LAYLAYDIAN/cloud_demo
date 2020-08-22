package com.dian.cloud_demo.eureka_client2.service;


import com.dian.cloud_demo.eureka_client2.vo.WeatherResponse;

/**
 * @Description: 天气数据服务
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 16:26
 * @Version: 1.0
 */
public interface WeatherDataService {
    /**
     * 根据城市ID来查询天气数据
     *param cityid
     * @return
     */
    WeatherResponse getDataByCityid(String cityid) ;
    /**
     * 根据城市名称来查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse  getDataByCityName(String cityName);

}
