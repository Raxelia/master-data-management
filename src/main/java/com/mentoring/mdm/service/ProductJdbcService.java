package com.mentoring.mdm.service;

import com.mentoring.mdm.model.ProductJdbc;
import com.mentoring.mdm.repository.ProductJdbcRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductJdbcService {

  private final ProductJdbcRepository productJdbcRepository;

  public List<ProductJdbc> getProductsByName(String name) {
    return productJdbcRepository.findByName(name);
  }

  public ProductJdbc saveProduct(ProductJdbc product) {
    return productJdbcRepository.save(product);
  }
}
