package es.ca.andresmontoro.ai_logs.kafka.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LoggingDTO {

  @NotNull
  @NotEmpty
  @NotBlank
  private String userPrompt;

  @NotNull
  @NotEmpty
  @NotBlank
  private String aiResponse;
}
