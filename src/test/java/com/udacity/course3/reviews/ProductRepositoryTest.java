package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private TestEntityManager testEntityManager;
    @Autowired private ProductRepository productRepository;


    @Test
    public void testFindProductById(){
        Product product = new Product();

        product.setId(1L);
        product.setProduct_Name("Gucci Bag");
        product.setProduct_Amt(400.00);

        //entityManager.merge(product);
        productRepository.save(product);

        Product actualProduct = productRepository.findProductById(product.getId());
        assertThat(actualProduct).isNotNull();
        assertEquals(product.getId(), actualProduct.getId());
        assertEquals(product.getProduct_Name(), actualProduct.getProduct_Name());
        assertEquals(product.getProduct_Amt(), actualProduct.getProduct_Amt());
    }
}
