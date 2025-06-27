package com.github.kauacorreaarruda.web_services.resource;

import com.github.kauacorreaarruda.web_services.dto.product.ProductResponseDTO;
import com.github.kauacorreaarruda.web_services.entity.Product;
import com.github.kauacorreaarruda.web_services.mapper.ProductMapper;
import com.github.kauacorreaarruda.web_services.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/products", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductResource {

    private final ProductService service;
    private final ProductMapper mapper;

    public ProductResource(ProductService service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        List<Product> products = service.findAll();
        List<ProductResponseDTO> dtoList = products.stream().map(mapper::mapEntityToDto).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
        Product product = service.findById(id);
        return ResponseEntity.ok().body(mapper.mapEntityToDto(product));
    }
}
