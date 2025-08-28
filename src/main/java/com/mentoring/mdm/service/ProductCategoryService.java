package com.mentoring.mdm.service;

import java.util.List;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/*
   Application: Global Product Categories
   This is global, static stuff that’s useful everywhere. No need to update it or create more copies.
*/
@Getter
@Service
@Scope("application")
public class ProductCategoryService {

  private final List<String> categories;

  public ProductCategoryService() {
    this.categories = List.of("Electronics", "Clothing", "Food", "Drinks");
  }
}
