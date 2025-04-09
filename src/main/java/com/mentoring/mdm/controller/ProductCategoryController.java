package com.mentoring.mdm.controller;

import com.mentoring.mdm.service.ProductCategoryService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class ProductCategoryController {

  private final ProductCategoryService productCategoryService;

  @GetMapping
  public List<String> getProductCategories() {
    return productCategoryService.getCategories();
  }
}
