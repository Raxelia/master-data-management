package com.mentoring.mdm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy;

@Slf4j
@Component
public class TestContainerInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  public static final String MONGO_IMAGE_NAME = "mongo:latest";
  public static final int MONGO_PORT = 27017;

  private static final MongoDBContainer MONGO_DB_CONTAINER =
      new MongoDBContainer(MONGO_IMAGE_NAME).withReuse(true).waitingFor(new HostPortWaitStrategy());

  static {
    MONGO_DB_CONTAINER.start();
  }

  @Override
  public void initialize(final ConfigurableApplicationContext configurableApplicationContext) {
    String mongoUrl =
        "mongodb://%s:%d"
            .formatted(MONGO_DB_CONTAINER.getHost(), MONGO_DB_CONTAINER.getMappedPort(MONGO_PORT));
    TestPropertyValues.of("spring.data.mongodb.uri=" + mongoUrl)
        .applyTo(configurableApplicationContext.getEnvironment());
    log.info("Mongo URL: " + mongoUrl);
  }
}
