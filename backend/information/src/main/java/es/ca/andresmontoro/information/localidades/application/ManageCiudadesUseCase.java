package es.ca.andresmontoro.information.localidades.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.information.localidades.domain.Ciudad;
import es.ca.andresmontoro.information.localidades.infrastructure.CiudadRepository;
import es.ca.andresmontoro.information.shared.application.CrudService;
import es.ca.andresmontoro.information.shared.application.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageCiudadesUseCase implements CrudService<Ciudad>{
  
  private final CiudadRepository ciudadRepository;

  @Override
  public Ciudad create(Ciudad request) {
    Ciudad ciudad = ciudadRepository.save(request);
    return ciudad;
  }

  @Override
  public List<Ciudad> findAll() {
    return ciudadRepository.findAll();
  }

  @Override
  public Ciudad findById(Long id) {
    ValidationUtils.validateId(id);

    return ciudadRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Ciudad not found"));
  }

  @Override
  public Ciudad update(Long id, Ciudad request) {
    Ciudad ciudad = findById(id);

    if(request.equals(ciudad)) {
      return ciudad;
    }

    ciudad.setNombre(request.getNombre());
    ciudad.setProvincia(request.getProvincia());

    return ciudadRepository.save(ciudad);
  }

  @Override
  public Ciudad delete(Long id) {
    Ciudad ciudad = findById(id);
    ciudadRepository.delete(ciudad);
    return ciudad;
  }
}
