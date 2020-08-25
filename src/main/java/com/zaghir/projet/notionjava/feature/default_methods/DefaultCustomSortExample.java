package com.zaghir.projet.notionjava.feature.default_methods;

import java.util.Comparator;
import java.util.List;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class DefaultCustomSortExample {

	static Comparator<Person> c1 = Comparator.comparing(Person::getName) ;
	static Comparator<Person> c2 = Comparator.comparingDouble(Person::getHeight);
	
	
	public static void main(String[] args) {
		List<Person> listOfPersons = PersonRepository.getAllPersons();
		//sortByName(listOfPersons);
		//sortByHeight(listOfPersons) ;
		sortByNameWithNull(listOfPersons);
		sortByNameWithNullLast(listOfPersons);
	}
	
	static void sortByName(List<Person> listOfPersons) {
		listOfPersons.sort(Comparator.comparing(Person::getName));
		listOfPersons.forEach(per->System.out.println(per));
	}
	
	static void sortByHeight(List<Person> listOfPersons) {
		listOfPersons.sort(c2);
		listOfPersons.forEach(per->System.out.println(per));
	}
	
	static void sortByHeightAndName(List<Person> listOfPersons) {
		listOfPersons.sort(c1.thenComparing(c2));
		listOfPersons.forEach(per->System.out.println(per));
	}
	
	static void sortByNameWithNull(List<Person> listOfPersons) {
		Comparator<Person> nullComparator = Comparator.nullsFirst(c1); // show null value in the first value
		listOfPersons.sort(nullComparator) ;
		listOfPersons.forEach(per->System.out.println(per));
	}
	
	static void sortByNameWithNullLast(List<Person> listOfPersons) {
		Comparator<Person> nullComparator = Comparator.nullsLast(c1); // show null value in the first value
		listOfPersons.sort(nullComparator) ;
		listOfPersons.forEach(per->System.out.println(per));
	}
	

}
