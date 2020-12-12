package com.dian.cloud_demo.eureka_client4.hystrix;

import com.dian.cloud_demo.eureka_client4.service.FeignServiceApi;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: Hystric 组件
 * @Author: Liu Guo Dian
 * @Date: 2020/12/12 16:45
 * @Version: 1.0
 */
@Component
public class FeignServiceHystric implements FeignServiceApi {
    @Override
    public Map<String, Object> hello(String consumerApplicationName) {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("code", 500);
        resultMap.put("messages", "网络繁忙，请稍后再试");
        resultMap.put("consumerApplicationName", consumerApplicationName);
        return resultMap;
    }
}
