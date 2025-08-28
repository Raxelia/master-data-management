package com.mentoring.mdm.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.service.ProductService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private ProductService productService;

  @Test
  void testSaveProduct() throws Exception {
    Product product = new Product();
    product.setId("123");
    product.setName("Laptop");
    product.setCategory("Electronics");

    when(productService.saveProduct(any(Product.class))).thenReturn(product);

    mockMvc
        .perform(
            post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Laptop\", \"category\": \"Electronics\" }"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("123"))
        .andExpect(jsonPath("$.name").value("Laptop"))
        .andExpect(jsonPath("$.category").value("Electronics"));
  }

  @Test
  void testGetProductsByNameMagic() throws Exception {
    Product product = new Product();
    product.setName("Laptop");
    product.setCategory("Electronics");

    when(productService.getProductsByNameMagic("Laptop")).thenReturn(List.of(product));

    mockMvc
        .perform(get("/product/magic-query?name=Laptop"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value("Laptop"))
        .andExpect(jsonPath("$[0].category").value("Electronics"));
  }

  @Test
  void testGetProductsByExactName() throws Exception {
    Product product = new Product();
    product.setName("Smartphone");
    product.setCategory("Gadgets");

    when(productService.getProductsByNameCustom("Smartphone")).thenReturn(List.of(product));

    mockMvc
        .perform(get("/product/custom-query?name=Smartphone"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value("Smartphone"))
        .andExpect(jsonPath("$[0].category").value("Gadgets"));
  }

  @Test
  void testUpdateProductCategory() throws Exception {
    doNothing().when(productService).updateProductCategory("123", "Gadgets");

    mockMvc
        .perform(put("/product/123/category").contentType(MediaType.TEXT_PLAIN).content("Gadgets"))
        .andExpect(status().isOk());
  }
}
