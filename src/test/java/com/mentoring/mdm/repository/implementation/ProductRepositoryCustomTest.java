package com.mentoring.mdm.repository.implementation;

import static org.assertj.core.api.Assertions.assertThat;

import com.mentoring.mdm.config.MockScopedServiceConfig;
import com.mentoring.mdm.config.TestConfig;
import com.mentoring.mdm.config.TestScopedServiceConfig;
import com.mentoring.mdm.config.TestSessionScopeConfig;
import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.repository.ProductRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

@DataMongoTest
@Import({
  TestConfig.class,
  TestScopedServiceConfig.class,
  TestSessionScopeConfig.class,
  MockScopedServiceConfig.class
})
class ProductRepositoryCustomTest {

  @Autowired private ProductRepository productRepository;

  @AfterEach
  void cleanUp() {
    productRepository.deleteAll();
  }

  @Test
  void testFindByNameUsingCriteria() {
    // prepare data
    Product product = new Product();
    product.setName("Camera");
    product.setCategory("Photography");
    productRepository.save(product);

    // execute custom Criteria API query
    List<Product> products = productRepository.findByNameUsingCriteria("Camera");

    assertThat(products).isNotEmpty();
    // using List.get(0) or getFirst() depending on your util:

    Product found = products.get(0);
    assertThat(found.getName()).isEqualTo("Camera");
    assertThat(found.getCategory()).isEqualTo("Photography");
  }
}
