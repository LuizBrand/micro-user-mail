package luizbrand.com.user_service.core.gateway;

import luizbrand.com.user_service.core.domain.User;

import java.util.Optional;

public interface UserGateway {

     User createUser(User newUser);

     Optional<User> findByEmail(String email);

}
