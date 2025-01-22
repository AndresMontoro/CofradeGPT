package es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

  private LocalDateTime fechaHoraSalida;
  
  private LocalDateTime verdaderaFechaHoraSalida;

  private LocalDateTime fechaHoraRecogida;

  private LocalDateTime verdaderaFechaHoraRecogida;

  private DiaSalida diaSalida;

  private Long idHermandad;

  private String nombreHermandad;

  private Integer numeroNazarenos;

  @Builder.Default
  private List<Long> idFormacionesMusicales = new ArrayList<>();
}

