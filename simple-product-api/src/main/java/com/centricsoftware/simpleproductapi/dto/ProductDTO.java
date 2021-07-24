package com.centricsoftware.simpleproductapi.dto;

import com.centricsoftware.simpleproductapi.json.CustomDateTimeISO8601Serializer;
import com.centricsoftware.simpleproductapi.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author hantruong
 */

@Data
@Setter
@Getter
@NoArgsConstructor
public class ProductDTO {

    private UUID id;
    @NotNull(message = "{required.error.message}")
    @Size(min = 5, max = 100, message = "{name.length.required.error.message}")
    private String name;
    private String description;
    @NotBlank(message = "{required.error.message}")
    private String brand;
    @NotBlank(message = "{required.error.message}")
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
