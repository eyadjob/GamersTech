package gamersFun.com.example.gamersFun.configuration.email;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import java.util.Properties;

/**
 * configuration class for Metrics email server Created by eyadm@amazon.com on 3/12/18.
 */
@Component
@Configuration
@PropertySource("application.properties")
@Getter
public class EmailsConfiguration {

    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private Integer port;
    @Value("${spring.mail.username}")
    private String user;
    @Value("${spring.mail.password}")
    private String password;

    @Bean
    public Properties configEmailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.required", "true");
//      props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return props;
    }


    public Multipart attachFiles(String[] attachmentFilePath, Multipart multipart) {

        if (attachmentFilePath != null) {
            for (String filePath : attachmentFilePath) {
                if (!StringUtils.hasText(filePath) || !filePath.equals(" ")) {
                    try {
                        MimeBodyPart messageBodyPart = new MimeBodyPart();
                        DataSource source = new FileDataSource(filePath);
                        messageBodyPart.setDataHandler(new DataHandler(source));
                        messageBodyPart.setFileName(filePath.substring(filePath.lastIndexOf("\\") + 1));
                        multipart.addBodyPart(messageBodyPart);
                    } catch (Exception e) { // used general exception in case of any error
                        // ignore file but log the exception
                        System.out.println("Error while adding an attachment to email");
                    }
                }
            }
        }
        return multipart;
    }

    /**
     * this method build the message resource for metric email
     *
     * @return message resource for metric email
     */
    @Bean
    public ResourceBundleMessageSource emailMessageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("mail/MailMessages");
        return messageSource;
    }

    /**
     * build a template engine based on a specific template resolver
     *
     * @return template engine
     */
    @Bean
    public TemplateEngine emailTemplateEngine() {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // Resolver for HTML editable emails (which will be treated as a String)
        templateEngine.addTemplateResolver(EmailHtmlTemplateResolver());
        // Message source, internationalization specific to emails
        templateEngine.setTemplateEngineMessageSource(emailMessageSource());
        return templateEngine;
    }

    /**
     * this method build the spring resource template resolver
     *
     * @return Spring Resource Template Resolver
     */
    @Bean
    @Description("Thymeleaf template resolver for email ")
    public SpringResourceTemplateResolver EmailHtmlTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/mail");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
}
