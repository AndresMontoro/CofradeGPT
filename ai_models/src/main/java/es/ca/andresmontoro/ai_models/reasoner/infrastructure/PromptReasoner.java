package es.ca.andresmontoro.ai_models.reasoner.infrastructure;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import es.ca.andresmontoro.ai_models.information_finder.application.SuggestedInformationList;

public interface PromptReasoner {
  @SystemMessage("""
    Responde unicamente lo que te dice el usuario en {{information}}
  """)
  String reasonPrompt(
    @UserMessage("userPrompt") String userPrompt, 
    @V("information") SuggestedInformationList suggestedInformation);
}