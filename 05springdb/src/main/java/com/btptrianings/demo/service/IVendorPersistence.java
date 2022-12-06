package com.btptrianings.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.btptrianings.demo.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, String> { // string is a type of primary key

	//you can add your own method in ur interface like below
	List<Vendor> findByCompanyName(String companyName);
	
	//writing a custom query like finding pattern present in value etc..
	@Query(nativeQuery = true, value ="SELECT * FROM public.vendor where lower(first_name) like %?1% " )
	List <Vendor> lookupByFirstName(String firstName);
	
}
