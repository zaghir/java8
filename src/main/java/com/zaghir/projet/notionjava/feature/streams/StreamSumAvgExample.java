package com.zaghir.projet.notionjava.feature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamSumAvgExample {

	static int sumTotalKids() {
		return PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.summingInt(Person::getKids)) ;
	}
	
	static double averageHeight() {
		return PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.averagingDouble(Person::getHeight));
	}
	public static void main(String[] args) {
		
		System.out.println("Total kids : "+sumTotalKids());
		System.out.println("Average Height is : "+averageHeight());
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
		int total = intList.stream().collect(Collectors.summingInt(Integer::intValue)) ;
		System.out.println("total : "+total);
 
	}

}
