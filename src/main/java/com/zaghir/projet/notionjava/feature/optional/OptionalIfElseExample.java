package com.zaghir.projet.notionjava.feature.optional;

import java.util.Optional;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class OptionalIfElseExample {

	public static void main(String[] args) {
		orElse();
		orElseGet();
		orElseThrow();

	}
	
	static void orElse(){
		Optional<Person> person = PersonRepository.getPersonOptional();
		//String name  = person.isPresent() ? person.get().getName() : "Data Not Found";
		
		String name = person.map(Person::getName).orElse("Data Not Found") ;
		System.out.println("OrElse Person Name : " +name);
	}
	
	static void orElseGet(){
		Optional<Person> person = PersonRepository.getPersonOptional();
		String name = person.map(Person::getName).orElseGet(()->  {
			// to send a notification 
			// initiate any script
			return "Data Not Found" ;
		}) ;
		System.out.println("OrElse Get Person Name : " +name);
	}
	
	static void orElseThrow(){
		Optional<Person> person = PersonRepository.getPersonOptional();
		String name = person.map(Person::getName).orElseThrow(()->  new RuntimeException("name not foun")) ;
		System.out.println("OrElse Throw Person Name : " +name);
	}

}
