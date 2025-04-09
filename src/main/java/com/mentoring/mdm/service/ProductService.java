package com.mentoring.mdm.service;

import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.repository.ProductRepository;
import com.mentoring.mdm.utilites.ProductProcessor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  /*
   ObjectFactory<ProductProcessor> is injected into the singleton-scoped ProductService.
   When you call productProcessorFactory.getObject(), a new instance of ProductProcessor is created and returned.
  */
  private final ObjectFactory<ProductProcessor> productProcessorFactory;

  public Product saveProduct(String name) {
    ProductProcessor processor = productProcessorFactory.getObject();
    processor.processProductName(name);
    Product product = new Product();
    product.setName(name);
    return productRepository.save(product);
  }
}
