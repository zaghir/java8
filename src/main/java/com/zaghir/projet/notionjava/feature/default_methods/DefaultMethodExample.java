package com.zaghir.projet.notionjava.feature.default_methods;

import java.util.Collections;import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class DefaultMethodExample {

	public static void main(String[] args) {
		List<String> nameList = PersonRepository.getAllPersons()
				.stream()
				.map(Person::getName)
				.collect(Collectors.toList()) ;
		System.out.println("Before Sort -----------");
		nameList.forEach(name -> System.out.println(name));

		Collections.sort(nameList);
		System.out.println("After Sort ------------");
		nameList.forEach(name -> System.out.println(name));
		
		System.out.println("In java 8 ------------");
		System.out.println("Natural Order------------");
		nameList.sort(Comparator.naturalOrder());
		nameList.forEach(name -> System.out.println(name));
		System.out.println("Reverse natural Order------------");
		nameList.sort(Comparator.reverseOrder());
		nameList.forEach(name -> System.out.println(name));
		
	}

}
