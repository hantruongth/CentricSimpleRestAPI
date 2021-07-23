package com.centricsoftware.simpleproductapi.model;

import javax.persistence.*;
import java.util.*;

/**
 * @author hantruong
 */
@Entity
public class Brand implements DatabaseEntity{

    @Id
    @Column(name = "brand_id")
    @GeneratedValue
    private UUID id;

    @Column(name = "brand_name")
    private String name;

    @Column(name = "brand_desc")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate = new Date();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private List<Product> products = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
        this.createdDate = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return name.equals(brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
