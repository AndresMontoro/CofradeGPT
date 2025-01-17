package es.ca.andresmontoro.information.comunidades.infrastructure.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ca.andresmontoro.information.comunidades.application.ManageComunidadesAutonomasUseCase;
import es.ca.andresmontoro.information.shared.infrastructure.CrudController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/chatcofrade/informacion/comunidad")
@AllArgsConstructor
public class ComunidadAutonomaController implements CrudController<ComunidadAutonomaResponse, ComunidadAutonomaRequest>{

  private final ManageComunidadesAutonomasUseCase manageComunidadesUseCase;

  @Override
  public ComunidadAutonomaResponse create(@Valid ComunidadAutonomaRequest dto) {
    return ComunidadAutonomaMapper.toResponse(
      manageComunidadesUseCase.create(ComunidadAutonomaMapper.toComunidadAutonoma(dto))
    );
  }

  @Override
  public List<ComunidadAutonomaResponse> findAll() {
    return manageComunidadesUseCase.findAll().stream()
      .map(ComunidadAutonomaMapper::toResponse)
      .toList();
  }

  @Override
  public ComunidadAutonomaResponse findById(Long id) {
    return ComunidadAutonomaMapper.toResponse(manageComunidadesUseCase.findById(id));
  }

  @Override
  public ComunidadAutonomaResponse update(Long id, @Valid ComunidadAutonomaRequest dto) {
    return ComunidadAutonomaMapper.toResponse(
      manageComunidadesUseCase.update(id, ComunidadAutonomaMapper.toComunidadAutonoma(dto))
    );
  }

  @Override
  public ComunidadAutonomaResponse deleteById(Long id) {
    return ComunidadAutonomaMapper.toResponse(manageComunidadesUseCase.delete(id));
  }
}