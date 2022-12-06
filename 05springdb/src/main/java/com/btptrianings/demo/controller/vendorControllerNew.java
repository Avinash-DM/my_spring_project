package com.btptrianings.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.btptrianings.demo.entities.Vendor;

@RepositoryRestResource(collectionResourceRel="vendor", path="newVendor") //param 1: database vendor name, param 2: serves a path called newvendor
public interface vendorControllerNew extends JpaRepository<Vendor, String> {

	
	
}
