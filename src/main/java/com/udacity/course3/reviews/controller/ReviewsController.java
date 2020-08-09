package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.ProductNotFoundException;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    // TODO: Wire JPA repositories here
    @Autowired
    private ReviewRepository reviewRepository;

    private Review review1;

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
    public Review createReviewForProduct(@RequestBody Review review,
                                                         @PathVariable("productId") Long productId) throws ProductNotFoundException {
        Product productExisting = reviewRepository.findByProductId(productId);
        if (productExisting == null){
            throw new ProductNotFoundException("NOT_FOUND");
        }
        return reviewRepository.save(review);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public List<Review> listReviewsForProduct(@PathVariable("productId") Long productId) {
        return reviewRepository.findReviewsByProductId(productId);

    }
}