package com.example.airbnb.view;
import com.example.airbnb.ListingService;
import com.example.airbnb.Models.Listing;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class ListingView extends VerticalLayout {

    private final ListingService listingService;
    private final Grid<Listing> grid = new Grid<>(Listing.class, false);

    public ListingView(@Autowired ListingService listingService) {
        this.listingService = listingService;

        TextField filter = new TextField("Buscar por nombre");
        Button search = new Button("Buscar", e -> {
        	grid.setItems(listingService.getByNameWithCache(filter.getValue()));
        });

        Button refresh = new Button("Mostrar todos", e -> {
            grid.setItems(listingService.getAll());
        });

        Anchor goToForm = new Anchor("/form", "Agregar Alojamiento");

        grid.addColumn(Listing::getName).setHeader("Nombre");
        grid.addColumn(Listing::getPrice).setHeader("Precio");
        grid.addColumn(Listing::getAccommodates).setHeader("Capacidad");

        add(filter, search, refresh, goToForm, grid);
        grid.setItems(listingService.getAll());
    }
}