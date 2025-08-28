package com.mentoring.mdm.config;

import com.mentoring.mdm.service.OfferRequestScopedService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestScopedServiceConfig {

  @Bean
  public OfferRequestScopedService offerRequestScopedService() {
    OfferRequestScopedService mockService = Mockito.mock(OfferRequestScopedService.class);
    Mockito.when(mockService.getOffer()).thenReturn("Test Offer");
    return mockService;
  }
}
