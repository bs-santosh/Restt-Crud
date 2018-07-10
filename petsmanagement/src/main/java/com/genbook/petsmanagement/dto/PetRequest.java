package com.genbook.petsmanagement.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PetRequest {
	private String name;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	private Date dateOfBirth;
	private String ownerFirstName;
	private String ownerLastName;
	private String ownerCity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	public String getOwnerCity() {
		return ownerCity;
	}
	public void setOwnerCity(String ownerCity) {
		this.ownerCity = ownerCity;
	}
}
