package es.ca.andresmontoro.information.localidades.infrastructure.controller;

import es.ca.andresmontoro.information.localidades.domain.Ciudad;
import es.ca.andresmontoro.information.provincias.domain.Provincia;

public class CiudadMapper {

  public static CiudadResponse toResponse(Ciudad ciudad) {
    return CiudadResponse.builder()
      .id(ciudad.getId())
      .nombre(ciudad.getNombre())
      .provinciaId(ciudad.getProvincia().getId())
      .provinciaNombre(ciudad.getProvincia().getNombre())
      .build();
  }

  public static Ciudad toCiudad(CiudadRequest request, Provincia provincia) {
    return Ciudad.builder()
      .nombre(request.getNombre())
      .provincia(provincia)
      .build();
  }
}
