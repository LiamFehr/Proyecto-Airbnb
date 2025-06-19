package com.example.airbnb.view;

import com.example.airbnb.Models.Review;
import com.example.airbnb.Models.Listing;
import com.example.airbnb.ListingRepository;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Route("reviews")
public class ReviewForm extends VerticalLayout implements HasUrlParameter<String> {

    @Autowired
    private ListingRepository listingRepository;

    private final Grid<Review> reviewGrid = new Grid<>(Review.class);

    private final TextField reviewerId = new TextField("ID del Revisor");
    private final TextField reviewerName = new TextField("Nombre");
    private final TextField comments = new TextField("Comentario");

    private final Button addButton = new Button("Agregar");
    private final Button updateButton = new Button("Actualizar");
    private final Button deleteButton = new Button("Eliminar");

    private Review selectedReview = null;
    private String currentListingId = null;

    public ReviewForm() {
        setPadding(true);
        setSpacing(true);

        reviewGrid.setColumns("reviewerId", "reviewerName", "date", "comments");

        reviewGrid.asSingleSelect().addValueChangeListener(event -> {
            selectedReview = event.getValue();
            if (selectedReview != null) {
                reviewerId.setValue(selectedReview.getReviewerId() != null ? selectedReview.getReviewerId() : "");
                reviewerName.setValue(selectedReview.getReviewerName() != null ? selectedReview.getReviewerName() : "");
                comments.setValue(selectedReview.getComments() != null ? selectedReview.getComments() : "");
            }
        });

        addButton.addClickListener(e -> {
            if (currentListingId != null && !reviewerName.isEmpty() && !comments.isEmpty()) {
                Listing listing = listingRepository.findById(currentListingId).orElse(null);
                if (listing != null) {
                    Review r = new Review();
                    r.setId(UUID.randomUUID().toString());
                    r.setReviewerId(reviewerId.getValue());
                    r.setReviewerName(reviewerName.getValue());
                    r.setComments(comments.getValue());
                    r.setDate(LocalDate.now().toString()); 

                    if (listing.getReviews() == null) {
                        listing.setReviews(new ArrayList<>());
                    }
                    listing.getReviews().add(r);
                    listingRepository.save(listing);
                    updateGrid();
                    clearForm();
                }
            }
        });

        updateButton.addClickListener(e -> {
            if (selectedReview != null) {
                Listing listing = listingRepository.findById(currentListingId).orElse(null);
                if (listing != null && listing.getReviews() != null) {
                    listing.getReviews().removeIf(r -> r.getId().equals(selectedReview.getId()));
                    selectedReview.setReviewerId(reviewerId.getValue());
                    selectedReview.setReviewerName(reviewerName.getValue());
                    selectedReview.setComments(comments.getValue());
                    listing.getReviews().add(selectedReview);
                    listingRepository.save(listing);
                    updateGrid();
                    clearForm();
                }
            }
        });

        deleteButton.addClickListener(e -> {
            if (selectedReview != null) {
                Listing listing = listingRepository.findById(currentListingId).orElse(null);
                if (listing != null && listing.getReviews() != null) {
                    listing.getReviews().removeIf(r -> r.getId().equals(selectedReview.getId()));
                    listingRepository.save(listing);
                    updateGrid();
                    clearForm();
                }
            } else {
                Notification.show("Seleccione una review para eliminar");
            }
        });

        HorizontalLayout form = new HorizontalLayout(reviewerId, reviewerName, comments, addButton, updateButton, deleteButton);
        add(new H2("Reviews del alojamiento"), form, reviewGrid);
    }

    @Override
    public void setParameter(BeforeEvent event, String listingId) {
        this.currentListingId = listingId;
        updateGrid();
    }

    private void updateGrid() {
        if (currentListingId != null) {
            Listing listing = listingRepository.findById(currentListingId).orElse(null);
            List<Review> reviews = listing != null && listing.getReviews() != null ? listing.getReviews() : new ArrayList<>();
            System.out.println("🔍 Reviews encontradas: " + reviews.size());
            reviewGrid.setItems(reviews);
        }
    }

    private void clearForm() {
        reviewerId.clear();
        reviewerName.clear();
        comments.clear();
        selectedReview = null;
        reviewGrid.deselectAll();
    }
}
