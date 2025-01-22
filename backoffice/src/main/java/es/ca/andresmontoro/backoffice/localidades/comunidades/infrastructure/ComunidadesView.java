package es.ca.andresmontoro.backoffice.localidades.comunidades.infrastructure;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.ca.andresmontoro.backoffice.Layout;
import es.ca.andresmontoro.backoffice.localidades.comunidades.application.ManageComunidadUseCase;

@Route(value = "comunidades", layout = Layout.class)
public class ComunidadesView extends VerticalLayout{
  
  private final ManageComunidadUseCase manageComunidadesUseCase;

  public ComunidadesView(ManageComunidadUseCase manageComunidadUseCase) {
    this.manageComunidadesUseCase = manageComunidadUseCase;

    GridCrud<ComunidadAutonomaResponse> crud = new GridCrud<>(ComunidadAutonomaResponse.class);
    configureCrud(crud);

    add(crud);
  }

  private void configureCrud(GridCrud<ComunidadAutonomaResponse> crud) {
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("nombre");
    crud.getCrudFormFactory().setFieldCaptions("Nombre");

    configureGrid(crud);

    crud.setFindAllOperation(() -> manageComunidadesUseCase.findAll());
    crud.setAddOperation(comunidad -> {
      try {
        return manageComunidadesUseCase.create(comunidad);
      } catch (Exception e) {
        showErrorNotification("Error al agregar la comunidad autónoma: " + e.getMessage());
        return null;
      }
    });
    crud.setUpdateOperation(comunidad -> {
      try {
        return manageComunidadesUseCase.update(comunidad);
      } catch (Exception e) {
        showErrorNotification("Error al actualizar la comunidad autónoma: " + e.getMessage());
        return null;
      }
    });
    crud.setDeleteOperation(comunidad -> {
      try {
        manageComunidadesUseCase.delete(comunidad);
      } catch (Exception e) {
        showErrorNotification("Error al eliminar la comunidad autónoma: " + e.getMessage());
      }
    });
  }

  private void configureGrid(GridCrud<ComunidadAutonomaResponse> crud) {
    crud.getGrid().setColumns("id", "nombre");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("nombre").setHeader("Nombre");
  }

  private void showErrorNotification(String message) {
    Notification notification = new Notification(message, 3000, Position.MIDDLE);
    notification.open();
  }
}
