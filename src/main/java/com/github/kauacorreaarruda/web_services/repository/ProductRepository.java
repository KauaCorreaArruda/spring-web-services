package com.github.kauacorreaarruda.web_services.repository;

import com.github.kauacorreaarruda.web_services.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
