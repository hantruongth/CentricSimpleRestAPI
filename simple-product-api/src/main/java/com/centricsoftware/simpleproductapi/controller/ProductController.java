package com.centricsoftware.simpleproductapi.controller;

import com.centricsoftware.simpleproductapi.dto.ProductDTO;
import com.centricsoftware.simpleproductapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author hantruong
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductDTO> addNewProduct(@Valid @RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {

        return ResponseEntity.ok(null);
    }
}
