package es.ca.andresmontoro.backoffice.localidades.comunidades.infrastructure;

import java.util.List;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ComunidadAutonomaApiCalls {
  
  private static final String baseUri = "http://information/chatcofrade/informacion/comunidad";
  private WebClient webClient;

  public ComunidadAutonomaApiCalls(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl(baseUri).build();
  }

  public ComunidadAutonomaResponse create(ComunidadAutonomaRequest dto) {
    return this.webClient.post()
      .uri(baseUri)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(ComunidadAutonomaResponse.class)
      .block();
  }

  public List<ComunidadAutonomaResponse> findAll() {
    return this.webClient.get()
      .uri(baseUri)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToFlux(ComunidadAutonomaResponse.class)
      .collectList()
      .block();
  }

  public ComunidadAutonomaResponse findById(Long id) {
    return this.webClient.get()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(ComunidadAutonomaResponse.class)
      .block();
  }

  public ComunidadAutonomaResponse update(Long id, ComunidadAutonomaRequest dto) {
    return this.webClient.put()
      .uri(baseUri + "/" + id)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(ComunidadAutonomaResponse.class)
      .block();
  }

  public ComunidadAutonomaResponse deleteById(Long id) {
    return this.webClient.delete()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(ComunidadAutonomaResponse.class)
      .block();
  }
}
