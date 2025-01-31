// package es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure;

// import java.util.List;
// import java.util.Set;
// import java.util.stream.Collectors;

// import com.vaadin.flow.data.binder.Result;
// import com.vaadin.flow.data.binder.ValueContext;
// import com.vaadin.flow.data.converter.Converter;

// public class FormacionesConverter implements Converter<Set<FormacionMusicalResponse>, List<Long>>{

//   @Override
//   public Result<List<Long>> convertToModel(
//   Set<FormacionMusicalResponse> value, ValueContext context) {
//     if(value == null) {
//       return Result.ok(List.of());
//     }
//     List<Long> ids = value.stream()
//       .map(FormacionMusicalResponse::getId)
//       .collect(Collectors.toList());
    
//     return Result.ok(ids);
//   }

//   @Override
//     public Set<FormacionMusicalResponse> convertToPresentation(List<Long> value, ValueContext context) {
//       if (value == null) {
//         return Set.of(); // Devolver conjunto vacío si la lista es null
//       }
//       return value.stream()
//         .map(id -> ) // Crea objetos ficticios
//         .collect(Collectors.toSet());
//     }
  
// }
