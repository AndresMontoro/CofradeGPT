package es.ca.andresmontoro.backoffice.localidades.provincias.infrastructure;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProvinciaApiCalls {
  private static final String baseUri = "http://information/chatcofrade/informacion/provincia";
  private WebClient webClient;

  public ProvinciaApiCalls(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl(baseUri).build();
  }

  public ProvinciaResponse create(ProvinciaRequest dto) {
    return this.webClient.post()
      .uri(baseUri)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(ProvinciaResponse.class)
      .block();
  }

  public List<ProvinciaResponse> findAll() {
    return this.webClient.get()
      .uri(baseUri)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToFlux(ProvinciaResponse.class)
      .collectList()
      .block();
  }

  public ProvinciaResponse findById(Long id) {
    return this.webClient.get()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(ProvinciaResponse.class)
      .block();
  }

  public ProvinciaResponse update(Long id, ProvinciaRequest dto) {
    return this.webClient.put()
      .uri(baseUri + "/" + id)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(ProvinciaResponse.class)
      .block();
  }

  public ProvinciaResponse deleteById(Long id) {
    return this.webClient.delete()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(ProvinciaResponse.class)
      .block();
  }
}
