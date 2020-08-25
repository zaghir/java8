package com.zaghir.projet.notionjava.feature.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamMinMaxByExample {

	static Optional<Person> getTallestPerson() {
		return PersonRepository.getAllPersons()
			.stream()
			.collect(Collectors.maxBy(Comparator.comparing(Person:: getHeight))) ;
	}
	
	static Optional<Person> getShortestPerson() {
		return PersonRepository.getAllPersons()
			.stream()
			.collect(Collectors.minBy(Comparator.comparing(Person:: getHeight))) ;
	}
	
	static List<Person> filterMultiplePersons(){
		List<Person> personList = new ArrayList<Person>();
		Optional<Person> maxHeight = getTallestPerson();
		Person per = maxHeight.isPresent()? maxHeight.get() : null ;
		if(null != per) { 
			personList= PersonRepository.getAllPersons()
				.stream()
				.filter(person -> person.getHeight() == per.getHeight())  // return all person how has the same Height
				.collect(Collectors.toList());
		}
		return personList;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Tallest Person : "+getTallestPerson());
		System.out.println("Shortest Person : "+getShortestPerson());
		System.out.println("Tallest Group : "+filterMultiplePersons());
	}

}
