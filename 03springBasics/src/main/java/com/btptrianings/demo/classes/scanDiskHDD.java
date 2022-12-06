package com.btptrianings.demo.classes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class scanDiskHDD implements IHardDisk {

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return "Scandisk is reading data at 20k RPM";
	}

	@Override
	public String write() {
		// TODO Auto-generated method stub
		return "Scandisk is reading data at 10k RPM";
	}

}
