package com.btptrianings.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.btptrianings.demo.entities.Vendor;
import com.btptrianings.demo.service.VendorService;

@Component
@RestController
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	@RequestMapping("/vendor")
	public HashMap<String, Vendor> getVendors() {
		return vendorService.getAllVendors();
	}
	
	@RequestMapping("/vendor/{vendorId}")
	public Vendor getSingleVendor(@PathVariable("vendorId") String vendorId) {
		return vendorService.getVendorByKey(vendorId);
	}
	
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myVendorData) {
		return vendorService.createVendor(myVendorData);
		
	}
	// 2 way to define this Odata end point call, one is below and other is above
	@RequestMapping(method=RequestMethod.PUT, value="/vendor")
	public Vendor updateVendor(@RequestBody Vendor myUpdateVendorData) {
		return vendorService.updateVendor(myUpdateVendorData);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/vendor/{vendorId}")
	public void deleteVendor(@PathVariable("vendorId") String vendorId) {
		vendorService.deleteVendor(vendorId);
		
	}
}
