package es.ca.andresmontoro.information.localidades.infrastructure.controller;

import org.hibernate.validator.constraints.Range;

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
public class CiudadRequest {
  
  @NotNull(message = "El nombre no puede ser nulo")
  @NotEmpty(message = "El nombre no puede estar vacío")
  @NotBlank(message = "El nombre no puede estar en blanco")
  @Size(max = 512, message = "El nombre no puede tener más de 1024 caracteres")
  private String nombre;

  @NotNull(message = "La provincia no puede ser nula")
  @Range(min = 1, message = "La provincia no puede ser menor que 1")
  private Long provinciaId;  // Añadir relacion
}
