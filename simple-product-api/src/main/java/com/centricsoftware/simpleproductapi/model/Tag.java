package com.centricsoftware.simpleproductapi.model;

import javax.persistence.*;
import java.util.*;

/**
 * @author hantruong
 */
@Entity
public class Tag implements DatabaseEntity{

    @Id
    @Column(name = "tag_id")
    @GeneratedValue
    private UUID id;

    @Column(name = "tag_name")
    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }
//    @ManyToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    private Set<Product> products = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate = new Date();

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date date) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
