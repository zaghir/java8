package com.zaghir.projet.notionjava.feature.default_methods;

import java.util.Arrays;
import java.util.List;

import com.zaghir.projet.notionjava.dto.Person;

public class PersonDetailsImpl implements PersonDetails{

	@Override
	public double calculateTotalSalary(List<Person> personList) {
		return personList.stream().map(Person::getSalary).reduce(0d ,(x,y)-> x+y);
	}
	
	public int totalKids(List<Person> personList) {
		return (10+10) ;
	}
	
	static List<String> personList(List<Person> personList){
		return Arrays.asList("One", "Two");
	}

	
}
