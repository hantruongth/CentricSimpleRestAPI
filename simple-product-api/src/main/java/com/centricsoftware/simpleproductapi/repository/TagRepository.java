package com.centricsoftware.simpleproductapi.repository;

import com.centricsoftware.simpleproductapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

/**
 * @author hantruong
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {

    @Query("Select c from Tag c where c.name in (:names)")
    Set<Tag> findAllTagByName(Set<String> names);
}
