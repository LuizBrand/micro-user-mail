package luizbrand.com.email_service.infrastructure.dto;

import java.util.UUID;

public record EmailDTO(
        UUID userId,
        String emailTo,
        String emailFrom,
        String emailSubject,
        String emailBody
) {
}
