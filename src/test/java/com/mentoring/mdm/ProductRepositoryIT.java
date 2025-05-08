package com.mentoring.mdm;

import static org.assertj.core.api.Assertions.assertThat;

import com.mentoring.mdm.config.MockScopedServiceConfig;
import com.mentoring.mdm.config.TestConfig;
import com.mentoring.mdm.config.TestScopedServiceConfig;
import com.mentoring.mdm.config.TestSessionScopeConfig;
import com.mentoring.mdm.model.Product;
import com.mentoring.mdm.repository.ProductRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@IntegrationTests
@Import({
  TestConfig.class,
  TestScopedServiceConfig.class,
  TestSessionScopeConfig.class,
  MockScopedServiceConfig.class
})
class ProductRepositoryIT {

  @Autowired private ProductRepository productRepository;

  @AfterEach
  void cleanUp() {
    productRepository.deleteAll();
  }

  @BeforeEach
  void cleanUpBefore() {
    productRepository.deleteAll();
  }

  @Test
  void shouldSaveAndRetrieveProduct() {
    Product product = new Product();
    product.setName("Test Product");
    product = productRepository.save(product);

    List<Product> products = productRepository.findAll();

    assertThat(products).hasSize(1);
    assertThat(products.getFirst().getName()).isEqualTo("Test Product");
  }

  @Test
  void shouldStartWithNoProducts() {
    List<Product> products = productRepository.findAll();
    assertThat(products).isEmpty();
  }
}
