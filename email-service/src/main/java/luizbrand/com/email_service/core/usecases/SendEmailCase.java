package luizbrand.com.email_service.core.usecases;

import luizbrand.com.email_service.infrastructure.dto.EmailDTO;
import luizbrand.com.email_service.infrastructure.persistence.EmailEntity;

public interface SendEmailCase {
    EmailEntity execute(EmailDTO emailDTO);
}
