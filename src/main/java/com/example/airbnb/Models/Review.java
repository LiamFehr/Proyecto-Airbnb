package com.example.airbnb.Models;

import java.io.Serializable;

import com.vaadin.flow.component.template.Id;

public class Review  implements Serializable 
{ private static final long serialVersionUID = 1L;
@Id	 
private String id;
     private String reviewer_name;
     private String date;
     private String comments;
     private String listingId;
	public String getListingId() {
		return listingId;
	}
	public void setListingId(String listingId) {
		this.listingId = listingId;
	}
	public String getid() {
		return id;
	}
	public void setid(String reviewer_id) {
		this.id = reviewer_id;
	}
	public String getReviewer_name() {
		return reviewer_name;
	}
	public void setReviewer_name(String reviewer_name) {
		this.reviewer_name = reviewer_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
