package com.mentoring.mdm.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.mentoring.mdm.TestContainerInitializer;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = TestContainerInitializer.class)
@Import({
  TestConfig.class,
  TestScopedServiceConfig.class,
  TestSessionScopeConfig.class,
  MockScopedServiceConfig.class
})
class ProductServiceTest {

  @Autowired private ProductService productService;

  @Autowired private ProductRepository productRepository;

  @AfterEach
  void cleanUp() {
    productRepository.deleteAll();
  }

  @Test
  void testGetProductsByNameMagic() {
    Product product = new Product();
    product.setName("Laptop");
    product.setCategory("Electronics");
    productRepository.save(product);

    List<Product> products = productService.getProductsByNameMagic("Laptop");

    assertThat(products).isNotEmpty();
    assertThat(products.getFirst().getName()).isEqualTo("Laptop");
    assertThat(products.getFirst().getCategory()).isEqualTo("Electronics");
  }

  @Test
  void testGetProductsByNameCustom() {

    Product product = new Product();
    product.setName("Smartphone");
    product.setCategory("Gadgets");
    productRepository.save(product);

    List<Product> products = productService.getProductsByNameCustom("Smartphone");

    assertThat(products).isNotEmpty();
    assertThat(products.getFirst().getName()).isEqualTo("Smartphone");
    assertThat(products.getFirst().getCategory()).isEqualTo("Gadgets");
  }

  @Test
  void testSaveProduct() {

    Product product = new Product();
    product.setName("Tablet");
    product.setCategory("Gadgets");

    Product savedProduct = productService.saveProduct(product);

    assertThat(savedProduct.getId()).isNotNull();
    assertThat(savedProduct.getName()).isEqualTo("Tablet");
    assertThat(savedProduct.getCategory()).isEqualTo("Gadgets");
  }

  @Test
  void testUpdateProductCategory() {

    Product product = new Product();
    product.setName("Speaker");
    product.setCategory("Audio");
    Product savedProduct = productRepository.save(product);

    productService.updateProductCategory(savedProduct.getId(), "Electronics");

    Product updatedProduct = productRepository.findById(savedProduct.getId()).orElseThrow();
    assertThat(updatedProduct.getCategory()).isEqualTo("Electronics");
  }
}
