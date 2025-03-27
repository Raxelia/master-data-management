package com.mentoring.mdm.controller;

import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "Endpoints for managing products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @Operation(
      summary = "Save product name",
      description = "Save the name of the product being searched for into the database",
      responses = {
        @ApiResponse(responseCode = "200", description = "Product saved successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input provided"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @PostMapping
  public Product saveProduct(@RequestBody String name) {
    return productService.saveProduct(name);
  }
}
