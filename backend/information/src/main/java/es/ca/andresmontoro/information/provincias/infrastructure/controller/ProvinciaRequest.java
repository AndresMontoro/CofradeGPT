package es.ca.andresmontoro.information.provincias.infrastructure.controller;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProvinciaRequest {
  
  @NotNull(message = "El nombre no puede ser nulo")
  @NotEmpty(message = "El nombre no puede estar vacío")
  @NotBlank(message = "El nombre no puede estar en blanco")
  @Size(max = 512, message = "El nombre no puede tener más de 1024 caracteres")
  private String nombre;

  @NotNull(message = "La comunidad autonoma no puede ser nula")
  @Range(min = 1, message = "El id de la comunidad autonoma no puede ser menor que 1")
  private Long comunidadAutonomaId;
}
