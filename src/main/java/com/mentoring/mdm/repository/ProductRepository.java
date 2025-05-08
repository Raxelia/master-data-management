package com.mentoring.mdm.repository;

import com.mentoring.mdm.model.Product;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {

  // --- READ ---
  List<Product> findByName(String name);

  @Query("{'name': ?0}")
  List<Product> findProductsByExactName(String name);

  // --- SAVE ---
  // using default save in mongorepository without ovverridng it
}
