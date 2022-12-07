package com.btptrianings.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.btptrianings.demo.entities.Vendor;

@Component
public class VendorService {
	
	// This is like an internal table in Abap which contains multiple records
	HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();
	
	@Autowired
	IVendorPersistence vendor;
	/*
	 * @Autowired Vendor ven1;
	 * 
	 * @Autowired Vendor ven2;
	 * 
	 * @Autowired Vendor ven3;
	 */

	private void fillVendors() {
		
		//append work area to itab.
		//vendors.put("1", ven1);
	//	vendors.put("2", ven2);
		//vendors.put("3", ven3);
		
	}
	
	public void VendorService() {
		
		fillVendors();
	}
	
	public 	List<Vendor> getAllVendors(){
			//fillVendors();
		
		//Spring JPA will fire a select query
		return vendor.findAll();
			//return vendors;
	}
	
	public Optional<Vendor> getVendorByKey(String vendorId) {
		//fillVendors();
		//return vendors.get(vendorId);
		//Select SELECT SINGLE * to the database
		return vendor.findById(vendorId);
	}
	
	public Vendor createVendor(Vendor vendorData) {
		//fillVendors();
		//vendors.put("4", vendor);
		//return vendor;
		return this.vendor.save(vendorData);
	}
	
	public Vendor updateVendor(Vendor vendorObject) {
		//fillVendors();
		//return vendor;
		//Handle the update call
		Optional<Vendor> searchRecords = 	this.vendor.findById(vendorObject.getCode());
		if(!searchRecords.isPresent()) {
			return new Vendor();
		}
		else
		{
			return vendor.save(vendorObject);
		}
	}
	
	public String deleteVendor(String vendorId) {
		//fillVendors();
		//vendors.remove(vendorId);
		vendor.deleteById(vendorId);
		return "Deleted Sucessfully";
	}
	
	public List<Vendor> searchByCompanyName(String companyName){
		return vendor.findByCompanyName(companyName);
	}
	
	public List<Vendor> lookupByFirstName(String FirstName){
		return vendor.lookupByFirstName(FirstName);
	}
}
