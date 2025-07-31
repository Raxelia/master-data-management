package com.mentoring.mdm.repository;

import com.mentoring.mdm.model.Product;
import java.util.List;

public interface ProductRepositoryCustom {
  List<Product> findByNameUsingCriteria(String name);
}
