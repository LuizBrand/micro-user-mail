package luizbrand.com.user_service.infrastructure.mapper;

import luizbrand.com.user_service.core.domain.User;
import luizbrand.com.user_service.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public User toDomain(UserEntity user) {
        return new User(
                user.getUserID(),
                user.getName(),
                user.getEmail()
        );
    }

    public UserEntity toUserEntity(User user) {
        return new UserEntity(
                user.userId(),
                user.name(),
                user.email()
        );
    }

}
