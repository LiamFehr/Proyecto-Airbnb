package com.example.airbnb.view;
import com.example.airbnb.ListingService;
import com.example.airbnb.Models.Listing;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("/form")
public class ListingFormView extends VerticalLayout {

    private final ListingService listingService;
    private final Grid<Listing> grid = new Grid<>(Listing.class, false);

    public ListingFormView(@Autowired ListingService listingService) {
        this.listingService = listingService;

        TextField idField = new TextField("ID");
        TextField nameField = new TextField("Nombre");
        NumberField priceField = new NumberField("Precio");
        NumberField accommodatesField = new NumberField("Capacidad");

        Button saveButton = new Button("Guardar", e -> {
            Listing listing = new Listing();
            listing.setId(idField.getValue());
            listing.setName(nameField.getValue());
            listing.setPrice(priceField.getValue());
            listing.setAccommodates(accommodatesField.getValue().intValue());
            listingService.save(listing);
            Notification.show("Alojamiento guardado");
            refreshGrid();
        });

        Button deleteButton = new Button("Eliminar", e -> {
            listingService.delete(idField.getValue());
            Notification.show("Alojamiento eliminado");
            refreshGrid();
        });

        FormLayout form = new FormLayout();
        form.add(idField, nameField, priceField, accommodatesField);
        HorizontalLayout buttons = new HorizontalLayout(saveButton, deleteButton);
        add(form, buttons);

        grid.addColumn(Listing::getId).setHeader("ID");
        grid.addColumn(Listing::getName).setHeader("Nombre");
        grid.addColumn(Listing::getPrice).setHeader("Precio");
        grid.addColumn(Listing::getAccommodates).setHeader("Capacidad");

        Anchor back = new Anchor("/", "Volver a la lista principal");
        add(back);

        add(grid);
        refreshGrid();
    }

    private void refreshGrid() {
        List<Listing> listings = listingService.getAll();
        grid.setItems(listings);
    }
}
