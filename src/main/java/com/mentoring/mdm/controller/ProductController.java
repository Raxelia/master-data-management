package com.mentoring.mdm.controller;

import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Tag(name = "Product API", description = "Endpoints for managing products")
@AllArgsConstructor
public class ProductController {

  private final ProductService productService;

  // --- Save Product ---
  @Operation(
      summary = "Save product",
      description = "Save a new product by name and category",
      responses = {
        @ApiResponse(responseCode = "200", description = "Product saved successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input provided"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
    Product savedProduct = productService.saveProduct(product);
    return ResponseEntity.ok(savedProduct);
  }

  @Operation(
      summary = "Get products by name (magic query)",
      description = "Retrieve a list of products by their name using a magic query",
      responses = {
        @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "No products found with the given name"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @GetMapping(value = "/magic-query", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> getProductsByNameMagic(@RequestParam("name") String name) {
    List<Product> products = productService.getProductsByNameMagic(name);
    if (products.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(products);
  }

  @Operation(
      summary = "Get products by name (custom query)",
      description = "Retrieve a list of products by their exact name using a custom @Query",
      responses = {
        @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "No products found with the given name"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @GetMapping(value = "/custom-query", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> getProductsByExactName(@RequestParam("name") String name) {
    List<Product> products = productService.getProductsByNameCustom(name);
    if (products.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(products);
  }

  @Operation(
      summary = "Update product category",
      description = "Update the category of a product by its ID",
      responses = {
        @ApiResponse(responseCode = "200", description = "Product category updated successfully"),
        @ApiResponse(responseCode = "404", description = "No product found with the provided ID"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @PutMapping(value = "/{id}/category", consumes = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<Void> updateProductCategory(
      @PathVariable("id") String id, @RequestBody String newCategory) {
    try {
      productService.updateProductCategory(id, newCategory);
      return ResponseEntity.ok().build();
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
