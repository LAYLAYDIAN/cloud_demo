package com.dian.cloud_demo.eureka_client2.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: Service-Api接口，通过restTemplate来消费生成者服务的“/hello”接口，
 *              可以直接用服务名，替代了具体的url地址,Ribbon会根据服务名来选择具体的服务实例，
 *              根据服务实例在请求的时 候会用具体的url替换掉服务名。
 * @Author: Liu Guo Dian
 * @Date: 2020/12/12 16:29
 * @Version: 1.0
 */
@Service
public class ServiceApi {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hystrixError")
    public Map<String, Object> hello(String consumerApplicationName) {
        return restTemplate.getForObject("http://producer/hello?consumerApplicationName=" + consumerApplicationName, Map.class);
    }

    public Map<String, Object> hystrixError(String consumerApplicationName) {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("code", 500);
        resultMap.put("messages", "网络繁忙，请稍后再试");
        resultMap.put("consumerApplicationName", consumerApplicationName);
        return resultMap;
    }
}
