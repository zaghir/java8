package com.zaghir.projet.notionjava.feature.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamVsCollectionExample {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Youssef");
		names.add("Yassine");
		names.add("Meriem");
		
		for(String name : names) {
//			System.out.println("Iteration 1  : "+name);
		}
		
		for(String name : names) {
//			System.out.println("Iteration 2  : "+name);
		}
		
		Stream<String> stream = names.stream();
//		stream.forEach(p -> System.out.println("<<< : "+p));
		// we can t used again --> stream has already been operated upon or closed
//		stream.forEach(p -> System.out.println("<<< : "+p));
		
		List<String> personNames = PersonRepository
				.getAllPersons()
				.stream()
				.peek(per -> System.out.println(per.getHobbies())) // see this value of stream
				.map(Person ::getName)
				.peek(System.out::println)
				.collect(Collectors.toList());
	}

}
