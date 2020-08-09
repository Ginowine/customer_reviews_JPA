package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.ProductNotFoundException;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    // TODO: Wire JPA repositories here
    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<Review> createReviewForProduct(@RequestBody Review review,
                                                         @PathVariable("productId") Integer productId) throws ProductNotFoundException {
        Product productExisting = reviewRepository.findByProductId(productId);
        if (productExisting == null){
            throw new ProductNotFoundException("NOT_FOUND");
        }

        productExisting.setId(productId);
        List<Review> reviews = productExisting.getReviews();

        for (Review review1 : reviews){
            review1.setId();
            review1.setProduct(productExisting);
        }

        return reviewRepository.save(productExisting);

    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        Product product = reviewRepository.findByProductId(productId);
        List<Review> reviews;

        if (product != null){
            reviews = reviewRepository.findAll();
        }

        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
    }
}