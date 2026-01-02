package luizbrand.com.email_service.infrastructure.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    //Listener do consumer
    @RabbitListener(queues = "email-queue")
    public void listenEmailQueue(@Payload String string) {
        System.out.println(string);
    }

}
