package es.ca.andresmontoro.ai_logs.logs.application;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.ai_logs.kafka.application.LoggingDTO;
import es.ca.andresmontoro.ai_logs.logs.domain.Log;
import es.ca.andresmontoro.ai_logs.logs.infrastructure.LogRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageLogUseCase {
  
  private final LogRepository logRepository;

  public LoggingDTO create(LoggingDTO loggingDTO) {
    Log log = logRepository.save(LogMapper.toLog(loggingDTO));
    return LogMapper.toLoggingDTO(log);
  }
}
