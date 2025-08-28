package com.mentoring.mdm.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.mentoring.mdm.config.MockScopedServiceConfig;
import com.mentoring.mdm.config.TestConfig;
import com.mentoring.mdm.config.TestScopedServiceConfig;
import com.mentoring.mdm.config.TestSessionScopeConfig;
import com.mentoring.mdm.model.Product;
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
class ProductRepositoryTest {

  @Autowired private ProductRepository productRepository;

  @AfterEach
  void cleanUp() {
    productRepository.deleteAll();
  }

  @Test
  void testFindByName_MagicQuery() {
    Product product = new Product();
    product.setName("Laptop");
    product.setCategory("Electronics");
    productRepository.save(product);

    List<Product> products = productRepository.findByName("Laptop");

    assertThat(products).isNotEmpty();
    assertThat(products.getFirst().getName()).isEqualTo("Laptop");
    assertThat(products.getFirst().getCategory()).isEqualTo("Electronics");
  }

  @Test
  void testFindProductsByExactName_CustomQuery() {

    Product product = new Product();
    product.setName("Smartphone");
    product.setCategory("Gadgets");
    productRepository.save(product);

    List<Product> products = productRepository.findProductsByExactName("Smartphone");

    assertThat(products).isNotEmpty();
    assertThat(products.getFirst().getName()).isEqualTo("Smartphone");
    assertThat(products.getFirst().getCategory()).isEqualTo("Gadgets");
  }

  @Test
  void testSaveProduct() {
    Product product = new Product();
    product.setName("Tablet");
    product.setCategory("Gadgets");

    Product savedProduct = productRepository.save(product);

    assertThat(savedProduct.getId()).isNotNull();
    assertThat(savedProduct.getName()).isEqualTo("Tablet");
    assertThat(savedProduct.getCategory()).isEqualTo("Gadgets");
  }
}
