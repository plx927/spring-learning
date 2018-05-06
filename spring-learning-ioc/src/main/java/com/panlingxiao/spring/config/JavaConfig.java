package com.panlingxiao.spring.config;

import com.panlingxiao.spring.service.FunctionService;
import com.panlingxiao.spring.service.UseFunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService(FunctionService fs) {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(fs);
        return useFunctionService;

    }
}
