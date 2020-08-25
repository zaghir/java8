package com.zaghir.projet.notionjava.collector;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;
import static java.util.Arrays.asList;
//import static java.util.stream.Collectors.filtering;
//import static java.util.stream.Collectors.flatMapping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.zaghir.projet.notionjava.bean.Dish;

public class Collectors {
	
   public static enum CaloricLevel { DIET, NORMAL, FAT } ;
	
	
	public static void main(String args[]) {
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),				
				new Dish("beef", false, 700, Dish.Type.MEAT), 
				new Dish("chicken", false, 400, Dish.Type.MEAT),				
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
		
		// maxBy    minBy
		// Finding maximum and minimum in a stream of values
		// prepare methode to compare objects from the stream
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		// use comparator and give the max calories of dish
		Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
		Optional<Dish> mindstCalorieDish = menu.stream().collect(minBy(dishCaloriesComparator));
		System.out.println("mindst Calorie Dish : ==> "+mindstCalorieDish.get());
		
		//Summarization 
		// .summingInt
		//each dish is mapped into its number of calories, and that number is added to
		// an accumulator starting from an initial value (in this case the value is 0).
		// pas besoin de faire un mapping puis faire la sommme le compilateur fait presque tout 
		// il y a aussi Collectors.summingLong ,  Collectors.summingDouble   Collectors.averagingInt
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println("totalCalories : ==> "+totalCalories);
		
		double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
		System.out.println("avgCalories : ==> "+avgCalories);
		
		// IntSummaryStatistics
		// you can count the elements in the menu and obtain the sum, average,
		// maximum, and minimum of the calories contained in each dish with a single
		// summarizing operation:
		IntSummaryStatistics menuStatistic = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println("menuStatistic : ==> IntSummaryStatistics.sum "+menuStatistic.getSum());
		System.out.println("menuStatistic : ==>                     .min "+menuStatistic.getMin());
		System.out.println("menuStatistic : ==>                     .min "+menuStatistic.getMax());
		System.out.println("menuStatistic : ==>                     .getAverage "+menuStatistic.getAverage());
		 
		
		// Joining Strings
		// The collector returned by the joining factory method concatenates into a single string,
		// all strings resulting from invoking the toString method on each object in the stream.
		// This means you can concatenate the names of all the dishes in the menu as follows:
		String shortMenuJoining = menu.stream()
				.map(Dish::getName).collect(joining(", ")); 
		System.out.println("short menu : ==> "+shortMenuJoining);
		String shortMenuReducing1 = menu.stream()
				.map(Dish::getName).collect(reducing((s1 , s2) -> s1+s2)).get();
		System.out.println("short menu : ==> "+shortMenuReducing1);
		String shortMenuReducing2 = menu.stream()
				.collect( reducing( "", Dish::getName, (s1, s2) -> s1 + s2 ) );
		System.out.println("short menu : ==> "+shortMenuReducing2);
		// la 3 eme methode ne fonctionne pas car reducing a recuper un objet Dish et il faut qu'il retourne un objet Dish pas un string !!
		// String shortMenuReducing3 = menu.stream()
		//		.collect( reducing( (d1, d2) -> d1.getName() + d2.getName() )
		// 		).get();
		
		
		// Note that joining internally makes use of a StringBuilder to append the generated
		// strings into one. Also note that if the Dish class had a toString method returning the
		// dish’s name, you’d obtain the same result without needing to map over the original
		// stream with a function extracting the name from each dish:
		// String shortMenu = menu.stream().collect(joining());
		
		// we’ve explored various --------> collectors that reduce a stream to a single value
		
		
		// Collectors.reducing
		// c'est le reducteur generique des stream , car on a vu avant des cas special fourni par java8
		int totalCaloriesReducing = menu.stream().collect(reducing(0, Dish::getCalories , (i, j) -> i+j));
		System.out.println("totalCaloriesReducing : ==> "+ totalCaloriesReducing);
		int totalCaloriesReducing2 = menu.stream().collect(reducing(0 , Dish::getCalories , Integer::sum));
		System.out.println("totalCaloriesReducing2 : ==> "+totalCaloriesReducing2);
		
		// totalCalories avec un map reduce 
		int totalCaloriesMapReduce = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
		System.out.println("totalCaloriesMapReduce : ==> "+totalCaloriesMapReduce);
		// totalCalories avec maToInt pour eviter le Boxing et avoir plus de performance
		int totalCaloriesMapToInt = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println("totalCaloriesMapToInt : ==> "+totalCaloriesMapToInt);
		
		Optional<Dish> mostCalorieDishReducing = menu.stream()
				.collect(reducing((d1,d2)-> d1.getCalories() > d2.getCalories() ? d1 :d2 ));
		System.out.println("mostCalorieDishReducing : ==> "+mostCalorieDishReducing.get());
		
		
		// ------------ Grouping
		Map<Dish.Type , List<Dish> > dishesByType = menu.stream().collect(groupingBy(Dish::getType));
		System.out.println("dishesByType : ==> "+dishesByType);
		
		Map<CaloricLevel , List<Dish>> dishesByCalorieLevel = menu.stream().collect(
				groupingBy(dish -> { 
					if (dish.getCalories() <=400 ) return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700 ) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				}));
		System.out.println(" dishesByCalorieLevel  grouping : ==> "+dishesByCalorieLevel );
		
		// add condition get dish with calories more than 500
		Map<Dish.Type , List<Dish> > dishesByType500 = menu.stream()
				.filter(dish -> dish.getCalories() > 500)
				.collect(groupingBy(Dish::getType));
		System.out.println("dishesByType500 : ==> "+dishesByType500);
		// on a plus le type FISH dans le resulat  {OTHER=[french fries, pizza], MEAT=[pork, beef]}
		// c'est un probleme pour le resoudre passe par un grouping plus un filtering dans collect
		// filtering ne fonctionne pas dans ma jvn 221
//		Map<Dish.Type , List<Dish> > dishesByType500Correction = menu.stream()
//				.collect(groupingBy(
//							Dish::getType ,
//							filtering(dish -> dish.getCalories() > 500, toList())));
//		System.out.println("dishesByType500 : ==> "+dishesByType500);
		
		// Une autre opption 
		Map<Dish.Type , List<String>> dishNamesByType = 
				menu.stream()
					.collect(groupingBy(Dish::getType ,
							mapping(Dish::getName ,toList())));
		System.out.println("dishNamesByType : ==> "+dishNamesByType);
		//
		
		// Utilisation de flatMap
		Map<String, List<String>> dishTags = new HashMap<>();
		dishTags.put("pork", asList("greasy", "salty"));
		dishTags.put("beef", asList("salty", "roasted"));
		dishTags.put("chicken", asList("fried", "crisp"));
		dishTags.put("french fries", asList("greasy", "fried"));
		dishTags.put("rice", asList("light", "natural"));
		dishTags.put("season fruit", asList("fresh", "natural"));
		dishTags.put("pizza", asList("tasty", "salty"));
		dishTags.put("prawns", asList("tasty", "roasted"));
		dishTags.put("salmon", asList("delicious", "fresh"));
		
//		Map<Dish.Type, Set<String>> dishNamesByType1 =
//				menu.stream()
//					.collect(groupingBy(Dish::getType,
//								flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
//										toSet())));
		
	}

}
