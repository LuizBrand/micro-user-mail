package luizbrand.com.user_service.infrastructure.getway;

import jakarta.transaction.Transactional;
import luizbrand.com.user_service.core.domain.User;
import luizbrand.com.user_service.core.gateway.UserGateway;
import luizbrand.com.user_service.infrastructure.mapper.UserEntityMapper;
import luizbrand.com.user_service.infrastructure.persistence.UserEntity;
import luizbrand.com.user_service.infrastructure.persistence.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public User createUser(User newUser) {

        UserEntity savedUser = userRepository.save(userMapper.toUserEntity(newUser));
        return userMapper.toDomain(savedUser);

    }

    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        return user.map(userMapper::toDomain);
    }
}