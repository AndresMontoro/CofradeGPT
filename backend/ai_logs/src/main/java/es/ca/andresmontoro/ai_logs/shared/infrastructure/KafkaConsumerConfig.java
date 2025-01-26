package es.ca.andresmontoro.ai_logs.shared.infrastructure;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import es.ca.andresmontoro.ai_logs.kafka.application.LoggingDTO;

@Configuration
public class KafkaConsumerConfig {
  
  private final static String BOOTSTRAPSERVERS = "localhost:9092";

  @Bean
  public ConsumerFactory<String, LoggingDTO> consumerFactory() {
    Map<String, Object> props = new HashMap<>();

    props.put(
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
      BOOTSTRAPSERVERS);

    // Error handling configuration
    props.put(
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
      ErrorHandlingDeserializer.class);
    props.put(
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
      ErrorHandlingDeserializer.class);

    // Deserializer configuration
    props.put(
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
      StringDeserializer.class);
    props.put(
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
      JsonDeserializer.class);

    // Trusted packages configuration
    props.put(
      JsonDeserializer.TRUSTED_PACKAGES,
      "*");
    props.put(
      JsonDeserializer.USE_TYPE_INFO_HEADERS, 
      false);
    
    return new DefaultKafkaConsumerFactory<>(
      props,
      new ErrorHandlingDeserializer<>(new StringDeserializer()),
      new ErrorHandlingDeserializer<>(new JsonDeserializer<>(LoggingDTO.class))
    );
  } 
  
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, LoggingDTO> 
    kafkaListenerContainerFactory() {
      ConcurrentKafkaListenerContainerFactory<String, LoggingDTO> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory());
      return factory;
  }
}
