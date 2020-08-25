package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Comment;
import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.model.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void testFindCommentByReviewId(){
        Product product = new Product();
        product.setId(1);
        product.setProduct_Name("Gucci Bag");
        product.setProduct_Amt(400.00);

        productRepository.save(product);
        Product product1 = productRepository.findProductById(product.getId());

        Review review = new Review();
        review.setId(2L);
        review.setReviewerTitle("hgdkd jhjh");
        review.setReviewerName("Gino");
        review.setReviewerDescription("jhgjg jhbgjudf jjh");
        review.setCreatedTime("23:45");
        review.setProduct_id(product1.getId());

        Review review1 = reviewRepository.save(review);

//        assertThat(review1).isNotNull();
//        assertEquals(review.getId(), review1.getId());

        Comment comment = new Comment();
        comment.setID(1L);
        comment.setTest("bla bla bla bla bla bla bla");
        comment.setCreatedtime("12:45");
        comment.setReview_id(review1.getId());

        Comment comment1 = commentRepository.save(comment);

        assertThat(comment1).isNotNull();
        assertThat(comment1.getReview_id()).isNotNull();
        assertEquals(comment.getID(), comment1.getID());
        assertEquals(comment.getTest(), comment1.getTest());
        assertEquals(comment.getCreatedtime(), comment1.getCreatedtime());
        assertEquals(comment.getReview_id(), comment1.getReview_id());
    }

    @Test
    public void findCommentByReviewId(){

        Product product = new Product();
        product.setId(1);
        product.setProduct_Name("Gucci Bag");
        product.setProduct_Amt(400.00);

        productRepository.save(product);
        Product product1 = productRepository.findProductById(product.getId());

        Review review = new Review();
        review.setId(1L);
        review.setReviewerTitle("hgdkd jhjh");
        review.setReviewerName("Gino");
        review.setReviewerDescription("jhgjg jhbgjudf jjh");
        review.setCreatedTime("23:45");
        review.setProduct_id(product1.getId());

        Review review1 = reviewRepository.save(review);

        List<Comment> comments = commentRepository.findCommentsByReviewId(review1.getId());

        assertThat(comments).isNotNull();

    }
}
