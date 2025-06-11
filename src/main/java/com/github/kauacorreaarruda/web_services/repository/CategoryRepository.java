package com.github.kauacorreaarruda.web_services.repository;

import com.github.kauacorreaarruda.web_services.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
