package luizbrand.com.email_service.infrastructure.consumer;

import luizbrand.com.email_service.infrastructure.dto.EmailDTO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    //Listener do consumer
    @RabbitListener(queues = "email-queue")
    @RabbitHandler
    public void listenEmailQueue(@Payload EmailDTO emailDTO) {
        System.out.println(emailDTO.emailTo());
    }

}
