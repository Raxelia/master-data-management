package com.mentoring.mdm.controller;

import com.mentoring.mdm.service.SessionProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket-products")
@AllArgsConstructor
public class SessionProductController {

  private final SessionProductService sessionProductService;

  @PostMapping("/{productName}")
  public String addProductToSession(@PathVariable String productName) {
    sessionProductService.addProduct(productName);
    return "Product added to basket: " + productName;
  }

  @GetMapping
  public List<String> getSessionProducts() {
    return sessionProductService.getSelectedProducts();
  }
}
