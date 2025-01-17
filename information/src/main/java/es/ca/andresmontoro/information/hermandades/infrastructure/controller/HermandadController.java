package es.ca.andresmontoro.information.hermandades.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ca.andresmontoro.information.hermandades.application.ManageHermandadesUseCase;
import es.ca.andresmontoro.information.shared.infrastructure.CrudController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/chatcofrade/informacion/hermandad")
@AllArgsConstructor
public class HermandadController implements CrudController<HermandadResponse, HermandadRequest>{

  private final ManageHermandadesUseCase manageHermandadesUseCase;

  @Override
  public HermandadResponse create(@Valid HermandadRequest dto) {
    return HermandadMapper.toResponse(
      manageHermandadesUseCase.create(HermandadMapper.toHermandad(dto))
    );
  }

  @Override
  public List<HermandadResponse> findAll() {
    return manageHermandadesUseCase.findAll().stream()
      .map(HermandadMapper::toResponse)
      .toList();
  }

  @Override
  public HermandadResponse findById(Long id) {
    return HermandadMapper.toResponse(manageHermandadesUseCase.findById(id));
  }

  @Override
  public HermandadResponse update(Long id, @Valid HermandadRequest dto) {
    return HermandadMapper.toResponse(
      manageHermandadesUseCase.update(id, HermandadMapper.toHermandad(dto))
    );
  }

  @Override
  public HermandadResponse deleteById(Long id) {
    return HermandadMapper.toResponse(manageHermandadesUseCase.delete(id));
  }
  
}
