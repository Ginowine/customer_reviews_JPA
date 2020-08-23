package com.udacity.course3.reviews.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false, name = "product_name")
    private String product_Name;

    @Column(nullable = false, name = "product_amt")
    private double product_Amt;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "product")
    private List<Review> reviews;

    public Product() {
    }

    public Product(String productName, double productAmount) {
        this.product_Name = productName;
        this.product_Amt = productAmount;
    }

    public Product(Long id, String productName, double productAmount) {
        this.id = id;
        this.product_Name = productName;
        this.product_Amt = productAmount;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public double getProduct_Amt() {
        return product_Amt;
    }

    public void setProduct_Amt(double product_Amt) {
        this.product_Amt = product_Amt;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
