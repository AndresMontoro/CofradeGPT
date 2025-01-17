package es.ca.andresmontoro.information.localidades.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ca.andresmontoro.information.localidades.application.ManageCiudadesUseCase;
import es.ca.andresmontoro.information.provincias.application.ManageProvinciasUseCase;
import es.ca.andresmontoro.information.provincias.domain.Provincia;
import es.ca.andresmontoro.information.shared.infrastructure.CrudController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/chatcofrade/informacion/ciudad")
@AllArgsConstructor
public class CiudadController implements CrudController<CiudadResponse, CiudadRequest>{
  
  private final ManageCiudadesUseCase manageCiudadesUseCase;
  private final ManageProvinciasUseCase manageProvinciasUseCase;

  @Override
  public CiudadResponse create(@Valid CiudadRequest dto) {
    Provincia provincia = manageProvinciasUseCase.findById(dto.getProvinciaId());
    return CiudadMapper.toResponse(
      manageCiudadesUseCase.create(CiudadMapper.toCiudad(dto, provincia))
    );
  }

  @Override
  public List<CiudadResponse> findAll() {
    return manageCiudadesUseCase.findAll().stream()
      .map(CiudadMapper::toResponse)
      .toList();
  }

  @Override
  public CiudadResponse findById(Long id) {
    return CiudadMapper.toResponse(manageCiudadesUseCase.findById(id));
  }

  @Override
  public CiudadResponse update(Long id, @Valid CiudadRequest dto) {
    Provincia provincia = manageProvinciasUseCase.findById(dto.getProvinciaId());
    return CiudadMapper.toResponse(
      manageCiudadesUseCase.update(id, CiudadMapper.toCiudad(dto, provincia))
    );
  }

  @Override
  public CiudadResponse deleteById(Long id) {
    return CiudadMapper.toResponse(manageCiudadesUseCase.delete(id));
  } 
}
