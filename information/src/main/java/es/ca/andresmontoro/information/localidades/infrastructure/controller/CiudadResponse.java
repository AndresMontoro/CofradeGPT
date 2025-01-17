package es.ca.andresmontoro.information.localidades.infrastructure.controller;

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
public class CiudadResponse {

  private Long id;

  private String nombre;

  private Long provinciaId;
}
