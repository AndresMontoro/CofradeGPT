package es.ca.andresmontoro.information.salidas_procesionales.infrastructure.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ca.andresmontoro.information.formaciones_musicales.application.ManageFormacionesMusicalesUseCase;
import es.ca.andresmontoro.information.formaciones_musicales.domain.FormacionMusical;
import es.ca.andresmontoro.information.formaciones_musicales.infrastructure.controller.FormacionMusicalMapper;
import es.ca.andresmontoro.information.formaciones_musicales.infrastructure.controller.FormacionMusicalResponse;
import es.ca.andresmontoro.information.hermandades.application.ManageHermandadesUseCase;
import es.ca.andresmontoro.information.hermandades.domain.Hermandad;
import es.ca.andresmontoro.information.salidas_procesionales.application.ManageSalidasProcesionalesUseCase;
import es.ca.andresmontoro.information.shared.infrastructure.CrudController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/chatcofrade/informacion/salidaProcesional")
@AllArgsConstructor
public class SalidaProcesionalController implements CrudController<SalidaProcesionalResponse, SalidaProcesionalRequest>{

  private final ManageSalidasProcesionalesUseCase manageSalidasProcesionales;
  private final ManageHermandadesUseCase manageHermandadesUseCase;
  private final ManageFormacionesMusicalesUseCase manageFormacionesMusicalesUseCase;


  @Override
  public SalidaProcesionalResponse create(@Valid SalidaProcesionalRequest dto) {
    Hermandad hermandad = manageHermandadesUseCase.findById(dto.getIdHermandad());
    List<FormacionMusical> formacionesMusicales = manageFormacionesMusicalesUseCase
      .findByIds(dto.getIdFormacionesMusicales().stream().toList());
    
    return SalidaProcesionalMapper.toResponse(
      manageSalidasProcesionales.create(
        SalidaProcesionalMapper.toSalidaProcesional(dto, hermandad, formacionesMusicales)
      )
    ); 
  }

  @Override
  public List<SalidaProcesionalResponse> findAll() {
    return manageSalidasProcesionales.findAll().stream()
      .map(SalidaProcesionalMapper::toResponse)
      .toList();
  }

  @Override
  public SalidaProcesionalResponse findById(Long id) {
    return SalidaProcesionalMapper.toResponse(manageSalidasProcesionales
      .findById(id));
  }

  @Override
  public SalidaProcesionalResponse update(Long id, @Valid SalidaProcesionalRequest dto) {
    Hermandad hermandad = manageHermandadesUseCase.findById(dto.getIdHermandad());
    List<FormacionMusical> formacionesMusicales = manageFormacionesMusicalesUseCase
      .findByIds(dto.getIdFormacionesMusicales().stream().toList());

    return SalidaProcesionalMapper.toResponse(
      manageSalidasProcesionales.update(
        id,
        SalidaProcesionalMapper.toSalidaProcesional(dto, hermandad, formacionesMusicales)
      )
    ); 
  }

  @Override
  public SalidaProcesionalResponse deleteById(Long id) {
    return SalidaProcesionalMapper.toResponse(manageSalidasProcesionales.delete(id));
  }

  @GetMapping("/getFormacionesByIdSalida/{idSalida}")
  public List<FormacionMusicalResponse> findFormacionesMusicalesByIdSalida(@PathVariable Long idSalida) {
    return manageSalidasProcesionales.findFormacionesByIdSalida(idSalida).stream()
      .map(FormacionMusicalMapper::toResponse)
      .toList();
  }
}
