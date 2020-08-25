package com.zaghir.projet.notionjava.feature.optional;

import java.util.Optional;

public class OptionalPresentExample {

	public static void main(String[] args) {

		Optional<String> ofNullable = Optional.ofNullable("Java 8 ");
		System.out.println(ofNullable.isPresent() ? ofNullable.get() : ofNullable.empty());
		
		ofNullable.ifPresent(s -> System.out.println(s));

	}

}
