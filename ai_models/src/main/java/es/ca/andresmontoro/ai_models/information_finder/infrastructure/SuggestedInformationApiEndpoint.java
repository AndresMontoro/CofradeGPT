package es.ca.andresmontoro.ai_models.information_finder.infrastructure;

import dev.langchain4j.model.output.structured.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SuggestedInformationApiEndpoint {
  
  @Description("""
    Especifica si necesitas más contexto (true) o si puedes 
    proceder con los datos actuales (false).  
  """)
  private boolean needMoreInformation;

  @Description("""
    Especifica el endpoint relevante, omitiendo la parte 
    /chatcofrade/informacion/ y ajustándolo a los parámetros 
    más relevantes para obtener los datos correctos.
  """)
  private String apiEndPoint;
}
