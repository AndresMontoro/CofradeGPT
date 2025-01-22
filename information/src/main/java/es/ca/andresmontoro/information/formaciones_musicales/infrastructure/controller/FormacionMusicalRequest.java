package es.ca.andresmontoro.information.formaciones_musicales.infrastructure.controller;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import es.ca.andresmontoro.information.formaciones_musicales.domain.EstiloFormacion;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
public class FormacionMusicalRequest {
  
  @NotNull(message = "El nombre no puede ser nulo")
  @NotEmpty(message = "El nombre no puede estar vacío")
  @NotBlank(message = "El nombre no puede estar en blanco")
  @Size(max = 1024, message = "El nombre no puede tener más de 1024 caracteres")
  private String nombre;

  @NotNull(message = "La fecha de fundación no puede ser nula")
  @PastOrPresent(message = "La fecha de fundación no puede ser futura")
  private LocalDate fechaFundacion;

  @NotNull(message = "El estilo no puede ser nulo")
  private EstiloFormacion estilo;
  
  @NotNull(message = "La ciudad no puede ser nula")
  @Range(min = 1, message = "El id de la ciudad no puede ser menor que 1")
  private Long idCiudad;
}
