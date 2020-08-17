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

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired private ProductRepository productRepository;
    @Autowired private ReviewRepository reviewRepository;

    @Test
    public void createReviewForProduct(){
        Product product = new Product();

        product.setId(1L);
        product.setProduct_Name("Gucci Bag");
        product.setProduct_Amt(400.00);

        //entityManager.merge(product);
        productRepository.save(product);

        Product product1 = productRepository.findProductById(product.getId());
        assertThat(product).isNotNull();
        assertEquals(product.getId(), product1.getId());
        assertEquals(product.getProduct_Name(), product1.getProduct_Name());
        assertEquals(product.getProduct_Amt(), product1.getProduct_Amt());

        Review review = new Review();
        review.setId(1L);
        review.setReviewerName("Gino Mazoni");
        review.setReviewerDescription("jhjfhb djhbfjh jbjhfd jbvjh");
        review.setReviewerTitle("Hub Manager");
        review.setCreatedTime("12:45");
        review.setProduct_id(product1.getId());

        reviewRepository.save(review);

        Optional<Review> review1 = reviewRepository.findById(review.getId());
            assertEquals(review.getId(), review1.get().getId());
            assertEquals(review.getReviewerName(), review1.get().getReviewerName());

    }

//    @Test
//    public void testFindReviewsByProductId(){
//        Product product = new Product();
//
//        product.setId(1L);
//        product.setProduct_Name("Gucci Bag");
//        product.setProduct_Amt(400.00);
//
//        //entityManager.merge(product);
//        productRepository.save(product);
//
//        List<Review> reviews = reviewRepository.findReviewsByProductId(product.getId());
//        assertThat(reviews).isNotNull();
//    }
}
