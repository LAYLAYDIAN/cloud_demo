package com.dian.cloud_demo.eureka_client3.service;

import com.dian.cloud_demo.eureka_client3.vo.Weather;

/**
 * @Description: 天气预报服务接口
 * @Author: Liu Guo Dian
 * @Date: 2020/8/12 19:44
 * @Version: 1.0
 */
public interface WeatherReportService {

    /**
     * 根据城市ID来查询天气数据
     *param cityid
     * @return
     */
    Weather getDataByCityid(String cityid) ;
}
