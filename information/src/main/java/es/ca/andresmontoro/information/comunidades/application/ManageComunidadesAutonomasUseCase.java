package es.ca.andresmontoro.information.comunidades.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.information.comunidades.domain.ComunidadAutonoma;
import es.ca.andresmontoro.information.comunidades.infrastructure.ComunidadAutonomaRepository;
import es.ca.andresmontoro.information.shared.application.CrudService;
import es.ca.andresmontoro.information.shared.application.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageComunidadesAutonomasUseCase implements CrudService<ComunidadAutonoma> {
  
  private final ComunidadAutonomaRepository repository;

  @Override
  public ComunidadAutonoma create(ComunidadAutonoma request) {
    ComunidadAutonoma comunidadAutonoma = repository.save(request);
    return comunidadAutonoma;
  }

  @Override
  public List<ComunidadAutonoma> findAll() {
    return repository.findAll();
  }

  @Override
  public ComunidadAutonoma findById(Long id) {
    ValidationUtils.validateId(id);

    return repository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Comunidad Autonoma not found"));
  }

  @Override
  public ComunidadAutonoma update(Long id, ComunidadAutonoma request) {
    ComunidadAutonoma comunidadAutonoma = findById(id);

    if(request.equals(comunidadAutonoma)) {
      return comunidadAutonoma;
    }

    comunidadAutonoma.setNombre(request.getNombre());
    comunidadAutonoma.setProvincias(request.getProvincias());

    return repository.save(comunidadAutonoma);
  }

  @Override
  public ComunidadAutonoma delete(Long id) {
    ComunidadAutonoma comunidadAutonoma = findById(id);
    repository.delete(comunidadAutonoma);
    return comunidadAutonoma;
  }
}
