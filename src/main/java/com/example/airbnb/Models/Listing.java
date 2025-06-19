package com.example.airbnb.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.io.Serializable;

@Document(collection = "Alojamientos")



public class Listing implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
   

    private String listing_url;
    private String name;
    private String summary;
    private String space;
    private String description;
    private String neighborhood_overview;
    private String notes;
    private String transit;
    private String access;
    private String interaction;
    private String house_rules;

    private String property_type;
    private String room_type;
    private String bed_type;
    private String minimum_nights;
    private String maximum_nights;
    private String cancellation_policy;

    private String last_scraped;
    private String calendar_last_scraped;
    private String first_review;
    private String last_review;

    private Integer accommodates;
    private Integer bedrooms;
    private Integer beds;
    private Integer number_of_reviews;
    private Double bathrooms;
    private Double price;
    private Double security_deposit;
    private Double cleaning_fee;
    private Double extra_people;
    private Integer guests_included;

    private List<String> amenities;
    private List<Review> reviews;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getListing_url() {
		return listing_url;
	}
	public void setListing_url(String listing_url) {
		this.listing_url = listing_url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNeighborhood_overview() {
		return neighborhood_overview;
	}
	public void setNeighborhood_overview(String neighborhood_overview) {
		this.neighborhood_overview = neighborhood_overview;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getTransit() {
		return transit;
	}
	public void setTransit(String transit) {
		this.transit = transit;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public String getInteraction() {
		return interaction;
	}
	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}
	public String getHouse_rules() {
		return house_rules;
	}
	public void setHouse_rules(String house_rules) {
		this.house_rules = house_rules;
	}
	public String getProperty_type() {
		return property_type;
	}
	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getBed_type() {
		return bed_type;
	}
	public void setBed_type(String bed_type) {
		this.bed_type = bed_type;
	}
	public String getMinimum_nights() {
		return minimum_nights;
	}
	public void setMinimum_nights(String minimum_nights) {
		this.minimum_nights = minimum_nights;
	}
	public String getMaximum_nights() {
		return maximum_nights;
	}
	public void setMaximum_nights(String maximum_nights) {
		this.maximum_nights = maximum_nights;
	}
	public String getCancellation_policy() {
		return cancellation_policy;
	}
	public void setCancellation_policy(String cancellation_policy) {
		this.cancellation_policy = cancellation_policy;
	}
	public String getLast_scraped() {
		return last_scraped;
	}
	public void setLast_scraped(String last_scraped) {
		this.last_scraped = last_scraped;
	}
	public String getCalendar_last_scraped() {
		return calendar_last_scraped;
	}
	public void setCalendar_last_scraped(String calendar_last_scraped) {
		this.calendar_last_scraped = calendar_last_scraped;
	}
	public String getFirst_review() {
		return first_review;
	}
	public void setFirst_review(String first_review) {
		this.first_review = first_review;
	}
	public String getLast_review() {
		return last_review;
	}
	public void setLast_review(String last_review) {
		this.last_review = last_review;
	}
	public Integer getAccommodates() {
		return accommodates;
	}
	public void setAccommodates(Integer accommodates) {
		this.accommodates = accommodates;
	}
	public Integer getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}
	public Integer getBeds() {
		return beds;
	}
	public void setBeds(Integer beds) {
		this.beds = beds;
	}
	public Integer getNumber_of_reviews() {
		return number_of_reviews;
	}
	public void setNumber_of_reviews(Integer number_of_reviews) {
		this.number_of_reviews = number_of_reviews;
	}
	public Double getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(Double bathrooms) {
		this.bathrooms = bathrooms;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getSecurity_deposit() {
		return security_deposit;
	}
	public void setSecurity_deposit(Double security_deposit) {
		this.security_deposit = security_deposit;
	}
	public Double getCleaning_fee() {
		return cleaning_fee;
	}
	public void setCleaning_fee(Double cleaning_fee) {
		this.cleaning_fee = cleaning_fee;
	}
	public Double getExtra_people() {
		return extra_people;
	}
	public void setExtra_people(Double extra_people) {
		this.extra_people = extra_people;
	}
	public Integer getGuests_included() {
		return guests_included;
	}
	public void setGuests_included(Integer guests_included) {
		this.guests_included = guests_included;
	}
	public List<String> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Host getHost() {
		return host;
	}
	public void setHost(Host host) {
		this.host = host;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Images getImages() {
		return images;
	}
	public void setImages(Images images) {
		this.images = images;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	public ReviewScores getReview_scores() {
		return review_scores;
	}
	public void setReview_scores(ReviewScores review_scores) {
		this.review_scores = review_scores;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private Host host;
    private Address address;
    private Images images;
    private Availability availability;
    private ReviewScores review_scores;

     
}