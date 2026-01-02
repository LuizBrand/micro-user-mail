package luizbrand.com.email_service.infrastructure.dto;

import java.util.UUID;

public record EmailDTO(
        UUID emailId,
        String emailSubject,
        String emailBody
) {
}
