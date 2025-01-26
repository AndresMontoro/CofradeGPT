package es.ca.andresmontoro.backoffice.localidades.provincias.application;

import java.util.List;

import org.springframework.stereotype.Service;
import es.ca.andresmontoro.backoffice.localidades.provincias.infrastructure.ProvinciaApiCalls;
import es.ca.andresmontoro.backoffice.localidades.provincias.infrastructure.ProvinciaResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageProvinciasUseCase {
  
  private final ProvinciaApiCalls provinciaApiCalls;

  public ProvinciaResponse create(ProvinciaResponse dto) {
    ProvinciaResponse createdProvincia = provinciaApiCalls.create(ProvinciaMapper.toRequest(dto));
    return createdProvincia;
  }

  public List<ProvinciaResponse> findAll() {
    return provinciaApiCalls.findAll();
  }

  public ProvinciaResponse update(ProvinciaResponse dto) {
    ProvinciaResponse updatedProvincia = provinciaApiCalls
      .update(dto.getId(), ProvinciaMapper.toRequest(dto));
    return updatedProvincia;
  }

  public ProvinciaResponse delete(ProvinciaResponse dto) {
    return provinciaApiCalls.deleteById(dto.getId());
  }
}
