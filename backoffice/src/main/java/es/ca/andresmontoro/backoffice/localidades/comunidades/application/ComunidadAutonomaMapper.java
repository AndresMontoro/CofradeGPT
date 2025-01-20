package es.ca.andresmontoro.backoffice.localidades.comunidades.application;

import es.ca.andresmontoro.backoffice.localidades.comunidades.infrastructure.ComunidadAutonomaRequest;
import es.ca.andresmontoro.backoffice.localidades.comunidades.infrastructure.ComunidadAutonomaResponse;

public class ComunidadAutonomaMapper {
  
  public static ComunidadAutonomaRequest toRequest(ComunidadAutonomaResponse request) {
    return ComunidadAutonomaRequest.builder()
      .nombre(request.getNombre())
      .build();
  } 
}
