package com.udacity.course3.reviews.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private long ID;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(nullable = false)
    private String commentTest;

    @Column(nullable = false)
    private String reviewId;

    @Column(nullable = false)
    private String createdTime;


    public Comment() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getCommentTest() {
        return commentTest;
    }

    public void setCommentTest(String commentTest) {
        this.commentTest = commentTest;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
