package com.github.kauacorreaarruda.web_services.service;

import com.github.kauacorreaarruda.web_services.entity.Product;
import com.github.kauacorreaarruda.web_services.repository.ProductRepository;
import com.github.kauacorreaarruda.web_services.service.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
