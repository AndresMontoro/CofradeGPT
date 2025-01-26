package es.ca.andresmontoro.vaadin_chat.information_finder;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class InformationFinderApiCalls {
  
  private static final String baseUri = "http://AImodels/chatcofrade/ai/cofrade";
  private WebClient webClient;

  public InformationFinderApiCalls(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl(baseUri).build();
  }

  public String sendPrompt(String prompt) {
    return this.webClient.post()
      .uri(baseUri)
      .bodyValue(prompt)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(String.class)
      .block();
  }
}
