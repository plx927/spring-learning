package com.panlingxiao.spring.aware;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    @Override
    public void setBeanName(String s) {
        log.info("beanName:{}", s);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        log.info("resourceLoader:{}", resourceLoader);
        Resource resource = resourceLoader.getResource("classpath:logback.xml");
        try {
            List<String> strings = IOUtils.readLines(resource.getInputStream());
            strings.forEach(log::info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
