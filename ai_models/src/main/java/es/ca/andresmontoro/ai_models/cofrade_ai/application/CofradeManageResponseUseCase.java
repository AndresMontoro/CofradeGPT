package es.ca.andresmontoro.ai_models.cofrade_ai.application;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import es.ca.andresmontoro.ai_models.information_finder.application.AddInformationToPromptService;
import es.ca.andresmontoro.ai_models.information_finder.application.SuggestedInformationList;
import es.ca.andresmontoro.ai_models.reasoner.application.ReasoningPromptService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CofradeManageResponseUseCase {

  private final AddInformationToPromptService addInformationToPromptService;
  private final ReasoningPromptService reasoningPromptService;
  private KafkaTemplate<String, LoggingDTO> kafkaTemplate;

  public String getResponse(String userPrompt) {
    SuggestedInformationList suggestedInformation = addInformationToPromptService.addInformationToUserPrompt(userPrompt);
    System.out.println("\n\n\nSuggested information: \n" + suggestedInformation);
    String response = reasoningPromptService.reasonPrompt(userPrompt, suggestedInformation);
    if (response != null) {
      LoggingDTO loggingDTO = new LoggingDTO(userPrompt, response);
      kafkaTemplate.send("ai-logs", loggingDTO);
    }
    
    return response;
  }

}
