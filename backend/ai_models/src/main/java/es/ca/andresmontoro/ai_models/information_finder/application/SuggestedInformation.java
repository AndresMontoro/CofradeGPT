package es.ca.andresmontoro.ai_models.information_finder.application;

import java.util.List;
import java.util.Map;

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
public class SuggestedInformation {
  
  private String apiEndPoint;

  private List<Map<String, String>> information;
}
