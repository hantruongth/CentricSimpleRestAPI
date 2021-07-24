package com.centricsoftware.simpleproductapi.service;

import com.centricsoftware.simpleproductapi.dto.ProductDTO;

import java.util.List;

/**
 * @author hantruong
 */
public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);

    List<ProductDTO> searchPagingAndSortProductByCategory(String category, Integer pageNo, Integer pageSize, String sortBy);
}
