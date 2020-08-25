package com.zaghir.projet.notionjava.feature.optional;

import java.util.Optional;

public class OptionalMethodsExample {

	public static void main(String[] args) {
		Optional<String> ofNullable = Optional.ofNullable("java 8") ;
		System.out.println(ofNullable.isPresent() ? ofNullable.get() : Optional.empty());
	
		Optional<String> of = Optional.of("Angular") ;
		System.out.println(of.isPresent() ? of.get() : Optional.empty());
	
	
	}
	

}
