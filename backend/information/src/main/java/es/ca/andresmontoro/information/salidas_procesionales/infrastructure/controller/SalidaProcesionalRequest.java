package es.ca.andresmontoro.information.salidas_procesionales.infrastructure.controller;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Range;

import es.ca.andresmontoro.information.salidas_procesionales.domain.DiaSalida;
import jakarta.validation.constraints.NotNull;
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
public class SalidaProcesionalRequest {

  @NotNull
  private LocalDateTime fechaHoraSalida;

  @NotNull
  private LocalDateTime verdaderaFechaHoraSalida;

  @NotNull
  private LocalDateTime fechaHoraRecogida;

  @NotNull
  private LocalDateTime verdaderaFechaHoraRecogida;

  @NotNull
  private DiaSalida diaSalida;

  @NotNull
  @Range(min = 1, message = "El id de la hermandad no puede ser menor que 1")
  private Long idHermandad;

  @NotNull
  @Range(min = 0, message = "El número de nazarenos debe ser positivo")
  private Integer numeroNazarenos;

  @Builder.Default
  @NotNull
  private Set<Long> idFormacionesMusicales = new HashSet<>();
}
