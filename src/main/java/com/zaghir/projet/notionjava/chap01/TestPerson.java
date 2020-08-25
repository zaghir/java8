package com.zaghir.projet.notionjava.chap01;

import static java.util.Comparator.comparing;

import java.util.function.Predicate;

public class TestPerson {
	
	
	
	public static void main(String...args ) {
		
		TriFunction<String , String , String ,Person> p = Person::new;
		Person person = p.apply("Ali","mustapha", "ali.mustaph@gmail.com") ;
		System.out.println("person  = " +person);
	}
	
	
}


