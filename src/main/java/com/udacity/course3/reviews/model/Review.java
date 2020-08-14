package com.udacity.course3.reviews.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "review")
    private List<Comment> comments;

    @Column(nullable = false)
    private String reviewerName;

    @Column(nullable = false)
    private String reviewerDescription;

    @Column(nullable = false)
    private String reviewerTitle;

    @Column(nullable = false)
    private String createdTime;


    public Review() {
    }

    public Review(String reviewerName, String reviewerDescription, String reviewerTitle, String createdTime) {
        this.reviewerName = reviewerName;
        this.reviewerDescription = reviewerDescription;
        this.reviewerTitle = reviewerTitle;
        this.createdTime = createdTime;
    }

    public Review(Long id, String reviewerName, String reviewerDescription, String reviewerTitle, String createdTime) {
        this.reviewerName = reviewerName;
        this.reviewerDescription = reviewerDescription;
        this.reviewerTitle = reviewerTitle;
        this.createdTime = createdTime;
        this.id = id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerDescription() {
        return reviewerDescription;
    }

    public void setReviewerDescription(String reviewerDescription) {
        this.reviewerDescription = reviewerDescription;
    }

    public String getReviewerTitle() {
        return reviewerTitle;
    }

    public void setReviewerTitle(String reviewerTitle) {
        this.reviewerTitle = reviewerTitle;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
