package com.example.airbnb.Models;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.vaadin.flow.component.template.Id;
@Document(collection = "Alojamiento")
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("listing_id")
    private String listingId;

    @Field("reviewer_id")
    private String reviewerId;

    @Field("reviewer_name")
    private String reviewerName;

    private String date;

    private String comments;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getListingId() { return listingId; }
    public void setListingId(String listingId) { this.listingId = listingId; }

    public String getReviewerId() { return reviewerId; }
    public void setReviewerId(String reviewerId) { this.reviewerId = reviewerId; }

    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}
