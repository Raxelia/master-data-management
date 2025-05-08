package com.mentoring.mdm.controller;

import com.mentoring.mdm.service.ImproperInjectionService;
import com.mentoring.mdm.service.ProperInjectionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ImproperAndImproperInjectionController {

  private final ImproperInjectionService improperInjectionService;

  private final ProperInjectionService properInjectionService;

  @GetMapping("/proper-injection")
  public String properInjection(@RequestParam String productName) {
    return properInjectionService.processProductProperly(productName);
  }

  @GetMapping("/improper-injection")
  public String improperInjection(@RequestParam String productName) {
    return improperInjectionService.processProductImproperly(productName);
  }
}
