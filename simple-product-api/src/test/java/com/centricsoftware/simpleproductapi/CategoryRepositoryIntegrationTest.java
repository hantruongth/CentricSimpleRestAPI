package com.centricsoftware.simpleproductapi;

import com.centricsoftware.simpleproductapi.model.Category;
import com.centricsoftware.simpleproductapi.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author hantruong
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void whenFindByName_returnCategory() {

        entityManager.persist(new Category("Car"));
        entityManager.persist(new Category("Computer"));

        List<Category> categories = categoryRepository.findAll();

        assertThat(categories.get(0).getId()).isNotNull();
        assertThat(categories.get(0).getCreatedDate()).isNotNull();
        assertThat(categories.get(0).getName()).isEqualTo("Car");
        assertThat(categories).hasSize(2);
    }
}
