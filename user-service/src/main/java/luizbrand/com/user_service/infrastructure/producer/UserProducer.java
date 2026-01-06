package luizbrand.com.user_service.infrastructure.producer;

import luizbrand.com.user_service.infrastructure.persistence.UserEntity;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanout;

    public UserProducer(RabbitTemplate rabbitTemplate, FanoutExchange fanout) {
        this.rabbitTemplate = rabbitTemplate;
        this.fanout = fanout;
    }

    public void sendUserCreatedEvent(UserEntity userEntity) {

    }

}
