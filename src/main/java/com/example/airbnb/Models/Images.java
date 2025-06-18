package com.example.airbnb.Models;
import java.io.Serializable;
public class Images  implements Serializable 
{ private static final long serialVersionUID = 1L;
	private String thumbnail_url;
    private String medium_url;
    private String picture_url;
    private String xl_picture_url;
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	public String getMedium_url() {
		return medium_url;
	}
	public void setMedium_url(String medium_url) {
		this.medium_url = medium_url;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	public String getXl_picture_url() {
		return xl_picture_url;
	}
	public void setXl_picture_url(String xl_picture_url) {
		this.xl_picture_url = xl_picture_url;
	}
}
