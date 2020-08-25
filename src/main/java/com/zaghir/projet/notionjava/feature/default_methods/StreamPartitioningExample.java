package com.zaghir.projet.notionjava.feature.default_methods;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamPartitioningExample {

	static Predicate<Person> p1 = per -> per.getHeight() >= 140 ;
	
	static void byHeight() {
		Map<Boolean, List<Person>> map = PersonRepository.getAllPersons()
		.stream()
		.collect(partitioningBy(p1)) ;
		System.out.println("Person Map : "+ map);
	}
	
	static void byHeightWith2Param() {
		Map<Boolean, Set<Person>> map = PersonRepository.getAllPersons()
		.stream()
		.collect(partitioningBy(p1, Collectors.toSet())) ;
		System.out.println("Person Map : "+ map);
	}
	
	static void byHeightWithMap() {
		Map<Boolean, Map<String , List<String>>> map = PersonRepository.getAllPersons()
		.stream()
		.collect(partitioningBy(p1, Collectors.toMap(Person::getName, Person::getHobbies))) ;
		System.out.println("Person Map : "+ map);
	}
	
	public static void main(String[] args) {
		byHeight();
		System.out.println("=======================================");
		byHeightWith2Param();
		System.out.println("=======================================");
		byHeightWithMap();
	}

}

/*
 * byHeight();
 
Person Map : 
{
	false=[
		Person(name=Mohamed, height=130, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null), 
		Person(name=Narjis, height=110, salary=200.0, gender=Famele, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null)], 
	true=[
		Person(name=Nizar, height=170, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null), 
		Person(name=Redoin, height=140, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null), 
		Person(name=Outhman, height=150, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null), 
		Person(name=Sofia, height=146, salary=200.0, gender=Famele, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null), 
		Person(name=Nabile, height=170, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null), 
		Person(name=Mario, height=170, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null)]
}*/