package com.btptrianings.demo.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Address {
	
	@Id
	@Column(nullable = false, name = "id" )	
	@GenericGenerator(name = "uuid2", strategy = "uuid2") // to generate uuid randomly automatically
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	private String addressid;
	
	@Column(nullable = false, name = "addressType" )
	private String addressType;
	
	@Column(nullable = true, name = "street" )
	private String street;
	@Column(nullable = true, name = "city" )
	private String city;
	@Column(nullable = true, name = "country" )
	private String country;
	@Column(nullable = true, name = "region" )
	private String region;
	
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Address(String addressid, String addressType, String street, String city, String country, String region) {
		super();
		this.addressid = addressid;
		this.addressType = addressType;
		this.street = street;
		this.city = city;
		this.country = country;
		this.region = region;
	}
	public Address() {
		super();
	}
	
	
	
}
