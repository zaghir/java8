
package com.zaghir.projet.notionjava.feature.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class BiFunctionExample {

	static Predicate<Person> p1 = per -> per.getHeight() >= 140 ;
	static Predicate<Person> p2 = per -> per.getGender().equals("Male") ;

	
	static BiFunction<String, String, String> bf1 = (a,b) -> (a+" "+b ) ;
	
	static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> bf2 = (listOfPersons ,predicate) -> {
		Map<String, Double> map = new HashMap<String, Double>();
		listOfPersons.forEach(per -> {
			if(p1.and(predicate).test(per)) {
				map.put(per.getName(), per.getSalary());
			}
		});
		return map ;
	};
	
	public static void main(String[] args) {
		
//		System.out.println(bf1.apply("java", "feature"));
		
		List<Person> personLis = PersonRepository.getAllPersons();
		Map<String, Double> map = bf2.apply(personLis, p2);
		System.out.println("Result : "+map);		

	}

}
