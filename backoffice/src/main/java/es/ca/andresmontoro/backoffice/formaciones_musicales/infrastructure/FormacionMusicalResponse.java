package es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure;

import java.time.LocalDate;

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
public class FormacionMusicalResponse {
  
  private Long id;

  private String nombre;

  private LocalDate fechaFundacion;

  private EstiloFormacion estilo;

  private Long idCiudad;
}
