package com.wisely.highlight_spring4.ch3.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowCondition.class)//符合条件则实例化windowsListService
    public ListService windowsListService(){
        return new WindowListService();
    }
    @Bean
    @Conditional(LinuxCondition.class)//符合条件则实例化LinuxListService
    public ListService linuxListService(){
        return new LinuxListService();
    }
}
