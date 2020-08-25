package com.zaghir.projet.notionjava.feature.optional;

import java.util.Optional;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

//Optional 
//Optional is a container object used to contain not-null object 
//Used to represent null with absent value 
//Has various utility methods to facilitate code to handle values as 'available' or 'not available' insteand of checking null values 
//Null checks are not required and no more NPE at run-time 
//No more boiler plate code 

public class OptionalExample {

	public static void main(String[] args) {
		System.out.println("Result : "+myName("Reda"));

		System.out.println(Optional.ofNullable(myName("Reda")));
		
		System.out.println(Optional.ofNullable(myName(null)));
		
		Optional<String> name = Optional.ofNullable("Redoin") ;
		//String name1 = Optional.ofNullable("Redoin").get() ;
		
		System.out.println(name.isPresent() ? name.get() :"No Data Found" );
		
		System.out.println("=======================================");
		System.out.println("Person Name : "+ personName(new Person()));
		
		Optional<String> personName = personNameWithOptional(PersonRepository.getPersonOptional());
		System.out.println("The Optional Person name is : "+personName.get());
	}
	
	static String myName(String name) {
		return name;
	}
	
	static String personName(Person per) {
		if(per != null) {
			return per.getName() ;
		}else {
			return "No data Found";
		}
	}
	
	static Optional<String> personNameWithOptional(Optional<Person> per){
		if(null != per) {
			return per.map(Person::getName) ;
		}else {
			return Optional.empty() ;
		}
	}

}
