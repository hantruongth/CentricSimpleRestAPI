package com.centricsoftware.simpleproductapi;

import com.centricsoftware.simpleproductapi.controller.ProductController;
import com.centricsoftware.simpleproductapi.dto.ProductDTO;
import com.centricsoftware.simpleproductapi.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
@Import(TestConfig.class)
public class ProductControllerIntegrationTest {

    @Autowired
    ObjectMapper mapper;
    List<ProductDTO> products = new ArrayList<>();
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategory("Luxury Car");
        productDTO.setBrand("BMW");
        productDTO.setName("BMW X3 Drive 25i");
        productDTO.setTags(new HashSet<>(Arrays.asList("Tag1", "Tag2")));

        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setCategory("Car");
        productDTO2.setBrand("Toyota");
        productDTO2.setName("Camry");
        productDTO2.setTags(new HashSet<>(Arrays.asList("Tag1", "Tag2")));

        products.add(productDTO);
        products.add(productDTO2);


    }

    @Test
    public void whenPostProduct_thenAddProduct() throws Exception {

        ProductDTO productDTO = products.get(0);
        given(productService.addProduct(productDTO)).willReturn(productDTO);

        mvc.perform(post("/v1/products").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsBytes(productDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("BMW X3 Drive 25i")));

        verify(productService, VerificationModeFactory.times(1)).addProduct(Mockito.any());
        reset(productService);
    }

    @Test
    public void givenProduct_whenSearchProduct_thenReturnJsonArray() throws Exception {

        given(productService.searchPagingAndSortProductByCategory("Car", 0,5, "createdDate")).willReturn(products);

        mvc.perform(get("/v1/products?category=Car&pageNo=0&pageSize=5&SortBy=createdDate").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(products.get(0).getName())))
                .andExpect(jsonPath("$[1].name", is(products.get(1).getName())));

        reset(productService);
    }

}