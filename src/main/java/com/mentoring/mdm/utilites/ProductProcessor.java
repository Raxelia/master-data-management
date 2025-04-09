package com.mentoring.mdm.utilites;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
   Prototype: Temporary Product Processor
   Each task or request needs its own instance. We don’t want data from one request sticking around.
*/
@Getter
@Component
@Scope("prototype")
public class ProductProcessor {

  private String processedProductName;

  public void processProductName(String name) {
    this.processedProductName = name.trim().toUpperCase();
  }
}
