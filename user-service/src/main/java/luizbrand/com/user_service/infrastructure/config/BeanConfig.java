package luizbrand.com.user_service.infrastructure.config;

import luizbrand.com.user_service.core.gateway.UserGateway;
import luizbrand.com.user_service.core.usecases.CreateUserCase;
import luizbrand.com.user_service.core.usecases.CreateUserCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateUserCase createUserCase(UserGateway userGateway) {
        return new CreateUserCaseImp(userGateway);
    }

}
