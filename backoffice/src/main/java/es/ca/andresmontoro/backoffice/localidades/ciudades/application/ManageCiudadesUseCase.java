package es.ca.andresmontoro.backoffice.localidades.ciudades.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.backoffice.localidades.ciudades.infrastructure.CiudadApiCalls;
import es.ca.andresmontoro.backoffice.localidades.ciudades.infrastructure.CiudadResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageCiudadesUseCase {
  
  private final CiudadApiCalls ciudadApiCalls;

  public CiudadResponse create(CiudadResponse dto) {
    CiudadResponse createdCiudad = ciudadApiCalls.create(CiudadMapper.toRequest(dto));
    return createdCiudad;
  }

  public List<CiudadResponse> findAll() {
    return ciudadApiCalls.findAll();
  }

  public CiudadResponse update(CiudadResponse dto) {
    CiudadResponse updatedCiudad = ciudadApiCalls
      .update(dto.getId(), CiudadMapper.toRequest(dto));
    return updatedCiudad;
  }

  public CiudadResponse delete(CiudadResponse dto) {
    return ciudadApiCalls.deleteById(dto.getId());
  }
}
