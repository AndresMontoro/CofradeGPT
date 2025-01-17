package es.ca.andresmontoro.information.formaciones_musicales.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.information.formaciones_musicales.domain.FormacionMusical;
import es.ca.andresmontoro.information.formaciones_musicales.infrastructure.FormacionMusicalRepository;
import es.ca.andresmontoro.information.shared.application.CrudService;
import es.ca.andresmontoro.information.shared.application.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageFormacionesMusicalesUseCase implements CrudService<FormacionMusical>{

  private final FormacionMusicalRepository repository;

  @Override
  public FormacionMusical create(FormacionMusical request) {
    FormacionMusical formacionMusical = repository.save(request);
    return formacionMusical;
  }

  @Override
  public List<FormacionMusical> findAll() {
    return repository.findAll();
  }

  @Override
  public FormacionMusical findById(Long id) {
    ValidationUtils.validateId(id);

    return repository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("FormacionMusical not found"));
  }

  @Override
  public FormacionMusical update(Long id, FormacionMusical request) {
    FormacionMusical formacionMusical = findById(id);

    if(request.equals(formacionMusical)) {
      return formacionMusical;
    }

    formacionMusical.setNombre(request.getNombre());
    formacionMusical.setEstilo(request.getEstilo());
    formacionMusical.setFechaFundacion(request.getFechaFundacion());
    formacionMusical.setCiudad(request.getCiudad());

    return repository.save(formacionMusical);
  }

  @Override
  public FormacionMusical delete(Long id) {
    FormacionMusical formacionMusical = findById(id);
    repository.delete(formacionMusical);
    return formacionMusical;
  }
}
