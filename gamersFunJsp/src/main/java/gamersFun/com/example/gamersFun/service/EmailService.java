package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.configuration.email.EmailsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

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

    public Session getEmailSession() {
        final String username = emailsConfiguration.getUser();
        final String password = emailsConfiguration.getPassword();
        Session session = Session.getDefaultInstance(emailsConfiguration.configEmailProperties(), new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }

    public String getVerificationEmailBody(String userName, String verificationToken) {
        Context context = new Context();
        context.setVariable("name", userName);
        context.setVariable("token", verificationToken);
        context.setVariable("siteUrl", siteUrl);
        String emailContent = emailsConfiguration.emailTemplateEngine().process("/verifyEmail", context);
        System.out.println(emailContent);
        return emailContent;
    }

    @Async
    public void sendVerificationEmail(String userName, String sendEmailTo, String verificationToken, String BccSendEmailTo) {
        try {
            Session session = getEmailSession();

            String verificationEmailBody = getVerificationEmailBody(userName, verificationToken);
            Message msg = new MimeMessage(session);
            MimeMultipart multipart = new MimeMultipart("related");
            MimeBodyPart body = new MimeBodyPart();
            body.setContent(verificationEmailBody, "text/html; charset=UTF-8");
            multipart.addBodyPart(body);
            multipart = addYeloEmailImages(multipart);
            msg.setFrom(new InternetAddress(emailsConfiguration.getUser()));
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


