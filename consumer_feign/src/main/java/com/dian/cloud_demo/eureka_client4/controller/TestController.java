package com.dian.cloud_demo.eureka_client4.controller;

import com.dian.cloud_demo.eureka_client4.service.FeignServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description: 服务消费者-测试 controller
 * @Author: Liu Guo Dian
 * @Date: 2020/12/12 16:17
 * @Version: 1.0
 */
@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Value("${spring.application.name}")
    private String applicationName;


    @Autowired
    private FeignServiceApi feignServiceApi;

    @RequestMapping("/hello")
    public Map<String, Object> hello() {
        log.info(" [ Feign 消费者 {} ]  >> hello method start ", applicationName);
        Map<String, Object> resultMap = feignServiceApi.hello(applicationName);
        log.info(" [ Feign 消费者 {} ]  >> hello method end , resultMap: {}", applicationName, resultMap);
        return resultMap;
    }
}
