package com.mentoring.mdm.service;

import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public Product saveProduct(String name) {
    Product product = new Product(null, name);
    return productRepository.save(product);
  }
}
