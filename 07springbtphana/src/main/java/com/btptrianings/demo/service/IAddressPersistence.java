package com.btptrianings.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btptrianings.demo.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, String >{

	
}
