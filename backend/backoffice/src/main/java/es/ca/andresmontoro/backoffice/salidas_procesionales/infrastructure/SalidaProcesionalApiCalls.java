package es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure.FormacionMusicalResponse;

@Service
public class SalidaProcesionalApiCalls {
  
  private static final String baseUri = "http://information/chatcofrade/informacion/salidaProcesional";
  private WebClient webClient;

  public SalidaProcesionalApiCalls(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl(baseUri).build();
  }

  public SalidaProcesionalResponse create(SalidaProcesionalRequest dto) {
    return this.webClient.post()
      .uri(baseUri)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(SalidaProcesionalResponse.class)
      .block();
  }

  public List<SalidaProcesionalResponse> findAll() {
    return this.webClient.get()
      .uri(baseUri)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToFlux(SalidaProcesionalResponse.class)
      .collectList()
      .block();
  }

  public SalidaProcesionalResponse findById(Long id) {
    return this.webClient.get()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(SalidaProcesionalResponse.class)
      .block();
  }

  public SalidaProcesionalResponse update(Long id, SalidaProcesionalRequest dto) {
    return this.webClient.put()
      .uri(baseUri + "/" + id)
      .bodyValue(dto)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(SalidaProcesionalResponse.class)
      .block();
  }

  public SalidaProcesionalResponse deleteById(Long id) {
    return this.webClient.delete()
      .uri(baseUri + "/" + id)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToMono(SalidaProcesionalResponse.class)
      .block();
  }

  public List<FormacionMusicalResponse> findFormacionesByIdSalida(Long idSalida) {
    return this.webClient.get()
      .uri(baseUri + "/getFormacionesByIdSalida" + idSalida)
      .retrieve()
      .onStatus(
        HttpStatusCode::isError,
        response -> response.bodyToMono(String.class).map(Exception::new))
      .bodyToFlux(FormacionMusicalResponse.class)
      .collectList()
      .block();
  }
}
