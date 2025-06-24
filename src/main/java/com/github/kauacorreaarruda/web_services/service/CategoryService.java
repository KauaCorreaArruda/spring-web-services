package com.github.kauacorreaarruda.web_services.service;

import com.github.kauacorreaarruda.web_services.entity.Category;
import com.github.kauacorreaarruda.web_services.repository.CategoryRepository;
import com.github.kauacorreaarruda.web_services.service.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
