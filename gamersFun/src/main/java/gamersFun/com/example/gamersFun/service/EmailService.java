package gamersFun.com.example.gamersFun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private TemplateEngine templateEngine;

    @Value("${mail.enable}")
    private Boolean enable;

    @Value("${site.url}")
    private String siteUrl;


    @Autowired
    public EmailService(TemplateEngine templateEngine){
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("mail/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(false);
        templateEngine.setTemplateResolver(resolver);
        this.templateEngine = templateEngine;
    }


    @Async// we should enable it from main method when start app
    public void sendVerficationEmail(String mail,String token){

       /* try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Context context = new Context();
        context.setVariable("email",mail);
        context.setVariable("token",token);
        context.setVariable("siteUrl",siteUrl);
        String emailContent = templateEngine.process("verifyEmail",context);

        System.out.println(emailContent);

        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setTo(mail);
                messageHelper.setCc("odai.1989@gmail.com");
                messageHelper.setFrom(new InternetAddress("no-replay@gamersFun.com"));
                messageHelper.setSubject("Please Verify Your email Address");
                messageHelper.setSentDate(new Date());
                messageHelper.setText(emailContent,Boolean.TRUE);

            }
        };

        send(mimeMessagePreparator);
    }

    private void send(MimeMessagePreparator mimeMessagePreparator) {
        if(enable){
            mailSender.send(mimeMessagePreparator);
        }
    }



}


