package com.zaghir.projet.notionjava.chap01;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import static java.util.Arrays.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.zaghir.projet.notionjava.collector.Collectors.CaloricLevel;

public class DishTest {

	public static void main(String[] args) {
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
		
		List<String> title = Arrays.asList("Modern", "Java", "In", "Action");
		Stream<String> s = title.stream();
		s.forEach(System.out::println);
		// this generated an Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
		// s.forEach(System.out::println);
		
		List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
		List<Integer> wordLengths = words.stream()
				.map(String::length)
				.collect(toList());
		
		System.out.println("wordLengths ==> " +wordLengths  );
		
		List<String> words2 = 
				words.stream()
					.map(word -> word.split(""))
					.flatMap(Arrays::stream)
					.distinct()
					.collect(toList());
		
		System.out.println("wordLengths ==> " +words2  );
		
		
		String[] arrayOfWords = {"Goodbye", "World"};
		Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); 
		List<Integer> squareNumbers = numbers
				.stream()
				.map(num -> num * num) 
				.collect(toList()) ;
		System.out.println("squareNumbers "+ squareNumbers );
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		
		numbers1
			.stream()
			.flatMap(n1-> numbers2.stream().map(n2-> new int[]{n1 , n2}))
			.collect(toList())
			.forEach(numbs -> {
				System.out.print("( ");
				for (Integer n : numbs) {
					System.out.print(n + " ");
				}
				System.out.println(")");
			});
		
		System.out.println("Modulo 3 ------------- ");
		numbers1
			.stream()
			.flatMap(n1-> numbers2
				.stream()
				.filter(n2-> (n1+n2) % 3  == 0)
				.map(n2-> new int[]{n1 , n2}))
		.collect(toList())
		.forEach(numbs -> {
			System.out.print("( ");
			for (Integer n : numbs) {
				System.out.print(n + " ");
			}
			System.out.println(")");
		});
		
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
			}
		
		Optional<Dish> dish = menu
				.stream()
				.filter(Dish::isVegetarian)
				.findAny() ;
		System.out.println("dish isVegetarian = "+ dish);
		
		menu
			.stream()
			.filter(Dish::isVegetarian)
			.findAny()
			.ifPresent(d -> System.out.println("dish ifPresent = "+d.getName()));
		
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		someNumbers
			.stream().map(n -> n * n )
			.filter(num -> num % 3 == 0)
			.findFirst()
			.ifPresent(sfdbt -> System.out.println("firstSquareDivisibleByThree = "+sfdbt));
		
		Optional<Integer> sum = someNumbers.stream().reduce( Integer::sum ) ;
		int product = someNumbers.stream().reduce(1 , (a ,b) -> a * b ) ;
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		
		// count dish with map and reduce
		System.out.println("number of dish "+ 
		menu
			.stream()
			.map(d -> 1)
			.reduce(0 , (a, b) -> a+b));
		
		int calories = menu.stream()
				.map(Dish::getCalories)
				.reduce(0, Integer::sum) ;
		
		// Converts a Stream to a numeric stream
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		// Converts the numeric stream to a Stream
		Stream<Integer> stream = intStream.boxed();
		
		OptionalInt maxCalories = menu.stream()
				.mapToInt(Dish::getCalories)
				.max();
		
		// Provides an explicit default maximum if there’s no value
		int max2 = maxCalories.orElse(1);
		
		IntStream evenNumbers = IntStream
				.rangeClosed(1, 100)
				.filter(n -> n % 2 == 0);
		System.out.println(evenNumbers.count());
		
		// Streams from values
		Stream<String> stream2 = Stream.of("Modern ", "Java ", "In ", "Action");
		stream2
			.map(String::toUpperCase)
			.forEach(System.out::println);
		
		Stream<String> emptyStream = Stream.empty();
		
		// Streams from arrays
		int[] numbers3 = {2, 3, 5, 7, 11, 13};
		int sum3 = Arrays.stream(numbers3).sum();
		
		// Fibonacci tuples series
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]})
			.limit(20)
			.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
		
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCalorieDish = menu
				.stream()
				.collect(maxBy(dishCaloriesComparator));
		
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		
		double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
		
		IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println("menuStatistics  ==> " +menuStatistics);
		
		String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
		System.out.println("shortMenu  ==> "+ shortMenu );
		
		Map<Dish.Type, List<Dish>> dishesByType =
				menu.stream().collect(groupingBy(Dish::getType));
		System.out.println("dishesByType  ==> "+ dishesByType );
		
		Map<Dish.Type, List<Dish>> caloricDishesByType =
				menu.stream()
				.filter(dish0 -> dish0.getCalories() > 500)
				.collect(groupingBy(Dish::getType));
		System.out.println("caloricDishesByType  ==> "+caloricDishesByType);
		
		// fixe problem of dish type of  FISH
//		Map<Dish.Type, List<Dish>> caloricDishesByType =
//				menu.stream()
//				.collect(groupingBy(Dish::getType,
//				filtering(dish -> dish.getCalories() > 500, toList())));
		
		Map<Dish.Type, List<String>> dishNamesByType =
				menu.stream()
				.collect(
						groupingBy(
								Dish::getType,
								mapping(Dish::getName, toList())));
		
		Map<String, List<String>> dishTags = new HashMap();
		dishTags.put("pork", asList("greasy", "salty"));
		dishTags.put("beef", asList("salty", "roasted"));
		dishTags.put("chicken", asList("fried", "crisp"));
		dishTags.put("french fries", asList("greasy", "fried"));
		dishTags.put("rice", asList("light", "natural"));
		dishTags.put("season fruit", asList("fresh", "natural"));
		dishTags.put("pizza", asList("tasty", "salty"));
		dishTags.put("prawns", asList("tasty", "roasted"));
		dishTags.put("salmon", asList("delicious", "fresh"));
		
//		Map<Dish.Type, Set<String>> dishNamesByType =
//				menu.stream()
//				.collect(groupingBy(Dish::getType,
//						flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
//								toSet())));
		
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
				menu.stream().collect(
						groupingBy(
								Dish::getType,
								groupingBy(dish3 -> {
									if (dish3.getCalories() <= 400) return CaloricLevel.DIET;
									else if (dish3.getCalories() <= 700) return CaloricLevel.NORMAL;
									else return CaloricLevel.FAT;
								} )
						)
				);
		System.out.println("dishesByTypeCaloricLevel  ==> " +dishesByTypeCaloricLevel);
		
		// parallelSum 
		System.out.println("parallelSum  ==> "+ parallelSum(2)); 
		
	}
	
	public static  long parallelSum(long n) {
		return Stream
				.iterate(1L, i -> i + 1)
				.limit(n)
				.parallel()
				.reduce(0L, Long::sum);
	}

}
