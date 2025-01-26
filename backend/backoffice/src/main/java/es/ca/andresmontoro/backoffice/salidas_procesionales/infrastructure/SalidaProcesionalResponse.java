package es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class SalidaProcesionalResponse {
  
  private Long id;

  @NotNull(message = "La fecha no puede ser nula")
  private LocalDateTime fechaHoraSalida;
  
  private LocalDateTime verdaderaFechaHoraSalida;

  @NotNull(message = "La hora de recogida no puede ser nula")
  private LocalDateTime fechaHoraRecogida;

  private LocalDateTime verdaderaFechaHoraRecogida;

  @NotNull(message = "El día de salida no puede ser nulo")
  private DiaSalida diaSalida;

  @NotNull(message = "La hermandad no puede ser nula")
  private Long idHermandad;

  @NotNull(message = "El nombre de la hermandad no puede ser nulo")
  @NotBlank(message = "El nombre de la hermandad no puede estar vacío")
  @NotEmpty(message = "El nombre de la hermandad no puede estar vacío")
  private String nombreHermandad;

  @NotNull(message = "El número de nazarenos no puede ser nulo")
  @Range(min = 0, message = "El número de nazarenos debe ser positivo")
  private Integer numeroNazarenos;

  @Builder.Default
  private List<Long> idFormacionesMusicales = new ArrayList<>();
}

