package es.ca.andresmontoro.information.hermandades.infrastructure.controller;

import es.ca.andresmontoro.information.hermandades.domain.Hermandad;

public class HermandadMapper {
  public static HermandadResponse toResponse(Hermandad hermandad) {
    return HermandadResponse.builder()
      .id(hermandad.getId())
      .apodo(hermandad.getApodo())
      .nombre(hermandad.getNombre())
      .historia(hermandad.getHistoria())
      .numeroHermanos(hermandad.getNumeroHermanos())
      .fundacion(hermandad.getFundacion())
      .build();
  }

  public static Hermandad toHermandad(HermandadRequest request) {
    return Hermandad.builder()
      .apodo(request.getApodo())
      .nombre(request.getNombre())
      .historia(request.getHistoria())
      .numeroHermanos(request.getNumeroHermanos())
      .fundacion(request.getFundacion())
      .build();
  }
}
