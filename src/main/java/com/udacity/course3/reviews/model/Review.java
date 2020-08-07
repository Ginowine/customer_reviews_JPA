package com.udacity.course3.reviews.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
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

    @Column(nullable = false)
    private long commentId;

    @Column(nullable = false)
    private long productId;

    public Review() {
    }

    public Review(Product product, List<Comment> comments, String reviewerName, String reviewerDescription, String reviewerTitle, String createdTime, long commentId, long productId) {
        this.product = product;
        this.comments = comments;
        this.reviewerName = reviewerName;
        this.reviewerDescription = reviewerDescription;
        this.reviewerTitle = reviewerTitle;
        this.createdTime = createdTime;
        this.commentId = commentId;
        this.productId = productId;
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

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
