package com.zaghir.projet.notionjava.feature.methodref;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class MethodReferenceExample1 {

	static Function<String , String > f1 = name -> name.toUpperCase();
	static Function<String , String > f2 = String::toUpperCase;
	
	static Predicate<Person> p1 = per -> per.getHeight() >= 140 ;
	static Predicate<Person> p2 = MethodReferenceExample1 :: heightCheck ;
	static BiPredicate<Person , Integer> p3 = MethodReferenceExample1 :: heightCheckWithParam ;
	
	public static void main(String[] args) {
		System.out.println("Lambda Expression Result : "+f1.apply("java8"));
		System.out.println("Method Reference  Result : "+f2.apply("java8"));
		
		System.out.println("Predicate 1  Result : "+p1.test(PersonRepository.getPerson()));
		System.out.println("Predicate 2  Result : "+p2.test(PersonRepository.getPerson()));
		System.out.println("Predicate 3  Result : "+p3.test(PersonRepository.getPerson() , 130));

	}
	
	static boolean heightCheck(Person per) {
		return per.getHeight() >=140 ;
	}
	
	static boolean heightCheckWithParam(Person per , Integer height) {
		return per.getHeight() >=height ;
	}

}
