package com.centricsoftware.simpleproductapi.repository;

import com.centricsoftware.simpleproductapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author hantruong
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("Select c from Category c where c.name = :name")
    Category getCategoryByName(String name);


}
