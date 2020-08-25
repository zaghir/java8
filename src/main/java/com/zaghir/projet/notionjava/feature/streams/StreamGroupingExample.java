package com.zaghir.projet.notionjava.feature.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.HashMap;
import java.util.stream.Stream;

import com.zaghir.projet.notionjava.dto.Person;
import com.zaghir.projet.notionjava.feature.repo.PersonRepository;

public class StreamGroupingExample {
	
	static void groupByGender() {
		Map<String, List<Person>> groupeData = PersonRepository.getAllPersons()
			.stream()
			.collect(Collectors.groupingBy(Person::getGender));

		groupeData.entrySet().forEach(per -> System.out.println("key : "+per.getKey()+" / value :"+per.getValue()));
		Stream.of(groupeData).forEach(System.out::println);
	}
	
	static void groupByHeight() {
		Map<String , List<Person>> groupeData =  PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.groupingBy(per -> per.getHeight()>= 140 ? "Tallest" :"Sorted")) ;
		Stream.of(groupeData).forEach(System.out::println);
	}

	static void twoLevelGrouping() {
		Map<String , Map<String, List<Person>>> groupeData= PersonRepository.getAllPersons()
		.stream()
		.collect(Collectors.groupingBy(Person::getGender , groupingBy(per -> per.getHeight()>= 140 ? "Tallest" :"Sorted")));
		Stream.of(groupeData).forEach(System.out::println);
	}
	
	static void twoLevelGroupingCount() {
		Map<String , Integer> groupeData= PersonRepository.getAllPersons()
		.stream()
		.collect(Collectors.groupingBy(Person::getName , summingInt(Person::getKids)));
		Stream.of(groupeData).forEach(System.out::println);
	}
	
	static void threeLevelGrouping() {
		Map<String , List<Person>> groupData = PersonRepository.getAllPersons()
				.stream()
				.collect(Collectors.groupingBy(Person::getName , HashMap::new , Collectors.toList())) ;
				Stream.of(groupData).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		//groupByGender();
		//System.out.println("=============================");
		//groupByHeight();
		//System.out.println("=============================");
		twoLevelGrouping();
		System.out.println("=============================");
		twoLevelGroupingCount();
		System.out.println("=============================");
		threeLevelGrouping();

	}
}

/*
 * twoLevelGrouping
{
	 Famele=
		{
			Sorted=[Person(name=Narjis, height=110, salary=200.0, gender=Famele, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null)],
		        Tallest=[Person(name=Sofia, height=146, salary=200.0, gender=Famele, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null)]
		},
	 Male=
		{
			Sorted=[Person(name=Mohamed, height=130, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null)],
			Tallest=[
					Person(name=Nizar, height=170, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null),
				        Person(name=Redoin, height=140, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null),
				        Person(name=Outhman, height=150, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null),
				        Person(name=Nabile, height=170, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null),
				        Person(name=Mario, height=170, salary=200.0, gender=Male, kids=2, hobbies=[Football, Swimming, Cricket, Driving], address=null)]
		}
	}
*/
