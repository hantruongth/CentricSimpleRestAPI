package com.centricsoftware.simpleproductapi.dto;

import com.centricsoftware.simpleproductapi.controller.ProductController;
import com.centricsoftware.simpleproductapi.json.CustomDateTimeISO8601Serializer;
import com.centricsoftware.simpleproductapi.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hantruong
 */

@Data
@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private UUID id;
    @NotBlank(message = "Product name is required!")
    private String name;
    private String description;
    @NotBlank(message = "Product brand is required!")
    private String brand;
    @NotBlank(message = "Product category is required!")
    private String category;
    private Set<String> tags = new HashSet<>();
    @JsonProperty("created_at")
    @JsonSerialize(using = CustomDateTimeISO8601Serializer.class)
    private Date createdDate;

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setBrand(product.getBrand().getName());
        productDTO.setCategory(product.getCategory().getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setTags(product.getTag().stream().map(t->t.getName()).collect(Collectors.toSet()));
        productDTO.setCreatedDate(product.getCreatedDate());
        productDTO.setName(product.getName());
        return productDTO;

    }
}
