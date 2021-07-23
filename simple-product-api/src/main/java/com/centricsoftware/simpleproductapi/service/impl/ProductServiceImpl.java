package com.centricsoftware.simpleproductapi.service.impl;

import com.centricsoftware.simpleproductapi.dto.ProductDTO;
import com.centricsoftware.simpleproductapi.model.Brand;
import com.centricsoftware.simpleproductapi.model.Category;
import com.centricsoftware.simpleproductapi.model.Product;
import com.centricsoftware.simpleproductapi.model.Tag;
import com.centricsoftware.simpleproductapi.repository.BrandRepository;
import com.centricsoftware.simpleproductapi.repository.CategoryRepository;
import com.centricsoftware.simpleproductapi.repository.ProductRepository;
import com.centricsoftware.simpleproductapi.repository.TagRepository;
import com.centricsoftware.simpleproductapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author hantruong
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {

        Product product = new Product();

        Category category = categoryRepository.getCategoryByName(productDTO.getCategory());
        if(category == null) {
            category = new Category();
            category.setName(productDTO.getCategory());
        }

        Brand brand = brandRepository.getBrandByName(productDTO.getBrand());
        if(brand == null) {
            brand = new Brand();
            brand.setName(productDTO.getBrand());
        }

        Set<String> tags = productDTO.getTags();
        Map<String, Tag> tagMaps = tagRepository.findAllTagByName(tags).stream().collect(Collectors.toMap(Tag::getName, Function.identity()));
        Set<Tag> persistTags = new HashSet<>();
        tags.forEach(t-> {
            Tag dbTag = tagMaps.get(t);
            if(dbTag == null)
                dbTag = new Tag(t);
            persistTags.add(dbTag);
        });

        product.setBrand(brand);
        product.setCategory(category);
        product.setName(productDTO.getName());
        product.setTag(persistTags);
        product.setDescription(productDTO.getDescription());

        Product saved = productRepository.save(product);
        productDTO.setId(saved.getId());
        productDTO.setCreatedDate(saved.getCreatedDate());

        return productDTO;

    }
}
