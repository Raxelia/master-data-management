package com.mentoring.mdm.config;

import com.mentoring.mdm.utilites.LiveOfferSession;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

  @Bean
  public LiveOfferSession liveOfferSession() {
    return new LiveOfferSession();
  }
}
