package com.github.kauacorreaarruda.web_services.dto.user;

import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;

public record UserCreateRequestDTO(
        @NotBlank(message = "Field name must be filled")
        String name,
        @NotBlank(message = "Field email must be filled")
        String email,
        @NotBlank(message = "Field phone must be filled")
        String phone,
        @NotBlank(message = "Field password must be filled")
        String password
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
