package es.ca.andresmontoro.backoffice.localidades.ciudades.application;

import es.ca.andresmontoro.backoffice.localidades.ciudades.infrastructure.CiudadRequest;
import es.ca.andresmontoro.backoffice.localidades.ciudades.infrastructure.CiudadResponse;

public class CiudadMapper {
  
  public static CiudadRequest toRequest(CiudadResponse ciudadResponse) {
    return CiudadRequest.builder()
      .nombre(ciudadResponse.getNombre())
      .provinciaId(ciudadResponse.getProvinciaId())
      .build();
  }
}
