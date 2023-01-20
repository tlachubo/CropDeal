package com.cropdeal.farmerservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Crop")
public class Crop {

	private String id;
	private String cropName;
	private String cropType;
	private String cropQuantity;
	private Location location;
	private String uploadedBy;
	private String price;
	
	

	public Crop(String id, String cropName, String cropType, String cropQuantity, Location location,
			String uploadedBy) {
		super();
		this.id = id;
		this.cropName = cropName;
		this.cropType = cropType;
		this.cropQuantity = cropQuantity;
		this.location = location;
		this.uploadedBy = uploadedBy;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public String getCropQuantity() {
		return cropQuantity;
	}

	public void setCropQuantity(String cropQuantity) {
		this.cropQuantity = cropQuantity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}



	@Override
	public String toString() {
		return "Crop [id=" + id + ", cropName=" + cropName + ", cropType=" + cropType + ", cropQuantity=" + cropQuantity
				+ ", location=" + location + ", uploadedBy=" + uploadedBy + "]";
	}
	
	
}

	