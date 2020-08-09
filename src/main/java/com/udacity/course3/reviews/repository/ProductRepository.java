package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Product findById(long id);

    Product findProductById(Long productId);
}
