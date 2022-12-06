package com.btptrianings.demo.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.btptrianings.demo.entities.Vendor;

@Component
public class VendorService {
	
	// This is like an internal table in Abap which contains multiple records
	HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();
	
	@Autowired
	Vendor ven1;
	
	@Autowired
	Vendor ven2;
	
	@Autowired
	Vendor ven3;
	

	private void fillVendors() {
		
		//append work area to itab.
		vendors.put("1", ven1);
		vendors.put("2", ven2);
		vendors.put("3", ven3);
		
	}
	
	public void VendorService() {
		
		fillVendors();
	}
	
	public 	HashMap<String, Vendor> getAllVendors(){
			fillVendors();
			return vendors;
	}
	
	public Vendor getVendorByKey(String vendorId) {
		fillVendors();
		return vendors.get(vendorId);
	}
	
	public Vendor createVendor(Vendor vendor) {
		fillVendors();
		vendors.put("4", vendor);
		return vendor;
	}
	
	public Vendor updateVendor(Vendor vendor) {
		fillVendors();
		return vendor;
	}
	
	public void deleteVendor(String vendorId) {
		fillVendors();
		vendors.remove(vendorId);
	}
}
