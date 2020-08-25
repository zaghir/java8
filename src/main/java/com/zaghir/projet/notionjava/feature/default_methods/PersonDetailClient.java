package com.zaghir.projet.notionjava.feature.default_methods;

import java.util.List;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class PersonDetailClient {

	static List<Person> listOfPersons = PersonRepository.getAllPersons();
	public static void main(String[] args) {
		
		PersonDetails pd = new PersonDetailsImpl();
		System.out.println("Total Salary : " + pd.calculateTotalSalary(listOfPersons));
		System.out.println("Total Kids Count : " + pd.totalKids(listOfPersons));
		PersonDetails.peronNames(listOfPersons).forEach(System.out::println);
		
	}

}
