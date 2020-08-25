package com.zaghir.projet.notionjava.feature.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamJoiningExample {
	
	static String joiningExample() {
		String s = PersonRepository.getAllPersons()
				.stream()
				.map(Person::getName)
				.collect(Collectors.joining("-" ,"[","]"));
		return s ;
	}

	public static void main(String[] args) {
		char[] ch = {'a','b','c','d','e','f'};
		String join =Stream.of(ch)
				.map(arr -> new String(arr))
				.collect(Collectors.joining());
		System.out.println("Joined Data : "+ join);
		System.out.println("Joining Ountput : "+joiningExample() );
		
		

	}

}
