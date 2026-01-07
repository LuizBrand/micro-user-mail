package luizbrand.com.email_service.infrastructure.config;

import luizbrand.com.email_service.core.gateway.EmailGateway;
import luizbrand.com.email_service.core.usecases.SendEmailCase;
import luizbrand.com.email_service.core.usecases.SendEmailCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public SendEmailCase sendEmailCase(EmailGateway emailGateway) {
        return new SendEmailCaseImp(emailGateway);
    }
}
