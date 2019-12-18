package com.ultron.config;

import com.ultron.filter.HelloFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pixel
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean RegisterFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new HelloFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("HelloFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}