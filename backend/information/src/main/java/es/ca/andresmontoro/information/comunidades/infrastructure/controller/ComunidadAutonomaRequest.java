package es.ca.andresmontoro.information.comunidades.infrastructure.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ComunidadAutonomaRequest {
  
  @NotNull
  @NotEmpty
  @NotBlank
  @Size(min = 1, max = 128)
  private String nombre;
}
