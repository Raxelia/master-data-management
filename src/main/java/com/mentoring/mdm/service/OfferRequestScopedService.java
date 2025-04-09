package com.mentoring.mdm.service;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/*
   Request: Request-Specific Offer
   The offer is unique to this specific request. Once the HTTP request is done, we don’t need it anymore.
*/
@Getter
@Service
@Scope("request")
public class OfferRequestScopedService {

  private String offer;

  public void generateRequestSpecificOffer(String productName) {
    this.offer = "Special Offer for " + productName + ": 10% OFF";
  }
}
