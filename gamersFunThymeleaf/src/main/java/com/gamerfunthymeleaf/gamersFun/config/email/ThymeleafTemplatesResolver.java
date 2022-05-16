package com.gamerfunthymeleaf.gamersFun.config.email;


import lombok.extern.slf4j.Slf4j;
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
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * configuration class for Metrics email server Created by eyadm@amazon.com on 3/12/18.
 */
@Component
@Configuration
@PropertySource("application.properties")
@Slf4j
public class ThymeleafTemplatesResolver {


    public MimeMessage setRecipients(MimeMessage message, List<String> cc, List<String> to) {
        try {
            if (cc != null) {
                List<InternetAddress> ccInternetAddresses = new ArrayList<>();
                for (String ccTemp : cc) {
                    ccInternetAddresses.add(new InternetAddress(ccTemp.trim()));
                }
                if (!ccInternetAddresses.isEmpty()) {
                    message.setRecipients(
                            Message.RecipientType.CC,
                            ccInternetAddresses.toArray(new InternetAddress[ccInternetAddresses.size()]));
                }
            }
            List<InternetAddress> toInternetAddresses = new ArrayList<>();
            for (String toTemp : to) {
                toInternetAddresses.add(new InternetAddress(toTemp.trim()));
            }

            message.setRecipients(Message.RecipientType.TO, toInternetAddresses.toArray(new InternetAddress[toInternetAddresses.size()]));

        } catch (Exception exception) {
            log.info(exception.getMessage());
        }
        return message;
    }

    public Session createSession(Properties properties) {
        return Session.getDefaultInstance(properties);

    }

    public Multipart attachFiles(String[] attachmentFilePath, Multipart multipart) {

        if (attachmentFilePath != null) {
            for (String filePath : attachmentFilePath) {
                if (!StringUtils.isEmpty(filePath) || !filePath.equals(" ")) {
                    try {
                        MimeBodyPart messageBodyPart = new MimeBodyPart();
                        DataSource source = new FileDataSource(filePath);
                        messageBodyPart.setDataHandler(new DataHandler(source));
                        messageBodyPart.setFileName(filePath.substring(filePath.lastIndexOf("\\") + 1));
                        multipart.addBodyPart(messageBodyPart);
                    } catch (Exception e) { // used general exception in case of any error
                        // ignore file but log the exception
                        log.error("Error while adding an attachment to email", e);
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
        templateEngine.addTemplateResolver(htmlTemplateResolver());
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
    public SpringResourceTemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
}
