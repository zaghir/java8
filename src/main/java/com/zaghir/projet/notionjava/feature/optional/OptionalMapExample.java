package com.zaghir.projet.notionjava.feature.optional;

import java.util.Optional;

import org.sonarsource.scanner.api.internal.shaded.okhttp.Address;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class OptionalMapExample {

	public static void main(String[] args) {
		optionalMapExample();
		System.out.println("=================");
		optionalFlatMapExample();
		System.out.println("=================");
		optionalMapFilterExample();
		
	}
	
	static void optionalMapExample() {
		Optional<Person> per = PersonRepository.getPersonOptional();
		per.ifPresent(person -> {
			String name = per.map(Person :: getName).orElse("No data found") ;
			System.out.println("Name : "+ name);
			
		});
	}
	
	static void optionalFlatMapExample() {
		Optional<Person> per = PersonRepository.getPersonOptional();
		 if(per.isPresent()) {
			 Optional<Address> add = per.flatMap(Person::getAddress) ;
			 System.out.println("Adress : "+add.get() );
		 }
	}
	
	static void optionalMapFilterExample() {
		Optional<Person> per = PersonRepository.getPersonOptional().filter(person -> person.getHeight() >= 140);
		per.ifPresent(person -> System.out.println(person.getAddress().get()));
	}

}
