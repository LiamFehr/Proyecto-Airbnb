package com.example.airbnb.Models;
import java.io.Serializable;
public class ReviewScores  implements Serializable 
{ private static final long serialVersionUID = 1L;
	 private Integer review_scores_accuracy;
     private Integer review_scores_cleanliness;
     private Integer review_scores_checkin;
     private Integer review_scores_communication;
     private Integer review_scores_location;
     private Integer review_scores_value;
     private Integer review_scores_rating;
	public Integer getReview_scores_accuracy() {
		return review_scores_accuracy;
	}
	public void setReview_scores_accuracy(Integer review_scores_accuracy) {
		this.review_scores_accuracy = review_scores_accuracy;
	}
	public Integer getReview_scores_cleanliness() {
		return review_scores_cleanliness;
	}
	public void setReview_scores_cleanliness(Integer review_scores_cleanliness) {
		this.review_scores_cleanliness = review_scores_cleanliness;
	}
	public Integer getReview_scores_checkin() {
		return review_scores_checkin;
	}
	public void setReview_scores_checkin(Integer review_scores_checkin) {
		this.review_scores_checkin = review_scores_checkin;
	}
	public Integer getReview_scores_communication() {
		return review_scores_communication;
	}
	public void setReview_scores_communication(Integer review_scores_communication) {
		this.review_scores_communication = review_scores_communication;
	}
	public Integer getReview_scores_location() {
		return review_scores_location;
	}
	public void setReview_scores_location(Integer review_scores_location) {
		this.review_scores_location = review_scores_location;
	}
	public Integer getReview_scores_value() {
		return review_scores_value;
	}
	public void setReview_scores_value(Integer review_scores_value) {
		this.review_scores_value = review_scores_value;
	}
	public Integer getReview_scores_rating() {
		return review_scores_rating;
	}
	public void setReview_scores_rating(Integer review_scores_rating) {
		this.review_scores_rating = review_scores_rating;
	}
}
