package com.mongo.multitenancy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongo.multitenancy.util.ConnectionStorage;
import com.mongodb.ConnectionString;

@Configuration
public class MongoConfig{

  @Bean
  @Lazy
  public MongoTemplate mongoTemplate() {
    ConnectionString connectionString = new ConnectionString(ConnectionStorage.getConnection());
    return new MongoTemplate(new DatabaseConfig(connectionString));
  }
}