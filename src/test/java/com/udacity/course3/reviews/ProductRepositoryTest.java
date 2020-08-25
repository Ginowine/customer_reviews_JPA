package com.udacity.course3.reviews;

import com.udacity.course3.reviews.model.Product;
import com.udacity.course3.reviews.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class ProductRepositoryTest {
    @Autowired private ProductRepository productRepository;

    @Test
    public void testFindProductById(){

        Product product = new Product();
        product.setId(1L);
        product.setProduct_Name("Gucci Bag");
        product.setProduct_Amt(400.00);
        productRepository.save(product);

        Product actualProduct = productRepository.findProductById(product.getId());
        assertThat(actualProduct).isNotNull();
        assertEquals(product.getId(), actualProduct.getId());
        assertEquals(product.getProduct_Name(), actualProduct.getProduct_Name());
        assertEquals(product.getProduct_Amt(), actualProduct.getProduct_Amt());
    }

    @Test
    public void testDeleteProductById(){
        Product product = new Product();
        product.setId(3L);
        product.setProduct_Name("jhgfkj khkjfdhk");
        product.setProduct_Amt(600.00);

        Product product1 = productRepository.save(product);
        productRepository.deleteById(product1.getId());
    }

    @Test
    public void getAllProducts(){
        Product product = new Product();
        product.setId(2L);
        product.setProduct_Name("Doggy Dog");
        product.setProduct_Amt(500.00);

        productRepository.save(product);
        assertNotNull(productRepository.findAll());
    }
}
