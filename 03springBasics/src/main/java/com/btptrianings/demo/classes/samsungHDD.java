package com.btptrianings.demo.classes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary  //defeault object
@Component
public class samsungHDD implements IHardDisk {

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return "Samsung is reading data at 10k RPM";
	} 

	@Override
	public String write() {
		// TODO Auto-generated method stub
		return "Samsung is reading data at 5k RPM";
	}

}
