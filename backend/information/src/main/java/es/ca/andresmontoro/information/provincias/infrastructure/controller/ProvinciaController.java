package es.ca.andresmontoro.information.provincias.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ca.andresmontoro.information.comunidades.application.ManageComunidadesAutonomasUseCase;
import es.ca.andresmontoro.information.comunidades.domain.ComunidadAutonoma;
import es.ca.andresmontoro.information.provincias.application.ManageProvinciasUseCase;
import es.ca.andresmontoro.information.shared.infrastructure.CrudController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/chatcofrade/informacion/provincia")
@AllArgsConstructor
public class ProvinciaController implements CrudController<ProvinciaResponse, ProvinciaRequest>{
  
  private final ManageProvinciasUseCase manageProvinciasUseCase;
  private final ManageComunidadesAutonomasUseCase manageComunidadesUseCase;

  @Override
  public ProvinciaResponse create(@Valid ProvinciaRequest dto) {
    ComunidadAutonoma comunidad = manageComunidadesUseCase.findById(dto.getComunidadAutonomaId());

    return ProvinciaMapper.toResponse(
      manageProvinciasUseCase.create(ProvinciaMapper.toProvincia(dto, comunidad))
    );
  }

  @Override
  public List<ProvinciaResponse> findAll() {
    return manageProvinciasUseCase.findAll().stream()
      .map(ProvinciaMapper::toResponse)
      .toList();
  }

  @Override
  public ProvinciaResponse findById(Long id) {
    return ProvinciaMapper.toResponse(manageProvinciasUseCase.findById(id));
  }

  @Override
  public ProvinciaResponse update(Long id, @Valid ProvinciaRequest dto) {
    ComunidadAutonoma comunidad = manageComunidadesUseCase.findById(dto.getComunidadAutonomaId());

    return ProvinciaMapper.toResponse(
      manageProvinciasUseCase.update(id, ProvinciaMapper.toProvincia(dto, comunidad))
    );
  }

  @Override
  public ProvinciaResponse deleteById(Long id) {
    return ProvinciaMapper.toResponse(manageProvinciasUseCase.delete(id));
  }
}
