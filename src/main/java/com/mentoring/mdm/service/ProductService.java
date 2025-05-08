package com.mentoring.mdm.service;

import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.repository.ProductRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final MongoTemplate mongoTemplate;

  // --- READ ---
  public List<Product> getProductsByNameMagic(String name) {
    return productRepository.findByName(name);
  }

  public List<Product> getProductsByNameCustom(String name) {
    return productRepository.findProductsByExactName(name);
  }

  // --- SAVE ---
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  public void updateProductCategory(String productId, String newCategory) {
    Query query = new Query(Criteria.where("_id").is(productId)); // Query by ID
    Update update = new Update().set("category", newCategory); // Update the category field

    mongoTemplate.updateFirst(query, update, Product.class);
  }
}
