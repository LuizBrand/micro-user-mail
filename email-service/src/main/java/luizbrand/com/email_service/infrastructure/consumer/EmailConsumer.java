package luizbrand.com.email_service.infrastructure.consumer;

import luizbrand.com.email_service.core.usecases.SendEmailCase;
import luizbrand.com.email_service.infrastructure.dto.EmailDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final SendEmailCase sendEmailCase;

    public EmailConsumer(SendEmailCase sendEmailCase) {
        this.sendEmailCase = sendEmailCase;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listenEmailQueue(@Payload EmailDTO emailDTO) {
        sendEmailCase.execute(emailDTO);
    }
}
