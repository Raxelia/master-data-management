package com.mentoring.mdm.config;

import com.mentoring.mdm.service.OfferRequestScopedService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@TestConfiguration
public class MockScopedServiceConfig {

  @Bean
  @Primary
  @Scope("singleton")
  public OfferRequestScopedService mockOfferRequestScopedService() {
    OfferRequestScopedService mockService = Mockito.mock(OfferRequestScopedService.class);
    Mockito.when(mockService.getOffer()).thenReturn("Test Offer");
    return mockService;
  }
}
