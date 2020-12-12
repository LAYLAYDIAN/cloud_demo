package com.dian.cloud_demo.eureka_client1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 测试接口
 * @Author: Liu Guo Dian
 * @Date: 2020/12/12 16:08
 * @Version: 1.0
 */
@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/hello")
    public Map<String, Object> hello(@RequestParam(value = "consumerApplicationName", required = false) String consumerApplicationName) {
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("code", 200);
        resultMap.put("messages", "成功");
        //生产者服务启动端口
        resultMap.put("providerServerPort", port);
        //生产者服务名称
        resultMap.put("providerApplicationName",applicationName);
        //消费者服务名称
        resultMap.put("consumerApplicationName", consumerApplicationName);
        log.info(" [ 服务生产者 {} ]  >> hello method end , reqApplicationName:{} , resultMap:{}", applicationName, consumerApplicationName, resultMap);
        return resultMap;
    }
}
