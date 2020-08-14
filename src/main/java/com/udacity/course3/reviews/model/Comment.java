package com.udacity.course3.reviews.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(nullable = false)
    private String commentTest;

    @Column(nullable = false)
    private String createdTime;


    public Comment() {
    }

    public Comment(String commentTest, String createdTime) {
        this.commentTest = commentTest;
        this.createdTime = createdTime;
    }

    public Comment(Long id, String commentTest, String createdTime) {
        this.commentTest = commentTest;
        this.createdTime = createdTime;
        this.id = id;
    }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
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

//    public String getReviewId() {
//        return review_Id;
//    }
//
//    public void setReviewId(String reviewId) {
//        this.review_Id = reviewId;
//    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
