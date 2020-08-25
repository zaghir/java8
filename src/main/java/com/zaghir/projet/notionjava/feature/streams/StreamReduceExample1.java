package com.zaghir.projet.notionjava.feature.streams;

import java.util.Optional;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamReduceExample1 {

	public static void main(String[] args) {
		
		combineNames();
		Optional<Person> tallestPerson = getTallestPerson(); 
		System.out.println("Tallest Person is : "+tallestPerson.get() );

	}

	private static void combineNames() {
		String names = PersonRepository.getAllPersons()
			.stream()
			.map(Person::getName)
			.reduce("" , (a,b) -> a.concat(b));
		System.out.println("Names are : "+names);
	}
	
	static Optional<Person> getTallestPerson() {
		return PersonRepository.getAllPersons()
			.stream()
			.reduce( (x,y)-> x.getHeight() > y.getHeight() ? x : y);
		
	}

}
