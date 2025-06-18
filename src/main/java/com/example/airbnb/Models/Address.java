package com.example.airbnb.Models;
import java.io.Serializable;
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
	  private String street;
      private String suburb;
      private String government_area;
      private String market;
      private String country;
      private String country_code;
      private Location location;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public String getGovernment_area() {
		return government_area;
	}
	public void setGovernment_area(String government_area) {
		this.government_area = government_area;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

}
