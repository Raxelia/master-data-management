package com.mentoring.mdm.config;

import com.mentoring.mdm.service.SessionProductService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@TestConfiguration
public class TestSessionScopeConfig {

  @Bean
  @Scope("singleton")
  public SessionProductService sessionProductService() {
    return new SessionProductService();
  }
}
