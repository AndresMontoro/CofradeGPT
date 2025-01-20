package es.ca.andresmontoro.backoffice.localidades.provincias.application;

import es.ca.andresmontoro.backoffice.localidades.provincias.infrastructure.ProvinciaRequest;
import es.ca.andresmontoro.backoffice.localidades.provincias.infrastructure.ProvinciaResponse;

public class ProvinciaMapper {
  
  public static ProvinciaRequest toRequest(ProvinciaResponse request) {
    return ProvinciaRequest.builder()
      .nombre(request.getNombre())
      .comunidadAutonomaId(request.getComunidadAutonomaId())
      .build();
  }
}
