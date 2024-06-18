package com.security.grude4j.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
