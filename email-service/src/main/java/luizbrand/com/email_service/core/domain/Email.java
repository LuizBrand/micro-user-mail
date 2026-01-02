package luizbrand.com.email_service.core.domain;

import luizbrand.com.email_service.core.enums.EmailStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record Email (
         UUID emailId,
         UUID userId,
         String emailFrom,
         String emailTo,
         String emailSubject,
         String emailBody,
         EmailStatus emailStatus,
         LocalDateTime emailSendDate
) {}
