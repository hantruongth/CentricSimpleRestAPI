package com.centricsoftware.simpleproductapi.controller;

import com.centricsoftware.simpleproductapi.dto.ProductDTO;
import com.centricsoftware.simpleproductapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author hantruong
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductDTO> addNewProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }

    @GetMapping()
    public List<ProductDTO> searchPagingAndSortProductByCategory(
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "createdDate") String sortBy) {
        return productService.searchPagingAndSortProductByCategory(category, pageNo, pageSize, sortBy);
    }
}
