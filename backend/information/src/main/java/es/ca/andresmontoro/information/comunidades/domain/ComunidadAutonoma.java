package es.ca.andresmontoro.information.comunidades.domain;

import java.util.ArrayList;
import java.util.List;

import es.ca.andresmontoro.information.provincias.domain.Provincia;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ComunidadAutonoma {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  @NotBlank
  @Size(min = 1, max = 128)
  private String nombre;

  @OneToMany(mappedBy = "comunidadAutonoma")
  @Builder.Default
  private List<Provincia> provincias = new ArrayList<>();
}
