package es.ca.andresmontoro.ai_models.information;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import reactor.core.publisher.Mono;

@Service
public class InformationApiCalls {
  
  private final static String baseUri = "http://information";
  private WebClient webClient;

  public InformationApiCalls(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl(baseUri).build();
  }

  public String getApiDocumentation() {
    return webClient.get()
      .uri(UriComponentsBuilder.fromPath("/v3/api-docs")
        .build().toUriString())
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).flatMap(errorBody -> {
          return Mono.error(new RuntimeException("API error: " + errorBody));
        }))
      .bodyToMono(String.class)
      .blockOptional()
      .orElseThrow(() -> new RuntimeException("API response is null"));
  }

  public List<Map<String, String>> getEndpoint(String endpoint) {
    return webClient.get()
      .uri(UriComponentsBuilder.fromPath("/chatcofrade/informacion" + endpoint)
        .build().toUriString())
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).flatMap(errorBody -> {
          return Mono.error(new RuntimeException("API error: " + errorBody));
        }))
      .bodyToMono(new ParameterizedTypeReference<List<Map<String, String>>>() {})
      .blockOptional()
      .orElseThrow(() -> new RuntimeException("API response is null"));
  }
}
