package com.udacity.course3.reviews.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "review")
    private List<Comment> comments;

    @Column(nullable = false, name = "reviewer_name")
    private String reviewerName;

    @Column(nullable = false, name = "review_description")
    private String reviewerDescription;

    @Column(nullable = false, name = "review_title")
    private String reviewerTitle;

    @Column(nullable = false, name = "created_time")
    private String CreatedTime;

    @Column(nullable = false, name = "product_id", insertable = false, updatable = false)
    private Long product_id;


    public Review() {
    }

    public Review(String reviewerName, String reviewerDescription, String reviewerTitle, String createdTime, Long product_Id) {
        this.reviewerName = reviewerName;
        this.reviewerDescription = reviewerDescription;
        this.reviewerTitle = reviewerTitle;
        this.CreatedTime = createdTime;
        this.product_id = product_Id;
    }

    public Review(Long id, String reviewerName, String reviewerDescription, String reviewerTitle, String createdTime, long product_Id) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.reviewerDescription = reviewerDescription;
        this.reviewerTitle = reviewerTitle;
        this.CreatedTime = createdTime;
        this.product_id = product_Id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return CreatedTime;
    }

    public void setCreatedTime(String createdTime) {
        this.CreatedTime = createdTime;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }
}
