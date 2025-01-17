package es.ca.andresmontoro.ai_models.shared.infrastructure.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

  private final static String BOOTSTRAPSERVERS = "localhost:9092";
  private final static String TOPIC_NAME = "ai-logging";

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAPSERVERS);
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic newAiLoggingTopic() {
    return TopicBuilder.name(TOPIC_NAME)
      .build();
  }
}
