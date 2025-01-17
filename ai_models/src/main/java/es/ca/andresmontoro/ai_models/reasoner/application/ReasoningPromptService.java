package es.ca.andresmontoro.ai_models.reasoner.application;

import org.springframework.stereotype.Service;

import dev.langchain4j.model.github.GitHubModelsChatModel;
import dev.langchain4j.service.AiServices;
import es.ca.andresmontoro.ai_models.information_finder.application.SuggestedInformationList;
import es.ca.andresmontoro.ai_models.reasoner.infrastructure.PromptReasoner;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReasoningPromptService {

  private final GitHubModelsChatModel gitHubModelsChatModel;

  public String reasonPrompt(String userPrompt, SuggestedInformationList suggestedInformation) {
    PromptReasoner promptReasoner = AiServices.create(PromptReasoner.class, gitHubModelsChatModel);
    return promptReasoner.reasonPrompt(userPrompt, suggestedInformation);
  }
}
