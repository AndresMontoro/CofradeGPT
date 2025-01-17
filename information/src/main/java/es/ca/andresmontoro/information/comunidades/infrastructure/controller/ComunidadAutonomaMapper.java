package es.ca.andresmontoro.information.comunidades.infrastructure.controller;

import es.ca.andresmontoro.information.comunidades.domain.ComunidadAutonoma;

public class ComunidadAutonomaMapper {
  public static ComunidadAutonomaResponse toResponse(ComunidadAutonoma comunidadAutonoma) {
    return ComunidadAutonomaResponse.builder()
      .id(comunidadAutonoma.getId())
      .nombre(comunidadAutonoma.getNombre())
      .build();
  }

  public static ComunidadAutonoma toComunidadAutonoma(ComunidadAutonomaRequest request) {
    return ComunidadAutonoma.builder()
      .nombre(request.getNombre())
      .build();
  }
}
