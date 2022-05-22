package gamersFun.com.example.gamersFun.configuration;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// This class used to remove scripts tags from textarea and allow html tags
public class SanitizerConfig {

    @Bean
    PolicyFactory getUserHtmlPolicy(){
        return new HtmlPolicyBuilder().allowCommonBlockElements()
                .allowCommonInlineFormattingElements().toFactory();
    }
}
