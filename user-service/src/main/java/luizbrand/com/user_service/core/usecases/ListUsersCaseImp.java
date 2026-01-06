package luizbrand.com.user_service.core.usecases;

import luizbrand.com.user_service.core.domain.User;
import luizbrand.com.user_service.core.gateway.UserGateway;

import java.util.List;

public class ListUsersCaseImp implements ListUsersCase {

    private final UserGateway userGateway;

    public ListUsersCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> execute() {
        return userGateway.listAllUsers();
    }
}
