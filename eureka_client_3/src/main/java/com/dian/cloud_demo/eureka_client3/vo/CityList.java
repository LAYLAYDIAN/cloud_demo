package com.dian.cloud_demo.eureka_client3.vo;


import java.io.Serializable;
import java.util.List;

/**
 * @Description: 城市信息
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 17:27
 * @Version: 1.0
 */
public class CityList  {
    private List<City> cityList;


    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}