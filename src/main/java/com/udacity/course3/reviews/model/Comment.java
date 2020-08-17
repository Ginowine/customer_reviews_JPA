package com.udacity.course3.reviews.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(nullable = false, name = "test")
    private String test;

    @Column(nullable = false, name = "created_time")
    private String createdtime;

    public Comment() {
    }

    public Comment(String commentTest, String createdTime) {
        this.test = commentTest;
        this.createdtime = createdTime;
    }

    public Comment(Long id, String commentTest, String createdTime) {
        this.test = commentTest;
        this.createdtime = createdTime;
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
