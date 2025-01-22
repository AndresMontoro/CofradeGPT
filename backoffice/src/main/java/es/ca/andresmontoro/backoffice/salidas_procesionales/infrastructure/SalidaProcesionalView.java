package es.ca.andresmontoro.backoffice.salidas_procesionales.infrastructure;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.ca.andresmontoro.backoffice.Layout;
import es.ca.andresmontoro.backoffice.salidas_procesionales.application.ManageSalidasProcesionalesUseCase;

@Route(value = "salidasProcesionales", layout = Layout.class)
public class SalidaProcesionalView extends VerticalLayout {
  
  private final ManageSalidasProcesionalesUseCase manageSalidasProcesionalesUseCase;

  public SalidaProcesionalView(ManageSalidasProcesionalesUseCase manageSalidasProcesionalesUseCase) {
    this.manageSalidasProcesionalesUseCase = manageSalidasProcesionalesUseCase;

    GridCrud<SalidaProcesionalResponse> crud = new GridCrud<>(SalidaProcesionalResponse.class);
    configureCrud(crud);

    add(crud);
  }

  private void configureCrud(GridCrud<SalidaProcesionalResponse> crud) {
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("fechaHoraSalida", "verdaderaFechaHoraSalida", "fechaHoraRecogida", "verdaderaFechaHoraRecogida", "diaSalida", "idHermandad", "numeroNazarenos", "idFormacionesMusicales");
    crud.getCrudFormFactory().setFieldCaptions("Fecha y hora de salida", "Verdadera fecha y hora de salida", "Fecha y hora de recogida", "Verdadera fecha y hora de recogida", "Día de salida", "ID Hermandad", "Número de nazarenos", "ID Formaciones Musicales");

    configureGrid(crud);
    
    crud.setFindAllOperation(() -> manageSalidasProcesionalesUseCase.findAll());
    crud.setAddOperation(this.manageSalidasProcesionalesUseCase::create);
    crud.setUpdateOperation(this.manageSalidasProcesionalesUseCase::update);
    crud.setDeleteOperation(this.manageSalidasProcesionalesUseCase::delete);
  } 

  private void configureGrid(GridCrud<SalidaProcesionalResponse> crud) {
    crud.getGrid().setColumns("id", "fechaHoraSalida", "verdaderaFechaHoraSalida", "fechaHoraRecogida", "verdaderaFechaHoraRecogida", "diaSalida", "nombreHermandad", "numeroNazarenos", "idFormacionesMusicales");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("fechaHoraSalida").setHeader("Fecha y hora de salida");
    crud.getGrid().getColumnByKey("verdaderaFechaHoraSalida").setHeader("Verdadera fecha y hora de salida");
    crud.getGrid().getColumnByKey("fechaHoraRecogida").setHeader("Fecha y hora de recogida");
    crud.getGrid().getColumnByKey("verdaderaFechaHoraRecogida").setHeader("Verdadera fecha y hora de recogida");
    crud.getGrid().getColumnByKey("diaSalida").setHeader("Día de salida");
    crud.getGrid().getColumnByKey("nombreHermandad").setHeader("Hermandad");
    crud.getGrid().getColumnByKey("numeroNazarenos").setHeader("Número de nazarenos");
    crud.getGrid().getColumnByKey("idFormacionesMusicales").setHeader("Formaciones Musicales");
  }
}
