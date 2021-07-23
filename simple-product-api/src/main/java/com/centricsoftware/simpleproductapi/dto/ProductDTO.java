package com.centricsoftware.simpleproductapi.dto;

import com.centricsoftware.simpleproductapi.json.CustomDateTimeISO8601Serializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.*;

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
}
