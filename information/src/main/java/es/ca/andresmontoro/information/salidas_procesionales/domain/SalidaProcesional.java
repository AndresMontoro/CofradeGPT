package es.ca.andresmontoro.information.salidas_procesionales.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import es.ca.andresmontoro.information.formaciones_musicales.domain.FormacionMusical;
import es.ca.andresmontoro.information.hermandades.domain.Hermandad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
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
public class SalidaProcesional {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private LocalDate fecha;

  @NotNull
  private DiaSalida diaSalida;

  @NotNull
  @ManyToOne
  private Hermandad hermandad;

  @NotNull
  @Range(min = 0, message = "El número de nazarenos debe ser positivo")
  private Integer numeroNazarenos;

  @ManyToMany
  @Builder.Default
  private List<FormacionMusical> formacionMusical = new ArrayList<>();
}
