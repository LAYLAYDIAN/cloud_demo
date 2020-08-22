package com.dian.cloud_demo.eureka_client2.vo;

import java.io.Serializable;

/**
 * @Description: 消息返回结果集
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 16:19
 * @Version: 1.0
 */
public class WeatherResponse  implements Serializable {
    private static final long serialVersionUID = -90023490L;
    private Weather data;  //消息数据
    private String status;   //消息状态
    private String desc;  //消息描述

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
