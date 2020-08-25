package com.zaghir.projet.notionjava.feature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamFlatMapExample {

	static List<String> hobbies(List<Person> personList) {
		return personList.stream()
				.map(Person::getHobbies)
				.flatMap(List ::stream)
				.collect(Collectors.toList());
	}
	
	static List<String> distinctHobbies(List<Person> personList) {
		return personList.stream()
				.map(Person::getHobbies)
				.flatMap(List ::stream)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	
	static long countOfHobbies(List<Person> personList) {
		return personList.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.distinct()
				.count();
	}
	
	public static void main(String[] args) {
		List<Integer> oddNumber = Arrays.asList(1,3,5,7);
		List<Integer> evenNumber = Arrays.asList(2,4,6,8);
		
		List<List<Integer>> listOfList = Arrays.asList(oddNumber , evenNumber);
		
		System.out.println("Before Flatten : " + listOfList);
		
		List<Integer> flattenList = listOfList.stream()
				.flatMap(list -> list.stream())  // convert each List<Stream<Integer>> to stream 
				.collect(Collectors.toList());   // collect list and add result to list 
		
		System.out.println("After flaten : "+flattenList);
		
		System.out.println("Hobbies Result with Duplicates : "+hobbies(PersonRepository.getAllPersons()));
		
		System.out.println("Hobbies Result Duplicates : "+distinctHobbies(PersonRepository.getAllPersons()));
		
		System.out.println("Hobbies Count : "+countOfHobbies(PersonRepository.getAllPersons()));		
 	}

}
