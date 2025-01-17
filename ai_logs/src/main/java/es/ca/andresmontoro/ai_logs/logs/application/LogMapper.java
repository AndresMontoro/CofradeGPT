package es.ca.andresmontoro.ai_logs.logs.application;

import es.ca.andresmontoro.ai_logs.kafka.application.LoggingDTO;
import es.ca.andresmontoro.ai_logs.logs.domain.Log;

public class LogMapper {
  public static Log toLog(LoggingDTO loggingDTO) {
    return Log.builder()
      .userPrompt(loggingDTO.getUserPrompt())
      .aiResponse(loggingDTO.getAiResponse())
      .build();
  }

  public static LoggingDTO toLoggingDTO(Log log) {
    return LoggingDTO.builder()
      .userPrompt(log.getUserPrompt())
      .aiResponse(log.getAiResponse())
      .build();
  }
}
