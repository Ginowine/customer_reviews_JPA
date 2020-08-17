package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired private ProductRepository productRepository;
    @Autowired private ReviewRepository reviewRepository;

    @Test
    public void testFindByProductId(){
        Product product = new Product();

        product.setId(1L);
        product.setProduct_Name("Gucci Bag");
        product.setProduct_Amt(400.00);

        //entityManager.merge(product);
        productRepository.save(product);

        Review review = new Review();
        review.setId(1L);
        review.setReviewerName("Gino Mazoni");
        review.setReviewerDescription("jhjfhb djhbfjh jbjhfd jbvjh");
        review.setReviewerTitle("Hub Manager");
        review.setCreatedTime("12:45");
        review.setProduct_id(product.getId());

        reviewRepository.save(review);

        //review.setProduct(product);

//        Product actualProduct = reviewRepository.findByProductId(product.getId());
//
//        assertThat(actualProduct).isNotNull();
//        assertEquals(product.getId(), actualProduct.getId());
//        assertEquals(product.getProduct_Name(), actualProduct.getProduct_Name());
//        assertEquals(product.getProduct_Amt(), actualProduct.getProduct_Amt());
    }
}
