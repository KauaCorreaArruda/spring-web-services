package com.github.kauacorreaarruda.web_services.dto.product;

import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        @NotBlank(message = "Field name must be filled")
        String name,
        String description,
        BigDecimal price,
        String imgUrl
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
