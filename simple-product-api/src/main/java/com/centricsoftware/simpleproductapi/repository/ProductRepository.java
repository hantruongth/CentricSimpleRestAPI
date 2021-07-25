package com.centricsoftware.simpleproductapi.repository;

import com.centricsoftware.simpleproductapi.model.Category;
import com.centricsoftware.simpleproductapi.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author hantruong
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>, PagingAndSortingRepository<Product, UUID> {
    Slice<Product> findByCategory(Category c, Pageable pageable);
    Product findByName(String name);
}
