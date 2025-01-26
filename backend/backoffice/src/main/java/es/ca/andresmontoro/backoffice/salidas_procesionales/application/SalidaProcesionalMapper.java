package es.ca.andresmontoro.backoffice.salidas_procesionales.application;

import es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure.SalidaProcesionalRequest;
import es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure.SalidaProcesionalResponse;

public class SalidaProcesionalMapper {
  
  public static SalidaProcesionalRequest toRequest(
  SalidaProcesionalResponse salidaProcesionalResponse) {
    return SalidaProcesionalRequest.builder()
      .fechaHoraSalida(salidaProcesionalResponse.getFechaHoraSalida())
      .verdaderaFechaHoraSalida(salidaProcesionalResponse.getVerdaderaFechaHoraSalida())
      .fechaHoraRecogida(salidaProcesionalResponse.getFechaHoraRecogida())
      .verdaderaFechaHoraRecogida(salidaProcesionalResponse.getVerdaderaFechaHoraRecogida())
      .diaSalida(salidaProcesionalResponse.getDiaSalida())
      .idHermandad(salidaProcesionalResponse.getIdHermandad())
      .numeroNazarenos(salidaProcesionalResponse.getNumeroNazarenos())
      .idFormacionesMusicales(salidaProcesionalResponse.getIdFormacionesMusicales())
      .build();
  }
}
