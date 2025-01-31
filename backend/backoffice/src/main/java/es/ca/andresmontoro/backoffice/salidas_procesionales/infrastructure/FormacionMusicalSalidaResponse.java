package es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class FormacionMusicalSalidaResponse {
  
  private Long id;

  private String nombre;
}
