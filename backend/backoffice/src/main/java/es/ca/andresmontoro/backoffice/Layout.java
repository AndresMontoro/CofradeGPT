package es.ca.andresmontoro.backoffice;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Layout extends AppLayout {

  public Layout() {
    DrawerToggle toggle = new DrawerToggle();

    H1 title = new H1("CofradeGPT");
    title.getStyle().set("font-size", "var(--lumo-font-size-l)")
        .set("margin", "0");

    SideNav nav = getSideNav();

    Scroller scroller = new Scroller(nav);
    scroller.setClassName(LumoUtility.Padding.SMALL);

    MenuBar profileMenu = createProfileMenu();
    profileMenu.getStyle().set("margin-right", "10px");

    HorizontalLayout navbarLayout = new HorizontalLayout(toggle, title, profileMenu);
    navbarLayout.setWidthFull();
    navbarLayout.expand(title);
    navbarLayout.setAlignItems(Alignment.CENTER);

    addToDrawer(scroller);
    addToNavbar(navbarLayout);
  }

  private SideNav getSideNav() {
    SideNav sideNav = new SideNav();
    sideNav.addItem(
      new SideNavItem(
        "Hermandades", "/hermandades",
        VaadinIcon.DASHBOARD.create()),
      new SideNavItem(
        "Formaciones Musicales", "/formaciones-musicales", 
        VaadinIcon.CART.create()),
      new SideNavItem(
        "Comunidades Autonomas", "/comunidades", 
        VaadinIcon.CART.create()),
      new SideNavItem(
        "Provincias", "/provincias", 
        VaadinIcon.CART.create()),
      new SideNavItem(
        "Ciudades", "/ciudades", 
        VaadinIcon.CART.create()),
      new SideNavItem(
        "Salidas Procesionales", "/salidasProcesionales", 
        VaadinIcon.CART.create())
    );
      
    return sideNav;
  }

  private MenuBar createProfileMenu() {
    MenuBar menuBar = new MenuBar();
    MenuItem profile = menuBar.addItem(VaadinIcon.USER.create());
    profile.getSubMenu().addItem("Cerrar sesión", e -> logout());
    return menuBar;
  }

  private void logout() {
    VaadinSession.getCurrent().getSession().invalidate();
    getUI().ifPresent(ui -> ui.getPage().setLocation("/logout"));
  }
}
