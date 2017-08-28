package com.njwtframework.web.quartz;

import org.springframework.context.annotation.Configuration;  
import org.springframework.scheduling.annotation.EnableScheduling;  
import org.springframework.stereotype.Component;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory; 
@Configuration  
@Component // 此注解必加  
@EnableScheduling // 此注解必加  
public class ScheduleTask {  
    private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);  
    public void sayHello(){  
        LOGGER.info("Hello world, i'm the king of the world!!!");  
    }  
}  