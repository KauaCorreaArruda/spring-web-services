package com.github.kauacorreaarruda.web_services.mapper;

import com.github.kauacorreaarruda.web_services.dto.product.ProductResponseDTO;
import com.github.kauacorreaarruda.web_services.entity.Product;
import com.github.kauacorreaarruda.web_services.service.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDTO mapEntityToDto(final Product product) {
        if (product == null) {
            throw new ResourceNotFoundException("User can't be null");
        }

        return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getImgUrl());
    }
}
