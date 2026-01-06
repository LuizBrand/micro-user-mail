package luizbrand.com.user_service.core.usecases;

import luizbrand.com.user_service.core.domain.User;
import java.util.List;

public interface ListUsersCase {
    List<User> execute();
}
