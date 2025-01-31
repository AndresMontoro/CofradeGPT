package es.ca.andresmontoro.information.salidas_procesionales.application;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.information.formaciones_musicales.domain.FormacionMusical;
import es.ca.andresmontoro.information.salidas_procesionales.domain.SalidaProcesional;
import es.ca.andresmontoro.information.salidas_procesionales.infrastructure.SalidaProcesionalRepository;
import es.ca.andresmontoro.information.shared.application.CrudService;
import es.ca.andresmontoro.information.shared.application.ValidationUtils;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageSalidasProcesionalesUseCase implements CrudService<SalidaProcesional> {
  
  private final SalidaProcesionalRepository repository;

  @Override
  public SalidaProcesional create(SalidaProcesional request) {
    SalidaProcesional salidaProcesional = repository.save(request);
    return salidaProcesional;
  }

  @Override
  public List<SalidaProcesional> findAll() {
    return repository.findAll();
  }

  @Override
  public SalidaProcesional findById(Long id) {
    ValidationUtils.validateId(id);

    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("SalidaProcesional not found"));
  }

  @Override
  public SalidaProcesional update(Long id, SalidaProcesional request) {
    SalidaProcesional salidaProcesional = findById(id);

    if(request.equals(salidaProcesional)) {
      return salidaProcesional;
    }

    salidaProcesional.setFechaHoraSalida(request.getFechaHoraSalida());
    salidaProcesional.setVerdaderaFechaHoraSalida(request
      .getVerdaderaFechaHoraSalida());
    salidaProcesional.setFechaHoraRecogida(request.getFechaHoraRecogida());
    salidaProcesional.setVerdaderaFechaHoraRecogida(request
      .getVerdaderaFechaHoraRecogida());
    salidaProcesional.setDiaSalida(request.getDiaSalida());
    salidaProcesional.setHermandad(request.getHermandad());
    salidaProcesional.setNumeroNazarenos(request.getNumeroNazarenos());
    salidaProcesional.setFormacionesMusicales(request.getFormacionesMusicales());

    return repository.save(salidaProcesional);
  }

  @Override
  public SalidaProcesional delete(Long id) {
    SalidaProcesional salidaProcesional = findById(id);
    repository.delete(salidaProcesional);
    return salidaProcesional;
  }

  public Set<FormacionMusical> findFormacionesByIdSalida(Long idSalida) {
    SalidaProcesional salidaProcesional = findById(idSalida);
    return salidaProcesional.getFormacionesMusicales();
  }
}
