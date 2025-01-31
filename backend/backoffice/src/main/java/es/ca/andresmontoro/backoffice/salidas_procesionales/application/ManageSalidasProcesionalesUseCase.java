package es.ca.andresmontoro.backoffice.salidas_procesionales.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure.FormacionMusicalResponse;
import es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure.SalidaProcesionalApiCalls;
import es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure.SalidaProcesionalResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageSalidasProcesionalesUseCase {

  private final SalidaProcesionalApiCalls salidaProcesionalApiCalls;

  public SalidaProcesionalResponse create(SalidaProcesionalResponse dto) {
    SalidaProcesionalResponse createdSalidaProcesional = salidaProcesionalApiCalls
      .create(SalidaProcesionalMapper.toRequest(dto));
    return createdSalidaProcesional;
  }

  public List<SalidaProcesionalResponse> findAll() {
    return salidaProcesionalApiCalls.findAll();
  }

  public SalidaProcesionalResponse update(SalidaProcesionalResponse dto) {
    SalidaProcesionalResponse updatedSalidaProcesional = salidaProcesionalApiCalls
      .update(dto.getId(), SalidaProcesionalMapper.toRequest(dto));
    return updatedSalidaProcesional;
  }

  public SalidaProcesionalResponse delete(SalidaProcesionalResponse dto) {
    return salidaProcesionalApiCalls.deleteById(dto.getId());
  }

  public List<FormacionMusicalResponse> findFormacionesByIdSalida(Long idSalida) {
    return salidaProcesionalApiCalls.findFormacionesByIdSalida(idSalida);
  }
}
