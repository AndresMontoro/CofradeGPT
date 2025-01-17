package es.ca.andresmontoro.information.hermandades.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.information.hermandades.domain.Hermandad;
import es.ca.andresmontoro.information.hermandades.infrastructure.HermandadRepository;
import es.ca.andresmontoro.information.shared.application.CrudService;
import es.ca.andresmontoro.information.shared.application.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageHermandadesUseCase implements CrudService<Hermandad>{

  private final HermandadRepository hermandadRepository;

  @Override
  public Hermandad create(Hermandad request) {
    Hermandad hermandad = hermandadRepository.save(request);
    return hermandad;
  }

  @Override
  public List<Hermandad> findAll() {
    return hermandadRepository.findAll();
  }

  @Override
  public Hermandad findById(Long id) {
    ValidationUtils.validateId(id);

    return hermandadRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Hermandad not found"));
  }

  @Override
  public Hermandad update(Long id, Hermandad request) {
    Hermandad hermandad = findById(id);

    if(request.equals(hermandad)) {
      return hermandad;
    }

    hermandad.setApodo(request.getApodo());
    hermandad.setNombre(request.getNombre());
    hermandad.setHistoria(request.getHistoria());
    hermandad.setNumeroHermanos(request.getNumeroHermanos());
    hermandad.setFundacion(request.getFundacion());

    return hermandadRepository.save(hermandad);
  }

  @Override
  public Hermandad delete(Long id) {
    Hermandad hermandad = findById(id);
    hermandadRepository.delete(hermandad);
    return hermandad;
  }
}
