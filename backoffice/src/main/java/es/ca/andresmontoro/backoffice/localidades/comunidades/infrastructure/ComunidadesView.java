package es.ca.andresmontoro.backoffice.localidades.comunidades.infrastructure;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.ca.andresmontoro.backoffice.Layout;
import es.ca.andresmontoro.backoffice.localidades.comunidades.application.ManageComunidadUseCase;

@Route(value = "comunidades", layout = Layout.class)
public class ComunidadesView extends VerticalLayout{
  
  private final ManageComunidadUseCase manageComunidadesUseCase;

  public ComunidadesView(ManageComunidadUseCase manageComunidadesUseCase) {
    this.manageComunidadesUseCase = manageComunidadesUseCase;

    GridCrud<ComunidadAutonomaResponse> crud = new GridCrud<>(ComunidadAutonomaResponse.class);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("nombre");
    crud.getCrudFormFactory().setFieldCaptions("Nombre");

    // Personalizar el orden de las columnas en la cuadrícula
    crud.getGrid().setColumns("id", "nombre");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("nombre").setHeader("Nombre");
    
    crud.setFindAllOperation(() -> manageComunidadesUseCase.findAll());
    crud.setAddOperation(this.manageComunidadesUseCase::create);
    crud.setUpdateOperation(this.manageComunidadesUseCase::update);
    crud.setDeleteOperation(this.manageComunidadesUseCase::delete);

    add(crud); 
  }
}
