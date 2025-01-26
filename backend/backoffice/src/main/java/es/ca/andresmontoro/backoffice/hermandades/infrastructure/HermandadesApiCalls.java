package es.ca.andresmontoro.backoffice.hermandades.infrastructure;

import java.util.List;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HermandadesApiCalls {
  
  private static final String baseUri = "http://information/chatcofrade/informacion/hermandad";
  private WebClient webClient;

  public HermandadesApiCalls(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl(baseUri).build();
  }

  public HermandadResponse create(HermandadRequest dto) {
    return this.webClient.post()
      .uri(baseUri)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(HermandadResponse.class)
      .block();
  }

  public List<HermandadResponse> findAll() {
    return this.webClient.get()
      .uri(baseUri)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToFlux(HermandadResponse.class)
      .collectList()
      .block();
  }

  public HermandadResponse findById(Long id) {
    return this.webClient.get()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(HermandadResponse.class)
      .block();
  }

  public HermandadResponse update(Long id, HermandadRequest dto) {
    return this.webClient.put()
      .uri(baseUri + "/" + id)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(HermandadResponse.class)
      .block();
  }

  public HermandadResponse deleteById(Long id) {
    return this.webClient.delete()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(HermandadResponse.class)
      .block();
  }
}
