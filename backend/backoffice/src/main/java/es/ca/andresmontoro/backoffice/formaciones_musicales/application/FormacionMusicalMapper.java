package es.ca.andresmontoro.backoffice.formaciones_musicales.application;

import es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure.FormacionMusicalRequest;
import es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure.FormacionMusicalResponse;

public class FormacionMusicalMapper {
  
  public static FormacionMusicalRequest toRequest(FormacionMusicalResponse request) {
    return FormacionMusicalRequest.builder()
      .nombre(request.getNombre())
      .fechaFundacion(request.getFechaFundacion())
      .estilo(request.getEstilo())
      .idCiudad(request.getIdCiudad())
      .build();
  }
}
