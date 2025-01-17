package es.ca.andresmontoro.information.formaciones_musicales.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.information.formaciones_musicales.domain.EstiloFormacion;
import es.ca.andresmontoro.information.formaciones_musicales.infrastructure.EstiloFormacionRepository;
import es.ca.andresmontoro.information.shared.application.CrudService;
import es.ca.andresmontoro.information.shared.application.ValidationUtils;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageEstiloFormacionUseCase implements CrudService<EstiloFormacion>{

  private final EstiloFormacionRepository repository;

  @Override
  public EstiloFormacion create(EstiloFormacion request) {
    EstiloFormacion estiloFormacion = repository.save(request);
    return estiloFormacion;
  }

  @Override
  public List<EstiloFormacion> findAll() {
    return repository.findAll();
  }

  @Override
  public EstiloFormacion findById(Long id) {
    ValidationUtils.validateId(id);

    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("EstiloFormacion not found"));
  }

  @Override
  public EstiloFormacion update(Long id, EstiloFormacion request) {
    EstiloFormacion estiloFormacion = findById(id);

    if(request.equals(estiloFormacion)) {
      return estiloFormacion;
    }

    estiloFormacion.setNombre(request.getNombre());

    return repository.save(estiloFormacion);
  }

  @Override
  public EstiloFormacion delete(Long id) {
    EstiloFormacion estiloFormacion = findById(id);
    repository.delete(estiloFormacion);
    return estiloFormacion;
  }
  
}
