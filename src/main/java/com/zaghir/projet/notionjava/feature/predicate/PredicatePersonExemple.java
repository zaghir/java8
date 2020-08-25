package com.zaghir.projet.notionjava.feature.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class PredicatePersonExemple {
	
	static Predicate<Person> p1 = per -> per.getHeight() >= 140 ;
	static Predicate<Person> p2 = per -> per.getGender().equals("Famele") ;
	
	public static void main(String[] args) {
		
		List<Person> personList = PersonRepository.getAllPersons();
		
		personList.stream()
			.filter(p1)
			.collect(Collectors.toList()) ;

		personList.forEach(per-> {
			if(p1.and(p2).test(per)) {
				System.out.println(per);
			}
		});
		
	}

}
