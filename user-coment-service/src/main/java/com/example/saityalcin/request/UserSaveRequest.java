package com.example.saityalcin.request;

public record UserSaveRequest(
        String name,
        String surname,
        Double latitude,
        Double longitude
) {
}
