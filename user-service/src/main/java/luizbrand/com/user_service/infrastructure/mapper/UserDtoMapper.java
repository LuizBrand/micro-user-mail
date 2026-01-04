package luizbrand.com.user_service.infrastructure.mapper;

import luizbrand.com.user_service.core.domain.User;
import luizbrand.com.user_service.infrastructure.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDtoMapper {

    public User toDomain(UserDTO user) {
        return new User(
                null,
                user.name(),
                user.email()
        );
    }

    public UserDTO toUserDto(User user) {
        return new UserDTO(
                user.name(),
                user.email()
        );
    }

}
