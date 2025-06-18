package com.example.airbnb;
import com.example.airbnb.Listing;
import com.example.airbnb.ListingService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class ListingView extends VerticalLayout {

    private final ListingService listingService;
    private final Grid<Listing> grid = new Grid<>(Listing.class);

    @Autowired
    public ListingView(ListingService service) {
        this.listingService = service;

        TextField filter = new TextField("Buscar por nombre");
        Button search = new Button("Buscar", e -> {
            grid.setItems(listingService.searchByName(filter.getValue()));
        });

        Button refresh = new Button("Mostrar todos", e -> {
            grid.setItems(listingService.getAll());
        });

        grid.setColumns("name", "neighborhood", "price", "accommodates");
        add(filter, search, refresh, grid);
        grid.setItems(listingService.getAll());
    }
}
