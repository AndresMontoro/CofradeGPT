package es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class FormacionMusicalApiCalls {
  
  private static final String baseUri = "http://information/chatcofrade/informacion/formacion-musical";
  private WebClient webClient;

  public FormacionMusicalApiCalls(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl(baseUri).build();
  }

  public FormacionMusicalResponse create(FormacionMusicalRequest dto) {
    return this.webClient.post()
      .uri(baseUri)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(FormacionMusicalResponse.class)
      .block();
  }

  public List<FormacionMusicalResponse> findAll() {
    return this.webClient.get()
      .uri(baseUri)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToFlux(FormacionMusicalResponse.class)
      .collectList()
      .block();
  }

  public FormacionMusicalResponse findById(Long id) {
    return this.webClient.get()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(FormacionMusicalResponse.class)
      .block();
  }

  public FormacionMusicalResponse update(Long id, FormacionMusicalRequest dto) {
    return this.webClient.put()
      .uri(baseUri + "/" + id)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(FormacionMusicalResponse.class)
      .block();
  }

  public FormacionMusicalResponse deleteById(Long id) {
    return this.webClient.delete()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(FormacionMusicalResponse.class)
      .block();
  }
}
