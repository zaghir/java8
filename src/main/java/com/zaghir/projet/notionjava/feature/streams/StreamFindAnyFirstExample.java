package com.zaghir.projet.notionjava.feature.streams;

import java.util.Optional;
import java.util.function.Predicate;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamFindAnyFirstExample {
	
	static Predicate<String> p1 = num-> num.length() > 7 ;
	static Predicate<Person> p2 = per -> per.getHeight() >= 140 ;
	static Predicate<Person> p3 = per -> per.getGender().equals("Famele") ;

	public static void main(String[] args) {
		Optional<Person> findAny = findAny() ;
		if(findAny.isPresent()) {
			System.out.println("Find Any Result : "+ findAny.get() );
		}else {
			System.out.println("no record Found");
		}
		Optional<Person> findFirst = findFirst() ;
		if(findAny.isPresent()) {
			System.out.println("Find First Result : "+findFirst.get());
		}else {
			System.out.println("no record Found");
		}
		
	}
	
	static Optional<Person> findAny() {
		return PersonRepository.getAllPersons()
			.stream()
			.filter(p2)
			.findAny();
	}
	
	static Optional<Person> findFirst() {
		return PersonRepository.getAllPersons()
			.stream()
			.filter(p3)
			.findFirst();
	}

}
