package com.example.airbnb.view;






import java.time.LocalDate;

import com.example.airbnb.ReviewService;
import com.example.airbnb.Models.Review;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("reviews")
public class ReviewForm extends VerticalLayout implements HasUrlParameter<String> {

    private final ReviewService reviewService;
    private final Grid<Review> reviewGrid = new Grid<>(Review.class);
    private final TextField reviewerName = new TextField("Nombre");
    private final TextField comments = new TextField("Comentario");
    private final Button addButton = new Button("Agregar");
    private final Button updateButton = new Button("Actualizar");
    private final Button deleteButton = new Button("Eliminar");

    private String currentListingId;
    private Review selectedReview;

    public ReviewForm(ReviewService reviewService) {
        this.reviewService = reviewService;

        setPadding(true);
        setSpacing(true);

        // Configuración de la grilla
        reviewGrid.setColumns("reviewer_name", "date", "comments");
        reviewGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        reviewGrid.addSelectionListener(event -> {
            selectedReview = event.getFirstSelectedItem().orElse(null);
            if (selectedReview != null) {
                reviewerName.setValue(selectedReview.getReviewer_name());
                comments.setValue(selectedReview.getComments());
            }
        });

        // Botón Agregar
        addButton.addClickListener(e -> {
            if (currentListingId != null && !reviewerName.isEmpty() && !comments.isEmpty()) {
                Review r = new Review();
                r.setListingId(currentListingId);
                r.setReviewer_name(reviewerName.getValue());
                r.setComments(comments.getValue());
                r.setDate(LocalDate.now().toString()); // o un valor por defecto si no usás fechas reales

                reviewService.save(r);
                updateGrid();
                clearForm();
            }
        });

        // Botón Actualizar
        updateButton.addClickListener(e -> {
            if (selectedReview != null) {
                selectedReview.setReviewer_name(reviewerName.getValue());
                selectedReview.setComments(comments.getValue());
                reviewService.save(selectedReview);
                updateGrid();
                clearForm();
            }
        });

        // Botón Eliminar
        deleteButton.addClickListener(e -> {
            if (selectedReview != null) {
                reviewService.deleteById(selectedReview.getid());
                updateGrid();
                clearForm();
            } else {
                Notification.show("Seleccione una review para eliminar.");
            }
        });

        HorizontalLayout form = new HorizontalLayout(reviewerName, comments, addButton, updateButton, deleteButton);
        add(new H2("Reviews del alojamiento"), form, reviewGrid);
    }

    @Override
    public void setParameter(BeforeEvent event, String listingId) {
        this.currentListingId = listingId;
        updateGrid();
    }

    private void updateGrid() {
        if (currentListingId != null) {
            reviewGrid.setItems(reviewService.findByListingId(currentListingId));
        }
    }

    private void clearForm() {
        reviewerName.clear();
        comments.clear();
        selectedReview = null;
        reviewGrid.deselectAll();
    }
}