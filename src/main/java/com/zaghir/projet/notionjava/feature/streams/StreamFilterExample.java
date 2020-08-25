package com.zaghir.projet.notionjava.feature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamFilterExample {
	
	static Predicate<Person> p1 = per -> per.getHeight() >= 140 ;
	static Predicate<Person> p2 = per -> per.getGender().equals("Male") ;

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Youssef" , "Yassine" , "Meriem" , "Redoine", "Smail" , "Ali");
		
		Stream<String> allNames = names.stream();
		
		Stream<String> updatesList = allNames.filter(s -> s.length() > 3 ) ;
		
		updatesList.forEach(System.out::println);
		
		// enhanced 
		names.stream()
			.filter(s-> s.length() > 3 )
			.collect(Collectors.toList())
			.forEach(System.out::println);

		// enhanced
		PersonRepository.getAllPersons()
			.stream()
			.filter(p1.and(p2))
			.collect(Collectors.toList())
			.forEach(System.out::println );
		
		
		
	}

}