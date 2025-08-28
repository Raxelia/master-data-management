package com.mentoring.mdm.service;

import com.mentoring.mdm.utilites.ProductProcessor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * prototype-scoped bean into a singleton-scoped bean. only one instance of ProductProcessor being
 * used for all calls, even though it's a prototype If there will be a multiple requests, they will
 * overwrite the same instance of ProductProcessor
 */
@Service
@AllArgsConstructor
public class ImproperInjectionService {
  private final ProductProcessor productProcessor;

  public String processProductImproperly(String productName) {
    productProcessor.processProductName(productName);
    return "Improperly processed product name: " + productProcessor.getProcessedProductName();
  }
}
