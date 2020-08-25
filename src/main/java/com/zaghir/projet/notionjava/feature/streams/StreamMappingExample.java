package com.zaghir.projet.notionjava.feature.streams;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.mapping;
import java.util.stream.Collectors;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamMappingExample {
	
	static List<String> mappingName(){
		List<String> names = PersonRepository.getAllPersons()
			.stream()
			.map(Person::getName)
			.collect(Collectors.toList());

		// it s the same resulat by the mapping execute directly in the collector and we ar not using the mapping in the stream
		List<String> names1 = PersonRepository.getAllPersons()
		.stream()
		.collect(mapping(Person::getName ,Collectors.toList()));
		
		return names1;
	}
	
	static Set<String> mappingName1(){
		List<String> names = PersonRepository.getAllPersons()
			.stream()
			.map(Person::getName)
			.collect(Collectors.toList());

		Set<String> names1 = PersonRepository.getAllPersons()
		.stream()
		.collect(mapping(Person::getName ,Collectors.toSet()));
		
		return names1;
	}
	
	static long countTallPersons(){
		return PersonRepository.getAllPersons()
		.stream()
		.filter(per-> per.getHeight() >= 140)
		.collect(Collectors.counting());
	}
	

	public static void main(String[] args) {
		//System.out.println(mappingName());
		//System.out.println(mappingName1());
		System.out.println("Total person count : "+countTallPersons());
	}

}
