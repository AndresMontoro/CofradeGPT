package es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

import org.vaadin.crudui.crud.impl.GridCrud;
import es.ca.andresmontoro.backoffice.Layout;
import es.ca.andresmontoro.backoffice.formaciones_musicales.application.ManageFormacionesMusicalesUseCase;
import es.ca.andresmontoro.backoffice.localidades.ciudades.application.ManageCiudadesUseCase;
import es.ca.andresmontoro.backoffice.localidades.ciudades.infrastructure.CiudadResponse;

@Route(value = "formaciones-musicales", layout = Layout.class)
public class FormacionesMusicalesView extends VerticalLayout {
  
  private final ManageFormacionesMusicalesUseCase manageFormacionesMusicalesUseCase;
  private final ManageCiudadesUseCase manageCiudadesUseCase;

  public FormacionesMusicalesView(ManageFormacionesMusicalesUseCase manageFormacionesMusicalesUseCase,
  ManageCiudadesUseCase manageCiudadesUseCase) {
    this.manageFormacionesMusicalesUseCase = manageFormacionesMusicalesUseCase;
    this.manageCiudadesUseCase = manageCiudadesUseCase;

    GridCrud<FormacionMusicalResponse> crud = new GridCrud<>(FormacionMusicalResponse.class);
    configureCrud(crud);
    add(crud);
  }

  private void configureCrud(GridCrud<FormacionMusicalResponse> crud) {
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("nombre", "fechaFundacion", "estilo", "idCiudad");
    crud.getCrudFormFactory().setFieldCaptions("Nombre", "Fecha de Fundación", "Estilo", "Ciudad");

    crud.getCrudFormFactory().setFieldProvider("idCiudad", field -> createCiudadComboBox());

    configureGrid(crud);

    crud.setFindAllOperation(() -> manageFormacionesMusicalesUseCase.findAll());
    crud.setAddOperation(formacion -> {
      try {
        return manageFormacionesMusicalesUseCase.create(formacion);
      } catch (Exception e) {
        showErrorNotification("Error al agregar la formación musical: " + e.getMessage());
        return null;
      }
    });
    crud.setUpdateOperation(formacion -> {
      try {
        return manageFormacionesMusicalesUseCase.update(formacion);
      } catch (Exception e) {
        showErrorNotification("Error al actualizar la formación musical: " + e.getMessage());
        return null;
      }
    });
    crud.setDeleteOperation(formacion -> {
      try {
        manageFormacionesMusicalesUseCase.delete(formacion);
      } catch (Exception e) {
        showErrorNotification("Error al eliminar la formación musical: " + e.getMessage());
      }
    });
  }

  private ComboBox<String> createCiudadComboBox() {
    ComboBox<String> comboBox = new ComboBox<>();
    comboBox.setLabel("Ciudad");

    List<CiudadResponse> ciudades = manageCiudadesUseCase.findAll();
    
    comboBox.setItems(ciudades.stream()
      .map(ciudad -> String.valueOf(ciudad.getId()))
      .toList());

    comboBox.setItemLabelGenerator(id -> generateCiudadLabel(id, ciudades));

    return comboBox;
  }

  private String generateCiudadLabel(String id, List<CiudadResponse> ciudades) {
    return ciudades.stream()
      .filter(c -> String.valueOf(c.getId()).equals(id))
      .map(c -> c.getNombre() + " (ID: " + c.getId() + ")")
      .findFirst()
      .orElse(id);
  }

  private void configureGrid(GridCrud<FormacionMusicalResponse> crud) {
    crud.getGrid().setColumns("id", "nombre", "fechaFundacion", "estilo", "nombreCiudad");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("nombre").setHeader("Nombre");
    crud.getGrid().getColumnByKey("fechaFundacion").setHeader("Fecha de Fundación");
    crud.getGrid().getColumnByKey("estilo").setHeader("Estilo");
    crud.getGrid().getColumnByKey("nombreCiudad").setHeader("Ciudad");
  }

  private void showErrorNotification(String message) {
    Notification notification = new Notification(message, 3000, Position.MIDDLE);
    notification.open();
  }
}
