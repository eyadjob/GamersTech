package gamersFun.com.example.gamersFun.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/*@Configuration*/
public class ResourceBundleConfig {
    public static final String RESOURCE_BUNDLE_LOCATION = "WEB-INF/validationMessages/validationMessages";

    /*@Bean*/
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(RESOURCE_BUNDLE_LOCATION);
        //messageSource.setBasename("file:///media/ssd/messages");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }
}
