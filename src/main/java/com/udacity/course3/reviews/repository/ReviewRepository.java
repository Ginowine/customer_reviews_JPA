package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    //Product findByProductId(Long id);
     List<Review> findReviewsByProductId(long productId);
     Review findReviewById(Long reviewId);
     Review findReviewByProduct_id(Long productId);

}
