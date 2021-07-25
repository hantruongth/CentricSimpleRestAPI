package com.centricsoftware.simpleproductapi;


import com.centricsoftware.simpleproductapi.model.Brand;
import com.centricsoftware.simpleproductapi.model.Category;
import com.centricsoftware.simpleproductapi.model.Product;
import com.centricsoftware.simpleproductapi.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author hantruong
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByName_thenReturnProduct() {
        Product product = new Product();
        Brand brand = entityManager.persist(new Brand("BMW"));
        Category category = entityManager.persist(new Category("Car"));
        product.setBrand(brand);
        product.setCategory(category);
        product.setName("BMW X3");

        entityManager.merge(product);

        Product found = productRepository.findByName("BMW X3");
        assertThat(found.getName()).isEqualTo(product.getName());
        assertThat(found.getId()).isNotNull();
        assertThat(found.getCreatedDate()).isNotNull();
        assertThat(found.getCategory().getName()).isEqualTo("Car");
    }

    @Test
    public void givenSetOfProducts_whenFindAll_thenReturnAllProducts() {

        Brand brand = entityManager.persist(new Brand("BMW"));
        Category category = entityManager.persist(new Category("Car"));

        Product product = new Product();
        product.setBrand(brand);
        product.setCategory(category);
        product.setName("BMW X3");

        Product product2 = new Product();
        product2.setBrand(brand);
        product2.setCategory(category);
        product2.setName("BMW X5");

        entityManager.merge(product);
        entityManager.merge(product2);

        List<Product> products = productRepository.findAll();

        assertThat(products)
                .hasSize(2)
                .extracting(Product::getName)
                .containsOnly(product.getName(), product2.getName());
    }

    @Test
    public void whenInvalidName_thenReturnNull() {
        Product product = productRepository.findByName("Dummy Name");
        assertThat(product).isNull();
    }


    @Test
    public void whenRandomUUID_thenReturnNull() {
        Product product = productRepository.findById(UUID.randomUUID()).orElse(null);
        assertThat(product).isNull();
    }

}
