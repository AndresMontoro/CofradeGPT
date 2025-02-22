package es.ca.andresmontoro.information.hermandades.infrastructure.controller;

import java.time.LocalDate;
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
public class HermandadResponse {
  private Long id;

  private String apodo;

  private String nombre;

  private String historia;

  private Integer numeroHermanos;

  private LocalDate fundacion;
}
