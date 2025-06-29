package com.github.kauacorreaarruda.web_services.mapper;

import com.github.kauacorreaarruda.web_services.dto.order.OrderResponseDTO;
import com.github.kauacorreaarruda.web_services.entity.Order;
import com.github.kauacorreaarruda.web_services.service.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

private OrderResponseDTO mapEntityToDto(final Order order) {
    if (order == null) {
        throw new ResourceNotFoundException("User can't be null");
    }

    return new OrderResponseDTO(order.getId(), order.getMoment(), order.getOrderStatus());
}
}
