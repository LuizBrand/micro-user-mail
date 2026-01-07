package luizbrand.com.email_service.infrastructure.gateway;

import jakarta.transaction.Transactional;
import luizbrand.com.email_service.core.enums.EmailStatus;
import luizbrand.com.email_service.core.gateway.EmailGateway;
import luizbrand.com.email_service.infrastructure.dto.EmailDTO;
import luizbrand.com.email_service.infrastructure.persistence.EmailEntity;
import luizbrand.com.email_service.infrastructure.persistence.EmailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EmailRespositoryGateway implements EmailGateway {

    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public EmailRespositoryGateway(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    @Override
    @Transactional
    public EmailEntity sendEmail(EmailDTO emailDTO) {
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailDTO, emailEntity);
        emailEntity.setEmailSendDate(LocalDateTime.now());
        emailEntity.setEmailFrom(emailFrom);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailEntity.getEmailFrom());
            message.setTo(emailEntity.getEmailTo());
            message.setSubject(emailEntity.getEmailSubject());
            message.setText(emailEntity.getEmailBody());
            emailSender.send(message);

            emailEntity.setEmailStatus(EmailStatus.SENT);
        } catch (MailException e) {
            emailEntity.setEmailStatus(EmailStatus.FAILED);
        }
        return emailRepository.save(emailEntity);
    }
}
