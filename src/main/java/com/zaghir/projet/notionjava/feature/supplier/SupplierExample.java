package com.zaghir.projet.notionjava.feature.supplier;

import java.util.List;
import java.util.function.Supplier;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class SupplierExample {

	static Supplier<Person> s1 = () -> PersonRepository.getPerson();
	static Supplier<List<Person>> s2 = () -> PersonRepository.getAllPersons();
	
	public static void main(String[] args) {

		System.out.println("Result  : " +s1.get());
		System.out.println("Result List persons : " +s2.get());
	}

}
