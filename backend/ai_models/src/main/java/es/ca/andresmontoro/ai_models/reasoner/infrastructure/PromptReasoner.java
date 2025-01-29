package es.ca.andresmontoro.ai_models.reasoner.infrastructure;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import es.ca.andresmontoro.ai_models.information_finder.application.SuggestedInformationList;

public interface PromptReasoner {
  @SystemMessage("""
    Responde unicamente lo que te dice el usuario en {{information}}

    Responde en texto plano. No uses markdown ni menciones que te he dado la informacion previamente.
    No uses frases como "De las hermandades mencionadas...".
  """)
  String reasonPrompt(
    @UserMessage("userPrompt") String userPrompt, 
    @V("information") SuggestedInformationList suggestedInformation);
}