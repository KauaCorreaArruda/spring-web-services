package com.github.kauacorreaarruda.web_services.repository;

import com.github.kauacorreaarruda.web_services.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
