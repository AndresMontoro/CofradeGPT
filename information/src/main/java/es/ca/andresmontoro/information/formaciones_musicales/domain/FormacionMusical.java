package es.ca.andresmontoro.information.formaciones_musicales.domain;

import java.time.LocalDate;

import es.ca.andresmontoro.information.localidades.domain.Ciudad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class FormacionMusical {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "El nombre no puede ser nulo")
  @NotEmpty(message = "El nombre no puede estar vacío")
  @NotBlank(message = "El nombre no puede estar en blanco")
  @Size(max = 1024, message = "El nombre no puede tener más de 1024 caracteres")
  private String nombre;

  @NotNull(message = "La fecha de fundación no puede ser nula")
  @PastOrPresent(message = "La fecha de fundación no puede ser futura")
  @NotNull(message = "La fecha de fundación no puede ser nula")
  private LocalDate fechaFundacion;

  @ManyToOne
  @NotNull(message = "El estilo no puede ser nulo")
  private EstiloFormacion estilo;
  
  @ManyToOne
  @NotNull(message = "La ciudad no puede ser nula")
  private Ciudad ciudad;
}
