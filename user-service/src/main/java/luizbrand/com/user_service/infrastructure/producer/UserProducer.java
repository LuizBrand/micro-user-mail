package luizbrand.com.user_service.infrastructure.producer;

import luizbrand.com.user_service.infrastructure.dto.EmailDTO;
import luizbrand.com.user_service.infrastructure.persistence.UserEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final String rountingKey = "email-queue";

    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendUserCreatedEvent(UserEntity userEntity) {

        EmailDTO emailDTO = new EmailDTO(
                userEntity.getUserID(),
                userEntity.getEmail(),
                "Welcome to my application",
                 "Hello " + userEntity.getName() + ", welcome to my application\n\nThis is new application with microservices"
        );

        rabbitTemplate.convertAndSend("", rountingKey, emailDTO);
    }

}
