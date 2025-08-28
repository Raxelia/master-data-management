package com.mentoring.mdm.service;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/*
   Session: User Session Product Cart
   Each user needs their own cart or session state.
*/
@Getter
@Service
@Scope("session")
public class SessionProductService {

  private final List<String> selectedProducts = new ArrayList<>();

  public void addProduct(String productName) {
    selectedProducts.add(productName);
  }
}
