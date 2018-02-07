package com.fluentWait.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
public class ViewConfig {

   /* @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix(("/WEB-INF/"));
        internalResourceViewResolver.setSuffix(".html");
        internalResourceViewResolver.setOrder(1);
        return internalResourceViewResolver;
    }
*/

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix(("/WEB-INF/"));
        internalResourceViewResolver.setSuffix(".html");
        internalResourceViewResolver.setOrder(1);
        return internalResourceViewResolver;
    }

}
