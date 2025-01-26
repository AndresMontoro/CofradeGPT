package es.ca.andresmontoro.ai_models.shared.infrastructure.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import es.ca.andresmontoro.ai_models.cofrade_ai.application.LoggingDTO;

@Configuration
public class kafkaProducerConfig {

  private final static String BOOTSTRAPSERVERS = "localhost:9092";

  @Bean
  public ProducerFactory<String, LoggingDTO> producerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(
      ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
      BOOTSTRAPSERVERS
    );
    configProps.put(
      ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
      StringSerializer.class
    );
    configProps.put(
      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
      JsonSerializer.class
    );
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  public KafkaTemplate<String, LoggingDTO> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}
