package luizbrand.com.user_service.core.usecases;

import luizbrand.com.user_service.core.domain.User;
import luizbrand.com.user_service.core.exceptions.UserAlreadyExistsException;
import luizbrand.com.user_service.core.gateway.UserGateway;

public class CreateUserCaseImp implements CreateUserCase{

    private final UserGateway userGateway;

    public CreateUserCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User newUser) {

        if (userGateway.findByEmail(newUser.email()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        };

        return userGateway.createUser(newUser);

    }
}
