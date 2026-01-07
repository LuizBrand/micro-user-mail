package luizbrand.com.email_service.infrastructure.consumer;

import luizbrand.com.email_service.infrastructure.dto.EmailDTO;
import luizbrand.com.email_service.infrastructure.persistence.EmailEntity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    //Listener do consumer
    @RabbitListener(queues = "email-queue")
    public void listenEmailQueue(@Payload EmailDTO emailDTO) {
        EmailEntity email = new EmailEntity();
        BeanUtils.copyProperties(emailDTO, email);
    }

}
