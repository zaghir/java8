package com.zaghir.projet.notionjava.feature.paralle_streams;

import java.util.List;
import java.util.stream.Collectors;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class ParallelStreamUseCase {

	public static void main(String[] args) {
		System.out.println(getHobbiesBySeq());
		System.out.println(getHobbiesByParallel());

	}
	
	static List<String> getHobbiesBySeq(){
		long start = System.currentTimeMillis();
		List<String> hobbies =  PersonRepository.getAllPersons()
				.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		System.out.println("Sequential Duration : "+(end-start));
		return hobbies ;
	}

	static List<String> getHobbiesByParallel(){
		long start = System.currentTimeMillis();
		List<String> hobbies =   PersonRepository.getAllPersons()
				.parallelStream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.collect(Collectors.toList());
		long end = System.currentTimeMillis();
		System.out.println("Parallel Duration : "+(end-start));
		return hobbies ;
				
	}
}
