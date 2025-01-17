package es.ca.andresmontoro.information.formaciones_musicales.infrastructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ca.andresmontoro.information.formaciones_musicales.application.ManageFormacionesMusicalesUseCase;
import es.ca.andresmontoro.information.localidades.application.ManageCiudadesUseCase;
import es.ca.andresmontoro.information.localidades.domain.Ciudad;
import es.ca.andresmontoro.information.shared.infrastructure.CrudController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/chatcofrade/informacion/formacion-musical")
@AllArgsConstructor
public class FormacionMusicalController implements CrudController<FormacionMusicalResponse, FormacionMusicalRequest>{
  
  private final ManageFormacionesMusicalesUseCase manageFormacionesMusicalesUseCase;
  private final ManageCiudadesUseCase manageCiudadesUseCase;

  @Override
  public FormacionMusicalResponse create(@Valid FormacionMusicalRequest dto) {
    Ciudad ciudad = manageCiudadesUseCase.findById(dto.getIdCiudad());
    return FormacionMusicalMapper.toResponse(
      manageFormacionesMusicalesUseCase.create(FormacionMusicalMapper.toFormacionMusical(dto, ciudad))
    );
  }

  @Override
  public List<FormacionMusicalResponse> findAll() {
    return manageFormacionesMusicalesUseCase.findAll().stream()
      .map(FormacionMusicalMapper::toResponse)
      .toList();
  }

  @Override
  public FormacionMusicalResponse findById(Long id) {
    return FormacionMusicalMapper.toResponse(manageFormacionesMusicalesUseCase.findById(id));
  }

  @Override
  public FormacionMusicalResponse update(Long id, @Valid FormacionMusicalRequest dto) {
    Ciudad ciudad = manageCiudadesUseCase.findById(dto.getIdCiudad());
    return FormacionMusicalMapper.toResponse(
      manageFormacionesMusicalesUseCase.update(id, FormacionMusicalMapper.toFormacionMusical(dto, ciudad))
    );
  }

  @Override
  public FormacionMusicalResponse deleteById(Long id) {
    return FormacionMusicalMapper.toResponse(manageFormacionesMusicalesUseCase.delete(id));
  }
}
