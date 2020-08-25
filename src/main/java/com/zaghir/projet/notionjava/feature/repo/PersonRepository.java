package com.zaghir.projet.notionjava.feature.repo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.zaghir.projet.notionjava.dto.Person;

public class PersonRepository {

	public static List<Person> getAllPersons(){
		
		Person p1 = new Person("Nizar" , 170 , 200 ,"Male" , 2 ,Arrays.asList("Football" , "Swimming" , "Cricket" , "Driving") , null );
		Person p2 = new Person("Mohamed" , 130 , 200 ,"Male" , 2 ,Arrays.asList("Football" , "Swimming" , "Cricket" , "Driving") , null);
		Person p3 = new Person("Redoin" , 140 , 200 ,"Male" , 2 ,Arrays.asList("Football" , "Swimming" , "Cricket" , "Driving") , null);
		Person p4 = new Person("Outhman" , 150 , 200 ,"Male" , 2 ,Arrays.asList("Football" , "Swimming" , "Cricket" , "Driving") , null);
		Person p5 = new Person("Sofia" , 146 , 200 ,"Famele" , 2 ,Arrays.asList("Football" , "Swimming" , "Cricket" , "Driving") , null);
		Person p6 = new Person("Narjis" , 110 , 200 ,"Famele" , 2 ,Arrays.asList("Football" , "Swimming" , "Cricket" , "Driving") , null);
		Person p7 = new Person("Nabile" , 170 , 200 ,"Male" , 2 ,Arrays.asList("Football" , "Swimming" , "Cricket" , "Driving") , null);
		Person p8 = new Person("Mario" , 170 , 200 ,"Male" , 2 ,Arrays.asList("Football" , "Swimming" , "Cricket" , "Driving") , null);
		
		return Arrays.asList(p1 , p2 , p3 , p4 , p5 , p6 , p7 ,p8) ;
	}
	
	public static Person getPerson() {
		return new Person("Nizar" , 170 , 200 ,"Male" , 2 ,Arrays.asList("Football" , "Swimming" , "Cricket" , "Driving") , null);
	}
	public static Optional<Person> getPersonOptional() {
		return Optional.of(getPerson());
	}
}
