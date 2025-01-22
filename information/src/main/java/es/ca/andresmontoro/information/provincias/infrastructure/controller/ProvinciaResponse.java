package es.ca.andresmontoro.information.provincias.infrastructure.controller;

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
public class ProvinciaResponse {
  
  private Long id;

  private String nombre;

  private Long comunidadAutonomaId;

  private String comunidadAutonomaNombre;
}
