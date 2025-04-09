package com.mentoring.mdm.controller;

import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
@Tag(name = "Product API", description = "Endpoints for managing products")
@AllArgsConstructor
public class ProductController {

  private final ProductService productService;

  /*
  Singleton: Global Product Service
  We just need one instance for this service; no point creating multiple—same logic used everywhere anyway.
  */
  @Operation(
      summary = "Save product name",
      description = "Save the name of the product",
      responses = {
        @ApiResponse(responseCode = "200", description = "Product saved successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input provided"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
      })
  @PostMapping(
      path = "/product",
      consumes = MediaType.TEXT_PLAIN_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Product saveProduct(@RequestBody String name) {
    return productService.saveProduct(name);
  }
}
