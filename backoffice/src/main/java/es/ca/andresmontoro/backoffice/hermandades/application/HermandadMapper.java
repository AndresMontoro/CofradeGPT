package es.ca.andresmontoro.backoffice.hermandades.application;

import es.ca.andresmontoro.backoffice.hermandades.infrastructure.HermandadRequest;
import es.ca.andresmontoro.backoffice.hermandades.infrastructure.HermandadResponse;

public class HermandadMapper {

  public static HermandadRequest toRequest(HermandadResponse request) {
    return HermandadRequest.builder()
      .apodo(request.getApodo())
      .nombre(request.getNombre())
      .historia(request.getHistoria())
      .numeroHermanos(request.getNumeroHermanos())
      .fundacion(request.getFundacion())
      .build();
  }
}

