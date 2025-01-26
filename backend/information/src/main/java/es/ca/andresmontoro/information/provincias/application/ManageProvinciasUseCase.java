package es.ca.andresmontoro.information.provincias.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.information.provincias.domain.Provincia;
import es.ca.andresmontoro.information.provincias.infrastructure.ProvinciaRepository;
import es.ca.andresmontoro.information.shared.application.CrudService;
import es.ca.andresmontoro.information.shared.application.ValidationUtils;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageProvinciasUseCase implements CrudService<Provincia>{
  
  private final ProvinciaRepository provinciaRepository;

  @Override
  public Provincia create(Provincia request) {
    Provincia Provincia = provinciaRepository.save(request);
    return Provincia;
  }

  @Override
  public List<Provincia> findAll() {
    return provinciaRepository.findAll();
  }

  @Override
  public Provincia findById(Long id) {
    ValidationUtils.validateId(id);

    return provinciaRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Provincia not found"));
  }

  @Override
  public Provincia update(Long id, Provincia request) {
    Provincia provincia = findById(id);

    if(request.equals(provincia)) {
      return provincia;
    }

    provincia.setNombre(request.getNombre());
    provincia.setComunidadAutonoma(request.getComunidadAutonoma());

    return provinciaRepository.save(provincia);
  }

  @Override
  public Provincia delete(Long id) {
    Provincia provincia = findById(id);
    provinciaRepository.delete(provincia);
    return provincia;
  }
}
