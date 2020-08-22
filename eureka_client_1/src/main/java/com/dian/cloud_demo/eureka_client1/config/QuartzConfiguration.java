package com.dian.cloud_demo.eureka_client1.config;

import com.dian.cloud_demo.eureka_client1.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 定时任务配置文件
 * @Author: Liu Guo Dian
 * @Date: 2020/8/4 17:13
 * @Version: 1.0
 */
@Configuration
public class QuartzConfiguration {
    private final int TIME= 1800; //更新频率
    @Bean
    public JobDetail weatherDataSyncJobJobDetail(){
           return JobBuilder.newJob(WeatherDataSyncJob.class).
                   withIdentity("weatherDataSyncJob").storeDurably().build();
    }
    @Bean
    public Trigger sampleJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();
          return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail())
                  .withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }
}
