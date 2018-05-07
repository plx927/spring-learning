package com.panlingxiao.spring.profile;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

    @Bean
    @Profile("prod")
    public DemoBean prod() {
        return new DemoBean("prod");
    }

    @Bean
    @Profile("dev")
    public DemoBean dev() {
        return new DemoBean("dev");
    }
}
