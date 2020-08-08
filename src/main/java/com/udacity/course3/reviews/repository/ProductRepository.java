package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    <S extends Product> S save(S s);

    Product findById(long id);
    List<Product> findByProductAmountLessThan(double amount);
}
