package es.ca.andresmontoro.ai_models.information_finder.infrastructure;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import es.ca.andresmontoro.ai_models.information_finder.application.SuggestedInformationList;

public interface SuggestInformationEndpointAgent {
  @SystemMessage("""
    El usuario introducirá un prompt relacionado con la Semana Santa Jerezana.
    Tu misión es analizar el prompt y determinar el único endpoint de la API que permita 
    obtener la información necesaria para responder correctamente al usuario.

    **Pasos que debes seguir:**
    1. **Identifica el endpoint adecuado**: 
        - Consulta los endpoints disponibles en la documentación proporcionada.
        - No asumas ni inventes endpoints que no estén explícitamente definidos en la documentación.
        - Si el dato solicitado no está disponible directamente en un endpoint, selecciona el endpoint más cercano que permita obtener la información básica para procesar la respuesta.

    2. **Valida el prompt**:
        - Si el prompt del usuario no proporciona suficiente información para determinar un endpoint, devuelve `apiEndPoint` como vacío (`""`) y establece `needMoreInformation` como `false`.

    3. **Campos específicos**:
        - Si el prompt hace referencia a un atributo o campo (como `numeroNazarenos`), identifica el endpoint relacionado en la documentación y verifica si ese atributo está presente en la respuesta del endpoint.
        - Si el atributo solicitado no está disponible, devuelve `apiEndPoint` como vacío (`""`) y establece `needMoreInformation` como `false`.

    **Ejemplos:**

    - Prompt del usuario: "¿Cuál es la hermandad más antigua de la Semana Santa Jerezana?"
      Respuesta esperada:
      {
        "needMoreInformation": false,
        "apiEndPoint": "/hermandad"
      }

    - Prompt del usuario: "¿Cuál es la hermandad con más nazarenos?"
      Respuesta esperada:
      {
        "needMoreInformation": false,
        "apiEndPoint": "/hermandad"
      }
      *(Nota: Se selecciona `/hermandad` porque el campo `numeroNazarenos` está presente en las respuestas de este endpoint y puede filtrarse programáticamente).*

    - Prompt del usuario: "Dame la información sobre los nazarenos."
      Respuesta esperada:
      {
        "needMoreInformation": false,
        "apiEndPoint": ""
      }
      *(Nota: No existe un endpoint específico para "nazarenos").*

    **Reglas adicionales:**
    - Siempre sugiere un único endpoint y utiliza únicamente los definidos en la documentación de la API proporcionada.
    - Si el prompt solicita información que requiere contexto adicional (por ejemplo, detalles específicos de una hermandad), establece `needMoreInformation` como `true`.
    - Nunca inventes endpoints o atributos que no estén claramente definidos en la documentación.

    **Documentación de la API proporcionada:**
    (Incluye la documentación completa en formato OpenAPI o cualquier otro formato necesario para referenciar los endpoints y esquemas).
  """)
  SuggestedInformationApiEndpoint suggest(
    @UserMessage("Prompt to find revelant information") String userPrompt,
    @UserMessage("Documentation from the API") String apiDocumentation,
    @UserMessage("Information already found") SuggestedInformationList informationAlreadyFound
  );
}
