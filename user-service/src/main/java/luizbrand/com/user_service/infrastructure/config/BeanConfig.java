package luizbrand.com.user_service.infrastructure.config;

import luizbrand.com.user_service.core.gateway.UserGateway;
import luizbrand.com.user_service.core.usecases.CreateUserCase;
import luizbrand.com.user_service.core.usecases.CreateUserCaseImp;
import luizbrand.com.user_service.core.usecases.ListUsersCase;
import luizbrand.com.user_service.core.usecases.ListUsersCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateUserCase createUserCase(UserGateway userGateway) {
        return new CreateUserCaseImp(userGateway);
    }

    @Bean
    public ListUsersCase listUsersCase(UserGateway userGateway) {
        return new ListUsersCaseImp(userGateway);
    }

}
