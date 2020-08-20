package com.udacity.course3.reviews.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(nullable = false, name = "test")
    private String test;

    @Column(nullable = false, name = "created_time")
    private String createdtime;

    @Column(nullable = false, name = "review_id", insertable = false, updatable = false)
    private long review_id;

    public Comment() {
    }

    public Comment(String commentTest, String createdTime, long review_id) {
        this.test = commentTest;
        this.createdtime = createdTime;
        this.review_id = review_id;
    }

    public Comment(Long id, String commentTest, String createdTime, long review_id) {
        this.id = id;
        this.test = commentTest;
        this.createdtime = createdTime;
        this.review_id = review_id;
    }

    public long getReview_id() {
        return review_id;
    }

    public void setReview_id(long review_id) {
        this.review_id = review_id;
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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }
}
