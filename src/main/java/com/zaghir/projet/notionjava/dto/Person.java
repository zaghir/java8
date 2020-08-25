package com.zaghir.projet.notionjava.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sonarsource.scanner.api.internal.shaded.okhttp.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	private String name ;
	private int height ;
	private double salary ;
	private String gender ;
	private int kids ;
	List<String> hobbies = new ArrayList<>() ;
	private Optional<Address> address ;
	
}
