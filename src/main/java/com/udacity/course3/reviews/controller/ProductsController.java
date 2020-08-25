package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.ProductNotFoundException;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/products")
@Transactional
public class ProductsController {

    // TODO: Wire JPA repositories here
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * Creates a product.
     *
     * 1. Accept product as argument. Use {@link RequestBody} annotation.
     * 2. Save product.
     */
    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        //return productRepository.save(product);
        //throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
        Product product1 = new Product();
        product1.setProduct_Name(product.getProduct_Name());
        product1.setProduct_Amt(product.getProduct_Amt());
        product1.setReviews(product.getReviews());
        productRepository.save(product1);

        return ResponseEntity.ok(product1);

    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @RequestMapping(value = "/{id}")
    public Product findById(@PathVariable("id") long id) throws ProductNotFoundException {
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