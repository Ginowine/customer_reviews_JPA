package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.ProductNotFoundException;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

    // TODO: Wire JPA repositories here
    @Autowired
    private ProductRepository productRepository;

    /**
     * Creates a product.
     *
     * 1. Accept product as argument. Use {@link RequestBody} annotation.
     * 2. Save product.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @RequestMapping(value = "/{id}")
    public Product findById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product = productRepository.findProductById(id);

        if (product == null){
            throw new ProductNotFoundException("Error 404: PRODUCT_NOT_FOUND");
        }

        return product;

    }

    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> listProducts() {
        Iterable<Product> productIterable = productRepository.findAll();
        List<Product> productList = new ArrayList<Product>();

        for (Product prod : productIterable){
            productList.add(prod);
        }

        return productList;
    }
}