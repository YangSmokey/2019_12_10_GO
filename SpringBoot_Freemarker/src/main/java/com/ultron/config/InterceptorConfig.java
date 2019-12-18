package com.ultron.config;

import com.ultron.interceptor.HelloInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author pixel
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HelloInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}