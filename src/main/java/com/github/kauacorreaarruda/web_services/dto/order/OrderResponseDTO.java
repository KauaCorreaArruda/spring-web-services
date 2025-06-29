package com.github.kauacorreaarruda.web_services.dto.order;

import com.github.kauacorreaarruda.web_services.enumeration.OrderStatus;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public record OrderResponseDTO(
        Long id,
        @NotBlank(message = "Field moment must be filled")
        Instant moment,
        @NotBlank(message = "Field orderStatus must be filled")
        OrderStatus orderStatus) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
