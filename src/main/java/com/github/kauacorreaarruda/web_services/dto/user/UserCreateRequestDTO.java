package com.github.kauacorreaarruda.web_services.dto.user;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record UserCreateRequestDTO(
        @NotNull String name, String email, String phone, String password) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
