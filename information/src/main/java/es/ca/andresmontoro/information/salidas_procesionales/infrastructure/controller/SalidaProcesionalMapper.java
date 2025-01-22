package es.ca.andresmontoro.information.salidas_procesionales.infrastructure.controller;

import java.util.List;
import java.util.stream.Collectors;

import es.ca.andresmontoro.information.formaciones_musicales.domain.FormacionMusical;
import es.ca.andresmontoro.information.hermandades.domain.Hermandad;
import es.ca.andresmontoro.information.salidas_procesionales.domain.SalidaProcesional;

public class SalidaProcesionalMapper {
  public static SalidaProcesionalResponse toResponse(
  SalidaProcesional salidaProcesional) {

    return SalidaProcesionalResponse.builder()
      .id(salidaProcesional.getId())
      .fechaHoraSalida(salidaProcesional.getFechaHoraSalida())
      .verdaderaFechaHoraSalida(salidaProcesional.getVerdaderaFechaHoraSalida())
      .fechaHoraRecogida(salidaProcesional.getFechaHoraRecogida())
      .verdaderaFechaHoraRecogida(salidaProcesional.getVerdaderaFechaHoraRecogida())
      .diaSalida(salidaProcesional.getDiaSalida())
      .idHermandad(salidaProcesional.getHermandad().getId())
      .nombreHermandad(salidaProcesional.getHermandad().getNombre())
      .numeroNazarenos(salidaProcesional.getNumeroNazarenos())
      .idFormacionesMusicales(salidaProcesional.getFormacionesMusicales()
        .stream().map(FormacionMusical::getId).collect(Collectors.toList())
      )
      .build();
  }

  public static SalidaProcesional toSalidaProcesional(
  SalidaProcesionalRequest request, Hermandad hermandad, 
  List<FormacionMusical> formacionesMusicales) {

    return SalidaProcesional.builder()
      .fechaHoraSalida(request.getFechaHoraSalida())
      .verdaderaFechaHoraSalida(request.getVerdaderaFechaHoraSalida())
      .fechaHoraRecogida(request.getFechaHoraRecogida())
      .verdaderaFechaHoraRecogida(request.getVerdaderaFechaHoraRecogida())
      .diaSalida(request.getDiaSalida())
      .hermandad(hermandad)
      .numeroNazarenos(request.getNumeroNazarenos())
      .formacionesMusicales(formacionesMusicales)
      .build();
  }
}
