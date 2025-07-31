package com.mentoring.mdm.repository.implementation;

import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.repository.ProductRepositoryCustom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

  @Autowired private MongoTemplate mongoTemplate;

  @Override
  public List<Product> findByNameUsingCriteria(String name) {
    Query query = new Query();
    query.addCriteria(Criteria.where("name").is(name));
    return mongoTemplate.find(query, Product.class);
  }
}
