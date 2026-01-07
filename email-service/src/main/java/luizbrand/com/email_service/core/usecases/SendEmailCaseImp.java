package luizbrand.com.email_service.core.usecases;

import luizbrand.com.email_service.core.gateway.EmailGateway;
import luizbrand.com.email_service.infrastructure.dto.EmailDTO;
import luizbrand.com.email_service.infrastructure.persistence.EmailEntity;

public class SendEmailCaseImp implements SendEmailCase {

    private final EmailGateway emailGateway;

    public SendEmailCaseImp(EmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    @Override
    public EmailEntity execute(EmailDTO emailDTO) {
        return emailGateway.sendEmail(emailDTO);
    }
}
