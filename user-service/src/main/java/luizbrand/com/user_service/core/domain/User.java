package luizbrand.com.user_service.core.domain;

import java.util.UUID;

public record User(
        UUID userId,
        String name,
        String email
) {
}
