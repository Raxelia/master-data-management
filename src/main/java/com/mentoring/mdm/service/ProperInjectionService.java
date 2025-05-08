package com.mentoring.mdm.service;

import com.mentoring.mdm.utilites.ProductProcessor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

/**
 * prototype-scoped bean into a singleton-scoped bean. Thanks to ObjectFactory we create a new
 * instance of the prototype-scoped bean for every method call
 */
@Service
@AllArgsConstructor
public class ProperInjectionService {
  private final ObjectFactory<ProductProcessor> productProcessorFactory;

  public String processProductProperly(String productName) {
    ProductProcessor productProcessor = productProcessorFactory.getObject();
    productProcessor.processProductName(productName);
    return "Properly processed product name: " + productProcessor.getProcessedProductName();
  }
}
