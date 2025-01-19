package es.ca.andresmontoro.backoffice.hermandades.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.backoffice.hermandades.infrastructure.HermandadResponse;
import es.ca.andresmontoro.backoffice.hermandades.infrastructure.HermandadesApiCalls;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageHermandadesUseCase {
  
  private final HermandadesApiCalls hermandadesApiCalls;

  public HermandadResponse create(HermandadResponse dto) {
    HermandadResponse createdHermandad = hermandadesApiCalls.create(HermandadMapper.toRequest(dto));
    return createdHermandad;
  }

  public List<HermandadResponse> findAll() {
    return hermandadesApiCalls.findAll();
  }

  public HermandadResponse update(HermandadResponse dto) {
    HermandadResponse updatedHermandad = hermandadesApiCalls
      .update(dto.getId(), HermandadMapper.toRequest(dto));
    return updatedHermandad;
  }

  public HermandadResponse delete(HermandadResponse dto) {
    return hermandadesApiCalls.deleteById(dto.getId());
  }
}
