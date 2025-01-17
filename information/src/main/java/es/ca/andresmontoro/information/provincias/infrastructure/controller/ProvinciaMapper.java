package es.ca.andresmontoro.information.provincias.infrastructure.controller;

import es.ca.andresmontoro.information.comunidades.domain.ComunidadAutonoma;
import es.ca.andresmontoro.information.provincias.domain.Provincia;

public class ProvinciaMapper {
  
  public static ProvinciaResponse toResponse(Provincia provincia) {
    return ProvinciaResponse.builder()
      .id(provincia.getId())
      .nombre(provincia.getNombre())
      .comunidadAutonomaId(provincia.getComunidadAutonoma().getId())
      .build();
  }

  public static Provincia toProvincia(ProvinciaRequest provincia, 
  ComunidadAutonoma comunidadAutonoma) {
    return Provincia.builder()
      .nombre(provincia.getNombre())
      .comunidadAutonoma(comunidadAutonoma)
      .build();
  }
}
