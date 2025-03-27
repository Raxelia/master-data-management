package com.mentoring.mdm.repository;

import com.mentoring.mdm.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
  // TODO more complex custom query
}
