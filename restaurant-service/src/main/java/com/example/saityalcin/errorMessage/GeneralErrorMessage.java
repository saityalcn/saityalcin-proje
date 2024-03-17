package com.example.saityalcin.errorMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record GeneralErrorMessage(
        LocalDateTime date,
        String message,
        String description
) {
}
