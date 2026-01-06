package luizbrand.com.user_service.infrastructure.gateway;

import jakarta.transaction.Transactional;
import luizbrand.com.user_service.core.domain.User;
import luizbrand.com.user_service.core.gateway.UserGateway;
import luizbrand.com.user_service.infrastructure.mapper.UserDtoMapper;
import luizbrand.com.user_service.infrastructure.mapper.UserEntityMapper;
import luizbrand.com.user_service.infrastructure.persistence.UserEntity;
import luizbrand.com.user_service.infrastructure.persistence.UserRepository;
import luizbrand.com.user_service.infrastructure.producer.UserProducer;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final UserProducer userProducer;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.userProducer = userProducer;
    }

    @Override
    @Transactional
    public User createUser(User newUser) {

        UserEntity savedUser = userRepository.save(userEntityMapper.toUserEntity(newUser));
        userProducer.sendUserCreatedEvent(savedUser);
        return userEntityMapper.toDomain(savedUser);

    }

    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        return user.map(userEntityMapper::toDomain);
    }
}