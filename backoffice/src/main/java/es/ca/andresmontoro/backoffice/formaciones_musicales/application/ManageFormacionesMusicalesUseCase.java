package es.ca.andresmontoro.backoffice.formaciones_musicales.application;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure.FormacionMusicalApiCalls;
import es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure.FormacionMusicalResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageFormacionesMusicalesUseCase {

  private final FormacionMusicalApiCalls formacionesMusicalesApiCalls;

  public FormacionMusicalResponse create(FormacionMusicalResponse dto) {
    FormacionMusicalResponse createdFormacionMusical = formacionesMusicalesApiCalls
      .create(FormacionMusicalMapper.toRequest(dto));
    return createdFormacionMusical;
  }

  public List<FormacionMusicalResponse> findAll() {
    return formacionesMusicalesApiCalls.findAll();
  }

  public FormacionMusicalResponse update(FormacionMusicalResponse dto) {
    FormacionMusicalResponse updatedFormacionMusical = formacionesMusicalesApiCalls
      .update(dto.getId(), FormacionMusicalMapper.toRequest(dto));
    return updatedFormacionMusical;
  }

  public FormacionMusicalResponse delete(FormacionMusicalResponse dto) {
    return formacionesMusicalesApiCalls.deleteById(dto.getId());
  }
}
