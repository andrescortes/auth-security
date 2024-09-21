package com.app.auth.service;

import com.app.auth.dto.SaveProduct;
import com.app.auth.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOneById(Long productId);

    Product createOne(SaveProduct saveProduct);

    Product updateOneById(Long productId, SaveProduct saveProduct);

    Product disableOneById(Long productId);
}
