package com.dian.cloud_demo.eureka_client1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @Description: 启动类
 * @Author: Liu Guo Dian
 * @Date: 2020/7/31 16:21
 * @Version: 1.0
 */

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
