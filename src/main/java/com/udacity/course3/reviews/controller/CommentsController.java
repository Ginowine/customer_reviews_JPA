package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.exception.ReviewNotFound;
import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    // TODO: Wire needed JPA repositories here
    @Autowired
   private CommentRepository commentRepository;

    private Review existingReview;

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public Comment createCommentForReview(@RequestBody Comment comment, @PathVariable("reviewId") Long reviewId) throws ReviewNotFound {
        existingReview = commentRepository.findByReviewId(reviewId);
        if (existingReview == null){
            throw new ReviewNotFound("ERROR: REVIEW_NOT_FOUND");
        }
        return commentRepository.save(comment);
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<Comment> listCommentsForReview(@PathVariable("reviewId") Long reviewId) throws ReviewNotFound {
        existingReview = commentRepository.findByReviewId(reviewId);
        if (existingReview == null){
            throw new ReviewNotFound("ERROR: REVIEW_NOT_FOUND");
        }

        return commentRepository.findCommentsByReviewId(reviewId);
    }
}