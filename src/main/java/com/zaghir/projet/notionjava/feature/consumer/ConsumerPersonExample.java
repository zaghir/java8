package com.zaghir.projet.notionjava.feature.consumer;

import java.util.List;
import java.util.function.Consumer;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class ConsumerPersonExample {
	
	static Consumer<Person> c1 = (p)-> {System.out.println(p);} ;
	static Consumer<Person> c2 = (p)-> System.out.println(p.getName().toUpperCase()) ;
	static Consumer<Person> c3 = (p)-> System.out.println(p.getHobbies()) ;

	static List<Person> personList = PersonRepository.getAllPersons() ;
	
	static void printNameAndHobbies() {

		personList.forEach(c1.andThen(c2));
	}
	
	static void printWithCondition() {
		personList.forEach(p -> {  // iterate student
			if(p.getGender().equals("Famele") && p.getHeight() >= 140 ) {
				c2.andThen(c3).accept(p);
			}
		});
	}
	
	public static void main(String[] args) {
		
//		List<Person> personList = PersonRepository.getAllPersons() ;
		
		c1.accept(PersonRepository.getPerson());
		c2.accept(PersonRepository.getPerson());
		c3.accept(PersonRepository.getPerson());
		
		
		System.out.println("==================================================");		
		c1.andThen(c2).andThen(c3).accept(PersonRepository.getPerson());
		
		
		System.out.println("==================================================");
		printNameAndHobbies();
		
		System.out.println("==================================================");
		printWithCondition();
		
	}

}
