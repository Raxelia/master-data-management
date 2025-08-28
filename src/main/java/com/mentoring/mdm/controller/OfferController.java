package com.mentoring.mdm.controller;

import com.mentoring.mdm.service.OfferRequestScopedService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
@AllArgsConstructor
public class OfferController {

  private final OfferRequestScopedService offerRequestScopedService;

  @GetMapping("/{productName}")
  public String getOfferForProduct(@PathVariable String productName) {
    offerRequestScopedService.generateRequestSpecificOffer(productName);
    return offerRequestScopedService.getOffer();
  }
}
