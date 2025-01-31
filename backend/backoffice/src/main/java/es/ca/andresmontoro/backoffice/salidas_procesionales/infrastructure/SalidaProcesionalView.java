package es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.ca.andresmontoro.backoffice.Layout;
import es.ca.andresmontoro.backoffice.formaciones_musicales.application.ManageFormacionesMusicalesUseCase;
import es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure.FormacionMusicalResponse;
import es.ca.andresmontoro.backoffice.salidas_procesionales.application.ManageSalidasProcesionalesUseCase;

@Route(value = "salidasProcesionales", layout = Layout.class)
public class SalidaProcesionalView extends VerticalLayout {
  
  private final ManageSalidasProcesionalesUseCase manageSalidasProcesionalesUseCase;
  private final ManageFormacionesMusicalesUseCase manageFormacionesMusicalesUseCase;

  public SalidaProcesionalView(
  ManageSalidasProcesionalesUseCase manageSalidasProcesionalesUseCase,
  ManageFormacionesMusicalesUseCase manageFormacionesMusicalesUseCase) {
    this.manageSalidasProcesionalesUseCase = manageSalidasProcesionalesUseCase;
    this.manageFormacionesMusicalesUseCase = manageFormacionesMusicalesUseCase;

    GridCrud<SalidaProcesionalResponse> crud = new GridCrud<>(SalidaProcesionalResponse.class);
    configureCrud(crud);

    add(crud);
  }

  private void configureCrud(GridCrud<SalidaProcesionalResponse> crud) {
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties(
      "fechaHoraSalida", "verdaderaFechaHoraSalida", 
      "fechaHoraRecogida", "verdaderaFechaHoraRecogida", 
      "diaSalida", "idHermandad", "numeroNazarenos", 
      "idFormacionesMusicales");
    crud.getCrudFormFactory().setFieldCaptions(
      "Salida", "Verdadera Salida", "Recogida", 
      "Verdadera Recogida", "Día de Salida", "ID Hermandad", 
      "Número de Nazarenos", "ID Formaciones Musicales");

    crud.getCrudFormFactory().setFieldProvider(
      "idFormacionesMusicales", 
      field -> createFormacionesMusicalesMultiSelectComboBox());

    configureDateTimeFieldProviders(crud);
    configureGrid(crud);
    
    crud.setFindAllOperation(() -> manageSalidasProcesionalesUseCase.findAll());
    crud.setAddOperation(this.manageSalidasProcesionalesUseCase::create);
    crud.setUpdateOperation(this.manageSalidasProcesionalesUseCase::update);
    crud.setDeleteOperation(this.manageSalidasProcesionalesUseCase::delete);
  } 

  private void configureGrid(GridCrud<SalidaProcesionalResponse> crud) {
    crud.getGrid().setColumns(
      "id", "fechaHoraSalida", 
      "verdaderaFechaHoraSalida", "fechaHoraRecogida", 
      "verdaderaFechaHoraRecogida", "diaSalida", "nombreHermandad", 
      "numeroNazarenos", "idFormacionesMusicales");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("fechaHoraSalida")
      .setHeader("Salida");
    crud.getGrid().getColumnByKey("verdaderaFechaHoraSalida")
      .setHeader("Verdadera Salida");
    crud.getGrid().getColumnByKey("fechaHoraRecogida")
      .setHeader("Recogida");
    crud.getGrid().getColumnByKey("verdaderaFechaHoraRecogida")
      .setHeader("Verdadera Recogida");
    crud.getGrid().getColumnByKey("diaSalida")
      .setHeader("Día de Salida");
    crud.getGrid().getColumnByKey("nombreHermandad")
      .setHeader("Hermandad");
    crud.getGrid().getColumnByKey("numeroNazarenos")
      .setHeader("Nazarenos");
    crud.getGrid().getColumnByKey("idFormacionesMusicales")
      .setHeader("Formaciones Musicales");
  }

  private MultiSelectComboBox<Long> 
  createFormacionesMusicalesMultiSelectComboBox() {
    MultiSelectComboBox<Long> comboBox = new MultiSelectComboBox<>(
      "Formaciones Musicales");

    List<FormacionMusicalResponse> formacionesMusicales = 
      manageFormacionesMusicalesUseCase.findAll();

    comboBox.setItems(formacionesMusicales.stream()
      .map(formacion -> formacion.getId())
      .collect(Collectors.toSet()));

    comboBox.setItemLabelGenerator(id -> generateFormacionMusicalLabel(id, formacionesMusicales));
    return comboBox;
  }

  private String generateFormacionMusicalLabel(Long id, List<FormacionMusicalResponse> formacionesMusicales){
    return formacionesMusicales.stream()
      .filter(f -> f.getId().equals(id))
      .map(f -> f.getNombre() + " (ID: " + f.getId() + ")")
      .findFirst()
      .orElse(String.valueOf(id));
  }

  private void configureDateTimeFieldProviders(GridCrud<SalidaProcesionalResponse> crud) {
    crud.getCrudFormFactory().setFieldProvider("fechaHoraSalida", field -> {
      DateTimePicker dateTimePicker = new DateTimePicker();
      dateTimePicker.setLabel("Salida");
      return dateTimePicker;
    });

    crud.getCrudFormFactory().setFieldProvider("verdaderaFechaHoraSalida", field -> {
      DateTimePicker dateTimePicker = new DateTimePicker();
      dateTimePicker.setLabel("Verdadera Salida");
      return dateTimePicker;
    });

    crud.getCrudFormFactory().setFieldProvider("fechaHoraRecogida", field -> {
      DateTimePicker dateTimePicker = new DateTimePicker();
      dateTimePicker.setLabel("Recogida");
      return dateTimePicker;
    });

    crud.getCrudFormFactory().setFieldProvider("verdaderaFechaHoraRecogida", field -> {
      DateTimePicker dateTimePicker = new DateTimePicker();
      dateTimePicker.setLabel("Verdadera Recogida");
      return dateTimePicker;
    });
  }
}
