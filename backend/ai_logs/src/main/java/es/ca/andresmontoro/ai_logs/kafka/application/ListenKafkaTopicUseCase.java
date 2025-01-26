package es.ca.andresmontoro.ai_logs.kafka.application;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import es.ca.andresmontoro.ai_logs.logs.application.ManageLogUseCase;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListenKafkaTopicUseCase {
  
  private final ManageLogUseCase manageLogUseCase;

  @KafkaListener(
    topics = "ai-logs",
    containerFactory = "kafkaListenerContainerFactory",
    groupId = "ai-logs-group"
  )
  public void listen(LoggingDTO logs) {
    System.out.println("Received message in group ai-logs-group: " + logs.toString());
    manageLogUseCase.create(logs);
  }
}
