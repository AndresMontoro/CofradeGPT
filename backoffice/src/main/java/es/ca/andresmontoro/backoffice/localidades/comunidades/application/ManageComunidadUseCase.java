package es.ca.andresmontoro.backoffice.localidades.comunidades.application;

import java.util.List;

import org.springframework.stereotype.Service;


import es.ca.andresmontoro.backoffice.localidades.comunidades.infrastructure.ComunidadAutonomaApiCalls;
import es.ca.andresmontoro.backoffice.localidades.comunidades.infrastructure.ComunidadAutonomaResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageComunidadUseCase {

  private final ComunidadAutonomaApiCalls comunidadAutonomaApiCalls;

  public ComunidadAutonomaResponse create(ComunidadAutonomaResponse dto) {
    ComunidadAutonomaResponse createdComunidadAutonoma = comunidadAutonomaApiCalls.create(ComunidadAutonomaMapper.toRequest(dto));
    return createdComunidadAutonoma;
  }

  public List<ComunidadAutonomaResponse> findAll() {
    return comunidadAutonomaApiCalls.findAll();
  }

  public ComunidadAutonomaResponse update(ComunidadAutonomaResponse dto) {
    ComunidadAutonomaResponse updatedComunidadAutonoma = comunidadAutonomaApiCalls
      .update(dto.getId(), ComunidadAutonomaMapper.toRequest(dto));
    return updatedComunidadAutonoma;
  }

  public ComunidadAutonomaResponse delete(ComunidadAutonomaResponse dto) {
    return comunidadAutonomaApiCalls.deleteById(dto.getId());
  }
}
