package com.dian.cloud_demo.eureka_client1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: rest配置类
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 16:49
 * @Version: 1.0
 */
@Configuration
public class RestConfiguration {
    @Autowired
    private RestTemplateBuilder builder;
    @Bean
    public RestTemplate restTemplate(){
           return builder.build();
}
}
