package gamersFun.com.example.gamersFun.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

@Configuration
public class MailConfig {
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

    public void sendReportEmail(String emailSubject, String content, String sendEmailTo, String BccSendEmailTo) {
        final String username = user;
        final String password = this.password;
        try {
            Session session = Session.getDefaultInstance(configEmailProperties(),
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            Message msg = new MimeMessage(session);
            MimeMultipart multipart = new MimeMultipart("related");
            MimeBodyPart body = new MimeBodyPart();
            body.setContent(content, "text/html; charset=UTF-8");
            multipart.addBodyPart(body);
            multipart = addYeloEmailImages(multipart);
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendEmailTo, false));
            msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(BccSendEmailTo, false));
            msg.setSubject(emailSubject);
            msg.setContent(multipart);
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Message sent.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public MimeMultipart addYeloEmailImages(MimeMultipart multipart) throws MessagingException {
        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "email html" + "\\logo high.png", "<high-logo>");
        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "email html" + "\\website-icon.png", "<web-icon>");
        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "email html" + "\\facebook-icon.png", "<facebook-icon>");
        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "email html" + "\\twitter-icon.png", "<twitter-icon>");
        addMultiPartFile(multipart, System.getProperty("user.dir") + "\\" + "email html" + "\\linkedin-icon.png", "<linkedin-icon>");
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
