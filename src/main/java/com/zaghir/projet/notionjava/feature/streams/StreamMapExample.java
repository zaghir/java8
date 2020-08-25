package com.zaghir.projet.notionjava.feature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamMapExample {
	
	static List<String> toUpperTransform(List<Person> listOfPersons) {
		return listOfPersons.stream()
				.map(Person::getName)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
	}
	
	static Set<String> toUpperTransformSet(List<Person> listOfPersons) {
		return listOfPersons.stream()
				.map(Person::getName)
				.map(String::toUpperCase)
				.collect(Collectors.toSet());
	}

	public static void main(String[] args) {
		
		List<String> fruits = Arrays.asList("Apple" , "Orange" , "Banana" , "Pineapple");
		
		List<Integer> fruitlength =  fruits.stream()
			.map( String::length)
			.collect(Collectors.toList());
		System.out.println("Length List : "+fruitlength);
		
		fruits.stream()
			.map( String::length)
			.collect(Collectors.toList());
		System.out.println("Length List : "+fruitlength);
		
		System.out.println("TO uppercase Result : "+toUpperTransform(PersonRepository.getAllPersons()));

		System.out.println("TO uppercase Result : "+toUpperTransformSet(PersonRepository.getAllPersons()));
	}

}
