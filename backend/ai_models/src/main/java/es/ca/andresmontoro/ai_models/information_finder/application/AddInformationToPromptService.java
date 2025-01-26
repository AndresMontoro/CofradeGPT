package es.ca.andresmontoro.ai_models.information_finder.application;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import dev.langchain4j.model.github.GitHubModelsChatModel;
import dev.langchain4j.service.AiServices;
import es.ca.andresmontoro.ai_models.information.InformationApiCalls;
import es.ca.andresmontoro.ai_models.information_finder.infrastructure.SuggestInformationEndpointAgent;
import es.ca.andresmontoro.ai_models.information_finder.infrastructure.SuggestedInformationApiEndpoint;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddInformationToPromptService {

  private final InformationApiCalls informationApiCalls;
  private final GitHubModelsChatModel gitHubModelsChatModel;

  public SuggestedInformationList addInformationToUserPrompt(String userPrompt) {
    String apiDocumentation = informationApiCalls.getApiDocumentation();
    SuggestedInformationList informationAlreadyFound = new SuggestedInformationList();
    if(informationAlreadyFound.getInformation() == null) {
      informationAlreadyFound.setInformation(new ArrayList<>());
    }

    SuggestInformationEndpointAgent suggestInformationEndpointAgent = 
      AiServices.create(SuggestInformationEndpointAgent.class, gitHubModelsChatModel);

    SuggestedInformationApiEndpoint suggestedEndpoint;
   
    do {
      suggestedEndpoint = suggestInformationEndpointAgent.suggest(
        userPrompt, apiDocumentation, informationAlreadyFound);

      System.out.println("Suggested endpoint: " + suggestedEndpoint.getApiEndPoint());

      if(suggestedEndpoint != null && suggestedEndpoint.getApiEndPoint() != null 
      && !suggestedEndpoint.getApiEndPoint().isEmpty()) {
        SuggestedInformation suggestedInformation = SuggestedInformation.builder()
          .apiEndPoint(suggestedEndpoint.getApiEndPoint())
          .information(informationApiCalls.getEndpoint(suggestedEndpoint.getApiEndPoint()))
          .build();

        informationAlreadyFound.getInformation().add(suggestedInformation);
      }
    } while (suggestedEndpoint.isNeedMoreInformation());
      
    return informationAlreadyFound;
  }  
}
