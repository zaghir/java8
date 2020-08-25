package com.zaghir.projet.notionjava.feature.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class SimpleStreamExample {

	public static void main(String[] args) {

		//create Stream 
		/*Stream<Integer> s1 = Stream.of(1,2,3,4,5,6,7,8,9);		
		s1.forEach( p -> System.out.println(p));

		System.out.println("====================");
		Stream<Integer> s2 = Stream.of(new Integer[] {1,2,3,4,5,6,7,8,9} );
		s2.forEach( p -> System.out.println(p));*/
		
		Predicate<Person> p1 = (per) -> per.getHeight() >= 140 ;
		Predicate<Person> p2 = (per) -> per.getGender().equals("Famele") ;
		
		Map<String ,  List<String>> personMap = PersonRepository
				.getAllPersons() // iterate all persons 
				.stream()        // Stream of persons 
				.filter(p1)
				.filter(p2)
				.collect(Collectors  // convert to map 
						.toMap(Person::getName, Person::getHobbies));
		System.out.println("Person Map : "+personMap);
	
		
		List<String> personHobbies = PersonRepository
				.getAllPersons()           // List of Persons
				.stream()                  // Stream of Persons
				.map(Person :: getHobbies) //Stream<List<String>> 
				.flatMap(List::stream)     // Stream<String>
				.distinct()
				.collect(Collectors.toList()) ;  // Collection to bee returned
		
		
		System.out.println("Person Hobbies List"+ personHobbies);
		
	}

}
