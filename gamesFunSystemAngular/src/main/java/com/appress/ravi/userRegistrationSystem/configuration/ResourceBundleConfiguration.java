package com.appress.ravi.userRegistrationSystem.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ResourceBundleConfiguration {
        @Bean(name = "messageSource")
        public ReloadableResourceBundleMessageSource messageSource(){
            ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
            resourceBundleMessageSource.setBasename("classpath:messages/messages");
            resourceBundleMessageSource.setDefaultEncoding("UTF-8");
            return resourceBundleMessageSource;
        }

}
