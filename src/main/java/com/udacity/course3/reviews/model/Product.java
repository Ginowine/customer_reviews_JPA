package com.udacity.course3.reviews.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(nullable = false, unique = true)
    private String productName;

    @Column(nullable = false, unique = true)
    private Double productAmount;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "productReview")
    private List<Review> reviews;

    public Product() {
    }

    public Product(String productName, Double productAmount) {
        this.productName = productName;
        this.productAmount = productAmount;
    }

    public Product(Long id, String productName, Double productAmount) {
        this.productName = productName;
        this.productAmount = productAmount;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Double productAmount) {
        this.productAmount = productAmount;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
