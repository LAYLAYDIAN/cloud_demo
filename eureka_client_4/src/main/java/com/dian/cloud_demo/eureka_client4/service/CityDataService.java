package com.dian.cloud_demo.eureka_client4.service;

import com.dian.cloud_demo.eureka_client4.vo.City;

import java.util.List;

/**
 * @Description: 城市服务
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 17:34
 * @Version: 1.0
 */
public interface CityDataService {
     /**
      *获取城市列表
      * */
    List<City> listCity() throws Exception;
}
