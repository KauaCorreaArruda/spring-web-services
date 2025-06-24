package com.github.kauacorreaarruda.web_services.service;

import com.github.kauacorreaarruda.web_services.entity.Order;
import com.github.kauacorreaarruda.web_services.repository.OrderRepository;
import com.github.kauacorreaarruda.web_services.service.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
