package com.dian.cloud_demo.eureka_client4.service;

import com.dian.cloud_demo.eureka_client4.hystrix.FeignServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description: 调用生产者测试接口
 * @FeignClient注解fallback属性指定断路实现 value属性指定服务名称
 * @Author: Liu Guo Dian
 * @Date: 2020/12/12 16:00
 * @Version: 1.0
 */
@FeignClient(value = "producer", fallback = FeignServiceHystric.class)
public interface FeignServiceApi {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    Map<String, Object> hello(@RequestParam(value = "consumerApplicationName") String consumerApplicationName);
}
