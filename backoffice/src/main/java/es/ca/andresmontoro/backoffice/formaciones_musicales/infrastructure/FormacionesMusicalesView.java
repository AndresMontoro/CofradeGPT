package es.ca.andresmontoro.backoffice.formaciones_musicales.infrastructure;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
import es.ca.andresmontoro.backoffice.Layout;
import es.ca.andresmontoro.backoffice.formaciones_musicales.application.ManageFormacionesMusicalesUseCase;

@Route(value = "formaciones-musicales", layout = Layout.class)
public class FormacionesMusicalesView extends VerticalLayout {
  
  private final ManageFormacionesMusicalesUseCase manageFormacionesMusicalesUseCase;

  public FormacionesMusicalesView(ManageFormacionesMusicalesUseCase manageFormacionesMusicalesUseCase) {
    this.manageFormacionesMusicalesUseCase = manageFormacionesMusicalesUseCase;

    GridCrud<FormacionMusicalResponse> crud = new GridCrud<>(FormacionMusicalResponse.class);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("nombre", "fechaFundacion", "estilo", "idCiudad");
    crud.getCrudFormFactory().setFieldCaptions("Nombre", "Fecha de Fundación", "Estilo", "Id Ciudad");

    // Personalizar campos

    crud.getGrid().setColumns("id", "nombre", "fechaFundacion", "estilo", "idCiudad");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("nombre").setHeader("Nombre");
    crud.getGrid().getColumnByKey("fechaFundacion").setHeader("Fecha de Fundación");
    crud.getGrid().getColumnByKey("estilo").setHeader("Estilo");
    crud.getGrid().getColumnByKey("idCiudad").setHeader("Id Ciudad");

    crud.setFindAllOperation(() -> manageFormacionesMusicalesUseCase.findAll());
    crud.setAddOperation(this.manageFormacionesMusicalesUseCase::create);
    crud.setUpdateOperation(this.manageFormacionesMusicalesUseCase::update);
    crud.setDeleteOperation(this.manageFormacionesMusicalesUseCase::delete);

    add(crud);
  }
}
