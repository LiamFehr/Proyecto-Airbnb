package com.example.airbnb.Models;

import java.util.List;
import java.io.Serializable;
public class Location  implements Serializable 
{ private static final long serialVersionUID = 1L;
	 private String type;
     private List<Double> coordinates;
     private Boolean is_location_exact;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Double> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}
	public Boolean getIs_location_exact() {
		return is_location_exact;
	}
	public void setIs_location_exact(Boolean is_location_exact) {
		this.is_location_exact = is_location_exact;
	}
}
