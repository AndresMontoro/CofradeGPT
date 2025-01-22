package es.ca.andresmontoro.information.formaciones_musicales.infrastructure.controller;

import es.ca.andresmontoro.information.formaciones_musicales.domain.FormacionMusical;
import es.ca.andresmontoro.information.localidades.domain.Ciudad;

public class FormacionMusicalMapper {
  public static FormacionMusicalResponse toResponse(FormacionMusical formacionMusical) {
    return FormacionMusicalResponse.builder()
      .id(formacionMusical.getId())
      .nombre(formacionMusical.getNombre())
      .fechaFundacion(formacionMusical.getFechaFundacion())
      .estilo(formacionMusical.getEstilo())
      .idCiudad(formacionMusical.getCiudad().getId())
      .nombreCiudad(formacionMusical.getCiudad().getNombre())
      .build();
  }

  public static FormacionMusical toFormacionMusical(FormacionMusicalRequest request, Ciudad ciudad) {
    return FormacionMusical.builder()
      .nombre(request.getNombre())
      .fechaFundacion(request.getFechaFundacion())
      .estilo(request.getEstilo())
      .ciudad(ciudad)
      .build();
  }
}
