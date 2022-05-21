package gamersFun.com.example.gamersFun.service;


import gamersFun.com.example.gamersFun.configuration.email.EmailsConfiguration;
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

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;

@Service
public class EmailService {

    @Autowired
    EmailsConfiguration emailsConfiguration;
    @Autowired
    private JavaMailSender mailSender;
    @Value("${mail.enable}")
    private Boolean enable;

    @Value("${site.url}")
    private String siteUrl;

    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private Integer port;
    @Value("${spring.mail.username}")
    private String user;
    @Value("${spring.mail.password}")
    private String password;


//    @Autowired
//    public TemplateEngine EmailService() {
//        TemplateEngine templateEngine = new TemplateEngine();
//        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
//        resolver.setPrefix("mail/");
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode("HTML5");
//        resolver.setCacheable(false);
//        templateEngine.setTemplateResolver(resolver);
//        return templateEngine;
//    }


//    @Async// we should enable it from main method when start app
//    public void sendVerificationEmail(String mail, String token) {
//        Context context = new Context();
//        context.setVariable("token", token);
//        context.setVariable("siteUrl", siteUrl);
//        String emailContent = templateEngine.process("verifyEmail", context);
//
//        System.out.println(emailContent);
//        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
//            @Override
//            public void prepare(MimeMessage mimeMessage) throws Exception {
//                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//                messageHelper.setTo(mail);
//                messageHelper.setCc("odai.1989@gmail.com");
//                messageHelper.setFrom(new InternetAddress("no-replay@gamersFun.com"));
//                messageHelper.setSubject("Please Verify Your email Address");
//                messageHelper.setSentDate(new Date());
//                messageHelper.setText(emailContent, Boolean.TRUE);
//
//            }
//        };
//
//        send(mimeMessagePreparator);
//    }

    private void send(MimeMessagePreparator mimeMessagePreparator) {
        if (enable) {
            mailSender.send(mimeMessagePreparator);
        }
    }

    public Session getEmailSession() {
        final String username = user;
        final String password = this.password;
       Session session = Session.getDefaultInstance(emailsConfiguration.configEmailProperties(), new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }

    public String getVerificationEmailBody(String userName,String verificationToken)  {
        Context context = new Context();
        context.setVariable("name", userName);
        context.setVariable("token", verificationToken);
        context.setVariable("siteUrl", siteUrl);
        String emailContent = emailsConfiguration.emailTemplateEngine().process("/verifyEmail", context);
        System.out.println(emailContent);
        return emailContent;
    }
    @Async
    public void sendVerificationEmail(String userName, String sendEmailTo, String verificationToken,  String BccSendEmailTo) {
        try {
            Session session = getEmailSession();

            String verificationEmailBody = getVerificationEmailBody(userName,verificationToken);
            Message msg = new MimeMessage(session);
            MimeMultipart multipart = new MimeMultipart("related");
            MimeBodyPart body = new MimeBodyPart();
            body.setContent(verificationEmailBody, "text/html; charset=UTF-8");
            multipart.addBodyPart(body);
            multipart = addYeloEmailImages(multipart);
            msg.setFrom(new InternetAddress(user));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendEmailTo, false));
            msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(BccSendEmailTo, false));
            msg.setSubject("Please verify your email");
            msg.setContent(multipart);
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Message sent.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public MimeMultipart addYeloEmailImages(MimeMultipart multipart) throws MessagingException {
        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "\\src\\main\\resources\\templates\\mail\\imgs" + "\\logo.png", "<high-logo>");
//        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "\\src\\main\\resources\\templates\\mail\\imgs" + "\\website-icon.png", "<web-icon>");
//        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "\\src\\main\\resources\\templates\\mail\\imgs" + "\\facebook-icon.png", "<facebook-icon>");
//        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "\\src\\main\\resources\\templates\\mail\\imgs" + "\\twitter-icon.png", "<twitter-icon>");
//        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "\\src\\main\\resources\\templates\\mail\\imgs" + "\\linkedin-icon.png", "<linkedin-icon>");
        return multipart;
    }

    public MimeMultipart addMultiPartFile(MimeMultipart multipart, String filePath, String fileId) throws MessagingException {
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        DataSource linkedInLogo = new FileDataSource(filePath);
        messageBodyPart.setDataHandler(new DataHandler(linkedInLogo));
        messageBodyPart.setHeader("Content-ID", fileId);
        multipart.addBodyPart(messageBodyPart);
        return multipart;
    }


}


