package com.github.kauacorreaarruda.web_services.repository;

import com.github.kauacorreaarruda.web_services.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
