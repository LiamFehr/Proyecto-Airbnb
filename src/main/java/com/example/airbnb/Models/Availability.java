package com.example.airbnb.Models;
import java.io.Serializable;
public class Availability  implements Serializable 
{ private static final long serialVersionUID = 1L;

	 private Integer availability_30;
     private Integer availability_60;
     private Integer availability_90;
     private Integer availability_365;
	public Integer getAvailability_30() {
		return availability_30;
	}
	public void setAvailability_30(Integer availability_30) {
		this.availability_30 = availability_30;
	}
	public Integer getAvailability_60() {
		return availability_60;
	}
	public void setAvailability_60(Integer availability_60) {
		this.availability_60 = availability_60;
	}
	public Integer getAvailability_90() {
		return availability_90;
	}
	public void setAvailability_90(Integer availability_90) {
		this.availability_90 = availability_90;
	}
	public Integer getAvailability_365() {
		return availability_365;
	}
	public void setAvailability_365(Integer availability_365) {
		this.availability_365 = availability_365;
	}
}
