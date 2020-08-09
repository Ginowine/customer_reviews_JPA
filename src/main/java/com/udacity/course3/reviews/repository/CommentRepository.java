package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Review findByReviewId(Long reviewId);

    List<Comment> findCommentsByReviewId(Long reviewId);
}
