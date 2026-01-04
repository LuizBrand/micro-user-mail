package luizbrand.com.user_service.core.usecases;

import luizbrand.com.user_service.core.domain.User;

public interface CreateUserCase {

    public User execute(User newUser);

}
