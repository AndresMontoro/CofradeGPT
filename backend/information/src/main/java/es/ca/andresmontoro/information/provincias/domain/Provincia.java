package es.ca.andresmontoro.information.provincias.domain;

import java.util.ArrayList;
import java.util.List;

import es.ca.andresmontoro.information.comunidades.domain.ComunidadAutonoma;
import es.ca.andresmontoro.information.localidades.domain.Ciudad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Provincia {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "El nombre no puede ser nulo")
  @NotEmpty(message = "El nombre no puede estar vacío")
  @NotBlank(message = "El nombre no puede estar en blanco")
  @Size(max = 128, message = "El nombre no puede tener más de 128 caracteres")
  private String nombre;

  @ManyToOne
  @NotNull
  private ComunidadAutonoma comunidadAutonoma;

  @OneToMany(mappedBy = "provincia")
  @Builder.Default
  private List<Ciudad> ciudades = new ArrayList<>();
}
