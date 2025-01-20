package es.ca.andresmontoro.backoffice;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
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

    addToDrawer(scroller);
    addToNavbar(toggle, title);
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
          VaadinIcon.CART.create())
    );
      
    return sideNav;
  }
}
