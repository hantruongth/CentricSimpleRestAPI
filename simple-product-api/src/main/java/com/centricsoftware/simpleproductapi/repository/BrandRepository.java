package com.centricsoftware.simpleproductapi.repository;

import com.centricsoftware.simpleproductapi.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author hantruong
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {

    @Query("Select b from Brand b where b.name = :name")
    Brand findBrandByName(String name);
}
