package com.dian.cloud_demo.eureka_client1.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @Description: 城市信息
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 17:27
 * @Version: 1.0
 */
public class City implements Serializable {


    private static final long serialVersionUID = -90000080L;
    private String cityId;


    private String cityName;


    private String cityCode;


    private String province;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}