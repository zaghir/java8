package com.zaghir.projet.notionjava.stream;

import static java.util.stream.Collectors.toList;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.zaghir.projet.notionjava.bean.Dish;

public class Stream1 {
	/***
	 * To summarize, the Streams API in Java 8 lets you write code that’s 
	 * * Declarative—More concise and readable 
	 * * Composable—Greater flexibility 
	 * * Parallelizable—Better performance
	 * 
	 * what exactly is a stream? A short definition is “a sequence of elements from a
	 * source that supports data-processing operations.”
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),				
				new Dish("beef", false, 700, Dish.Type.MEAT), 
				new Dish("chicken", false, 400, Dish.Type.MEAT),				
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
		
		List<String> threeHighCaloricDishNames = menu.stream()
				.filter(dish -> dish.getCalories() > 300)
				.map(Dish::getName)
				.limit(3)
				.collect(toList());
		
		System.out.println("threeHighCaloricDishNames ==> " + threeHighCaloricDishNames);
		
		
		List<String> title = Arrays.asList("Modern", "Java", "In", "Action");
		Stream<String> s = title.stream();
		s.forEach(System.out::println);
		
		// s.forEach(System.out::println);
		// on va avoir un message d'erreur apres qui dit que le strean a deja ete eploré ou fermé
		
		List<String> names = menu.stream().map(Dish::getName).collect(toList());
		System.out.println("names ==>"+names );
		
		List<String> noms = menu.stream()
				.filter(dish->{
					System.out.println("----Filtring: ==> "+dish.getName());
					return dish.getCalories()> 300;
				})
				.map(dish -> {
					System.out.println(".......mapping: ==> "+dish.getName());
					return dish.getName();
				})
				.limit(3)
				.collect(toList());
		System.out.println("noms ==> "+noms);	
		
		long count = menu.stream()
				.filter(dish->dish.getCalories() > 300)
				.distinct()
				.limit(3)
				.count();
		System.out.println("count : ==> "+ count);
		
		List<Dish> vegetarianDishs = menu.stream()
				.filter(dish -> dish.isVegetarian())
				.collect(toList());
		System.out.println("vegetarianDishs: ===> " +vegetarianDishs);
		
		
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4 ,5 , 6 ,7 );
		numbers.stream()
			.filter(num -> num % 2 == 0)
			.distinct()
			.forEach(System.out::println);
		
		List<Dish> specialMenu = Arrays.asList(
				new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER));
		specialMenu.stream()
			.filter(dish -> dish.getCalories() > 300)			
			.distinct()
			.limit(3)
			.collect(toList())
			.forEach(dish -> System.out.println(" dish -> "+dish) );
		
		List<Dish> dishes = menu.stream()
				.filter(dish-> dish.getType().equals(Dish.Type.MEAT))
				.limit(2)
				.collect(toList());
		System.out.println("dishes ===> "+ dishes);
		
		List<String> dishNames = menu.stream()
				.map(Dish::getName)
				.collect(toList());
		System.out.println("dishNames: ==> "+dishNames);
		
		List<String> words = Arrays.asList("Moderne","Java","In","Action");
		List<Integer> wordlenghts = words.stream()
				.map(String::length)
				.collect(toList());
		System.out.println("word: ==> "+words+" wordlenghts: ==> "+wordlenghts);
		
		List<Integer> dishNameLengths = menu.stream()				
				.map(Dish::getName)
				.map(String::length)
				.collect(toList());
		System.out.println("dishNameLengths: ==> "+dishNameLengths);
		
		// le resulat n'est pas bon car en veut avoir une list des caractere par un tableau avec la liste des caractere dedans
		words.stream()
			.map(word -> {
				System.out.println(" --> "+word);
				return word.split("");			
			})
			.distinct()
			.collect(toList())
			.forEach(lst -> {
				String acum ="";
				for (String c : lst) {
					acum += c+"-" ;
				}
				System.out.println("wordSplit ==> "+acum);
			});
		
		/**that takes an array and produces a stream **/
		String[] arrayOfWords = {"Goodbye", "World"};
		Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
		
		// on peut dire que avec la methode qui genere un stream a partir d'un tableau peut resoudre le probleme mais ce n'est pas le cas
		words.stream()
			.map(word -> {
				System.out.println(" --> "+word);
				return word.split("");			
			})
			.map(Arrays::stream)
			.distinct()
			.collect(toList())             // je recupere des tableaux encore
			.forEach(System.out::println);  
		
		// la solution c'est d'uliser le flatMap
		words.stream()
			.map(word -> {
				System.out.println(" --> "+word);
				return word.split("");			
			})
			.flatMap(Arrays::stream)    // il applati  chaque stream generer dans un seul stream  on le fusionnant
			.distinct()
			.collect(toList())             // ca fonctionne super le flatMap
			.forEach(str -> System.out.println("wordsSplite with flat map: ==> "+str ));
		
		List<Integer> squareNumber = numbers.stream()
				.map(n -> n * n)
				.collect(toList());
		System.out.println(" number "+numbers+"square "+squareNumber);

		// exercice  given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), 	(3, 3), (3, 4)]
	    List<Integer> numbers1 = Arrays.asList(1,2,3);
	    List<Integer> numbers2 = Arrays.asList(3,4);
	    List<int[]> pairs = numbers1.stream()
	    		.flatMap(i -> numbers2.stream()
	    							.map(j -> new int[] {i ,j}))
	    		.collect(toList());
		System.out.println("pairs flatMap: ==> "+pairs);
		
		//How would you extend the previous example to return only pairs whose sum is divisible by 3?
		pairs = numbers1.stream()
	    		.flatMap(i -> numbers2.stream()
	    							.filter(j -> (i + j) % 3 == 0)
	    							.map(j -> new int[] {i ,j}))
	    		.collect(toList());
		pairs.forEach(table -> {
			System.out.println("table ----");
			for (int value : table) {
				System.out.print("-"+value);
			}
		});
		
		
		// tester avec la condition any
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		}
		
		// allMatch
		boolean isHealty = menu.stream().allMatch(dish -> dish.getCalories() < 1000) ;
		System.out.println("menu is healty: ==> "+isHealty);
		
		// noneMatch
		boolean isNotHealty = menu.stream().noneMatch(dish -> dish.getCalories() >= 1000) ;
		System.out.println("menu is not healty: ==> "+isNotHealty);
		
		// Optional
		Optional<Dish> dish = menu.stream()
				.filter(Dish::isVegetarian)
				.findAny();		
		if(dish.isPresent()) {
			System.out.println("Dish is vegetarian : ==> " +dish);
		}
		
		// findFirst  findAny   les deux peuvent etre utilser mais findFirst est utilisé dans on est dans un traitement parallele
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
				.map(n -> n * n)
				.filter(n -> n % 3 == 0 )
				.findFirst();
		System.out.println(someNumbers+" firstSquareDivisibleByThree: ==> " + firstSquareDivisibleByThree);

		
		// reduce   reduire les données du flux
		int sum = numbers.stream()
				.reduce(0, (a,b) -> a + b );
		// une autre maniere à ecrire 
		//  int sum = numbers.stream().reduce(0, Integer::sum);
		// Optional<Integer> sum = numbers.stream().reduce((a,b) -> a + b ) ;
		int product = numbers.stream()
				.reduce(1 , (a,b) -> a * b );
		System.out.println(numbers+" sum: ==> "+sum+" product: ==> "+product);
		
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		System.out.println("max: ==> "+max);
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		System.out.println("min: ==> "+min);
		// avec l'expression lambda
		Optional<Integer> min2 = numbers.stream().reduce((x, y) -> x<y ?x :y);
		System.out.println("min: ==> "+min);
		
		// How would you count the number of dishes in a stream using the map and reduce methods?
		int countDish = menu.stream()
				.map(d -> 1)
				.reduce(0, Integer::sum);   // or reduce(0 , (a,b) -> a+b);
		System.out.println("countDish: ==> "+countDish);
		// other method
		long countDish2 = menu.stream().count() ;
		System.out.println("countDish2: ==> "+countDish2);
		
		// mapToInt
		int calories1 = menu.stream().map(m -> m.getCalories()).reduce(0, Integer::sum);
		// pour calculer calories1 le compliateur doit passer par un unboxing car la valeur d'entrée du stream c'est un Integer
		// le stream et moins performent s'il passe a faire a chaque fois un Unboxing puis calculer la valeur
		// pour cette raison les Primitive stream specializations  comme mapToInt , mapToFloat , mapToDouble qui sont des stream numerique
		// cette fonction sum n'existe pas mais il y a des interface qui fourni sum max min avarge depuis le stream
		//int calories = menu.stream().map(m -> m.getCalories()).sum();
		int calories = menu.stream().mapToInt(m -> m.getCalories()).sum();
		System.out.println("calories dans le menu: ==> "+calories);
		
		// boxed()
		// convert a stream to a numeric stream
		IntStream instStream = menu.stream().mapToInt(Dish::getCalories);
		// convert a numeric stream to stream
		Stream<Integer> intStreamToStream = instStream.boxed(); // c'est le principe de boxing de int vers un envelope Integer
		
		// le type Optional peut aussi etre paramatrer par des type premitive int double , floot
		// on a dans pour l'operation sum() retourne par defaut la valeur 0 , mais si on veut faire une comparaison 0 peu etre le max
		// c'est le role de Optional parametré , elle permet de renvoyé une valeur par defaut ou pas
		OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
		int max1  = maxCalories.orElse(1);  // retourné 1 par defaut s'il n y a pas de valeurs
		
		// Numerique range 
		// dans java 8 les methodes static range et rangeClosed sont fourni par les deux Stream IntStream et LongStream 
		// ces methodes permetent de fournir un interval entre un nombre min et max
		IntStream evenNumbers = IntStream.rangeClosed(1, 100)
				.filter(n -> n %2 == 0);
		System.out.println("rangeClosed it s inclusife : ==> "+evenNumbers.count());
		
		IntStream evenNumbers2 = IntStream.range(1, 100)
				.filter(n -> n %2 == 0);
		System.out.println("range it s exlusive: ==> "+evenNumbers2.count());
		
		
		// exercice  pytagor
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a ->
					IntStream.rangeClosed(a, 100)
						.filter(b -> Math.sqrt(a* a + b*b) % 1 == 0)
						.mapToObj(b -> new int[] {a ,b , (int)Math.sqrt(a* a + b* b)})
				);
		pythagoreanTriples.limit(5)
			.forEach(t -> System.out.println("pythagoreanTriples: ==> " +t[0]+","+t[1]+","+t[2]));
		
		Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100)
				.boxed()
				.flatMap(a -> 
						IntStream.rangeClosed(a, 100)
							.mapToObj(b -> new double[] {a, b ,Math.sqrt(a*a +b*b)})
							.filter(t-> t[2] % 1 == 0))	;
		
		pythagoreanTriples2.limit(5)
			.forEach(t -> System.out.println("pythagoreanTriples2: ==> " +t[0]+","+t[1]+","+t[2]));
		
		// Stream.empty()
		// creation d'un stream vide 
		Stream<String> emptyStream = Stream.empty();
		
		// creation des stream 
		Stream<String> stream1 = Stream.of("Moder", "Java" , "In", "Action");
		stream1.map(str -> str.toUpperCase()).forEach(str -> System.out.print("->"+str));

		//Stream.ofNullable
		// c'est possible de creer un stream a partir des objets null 
		String homeValue = System.getProperty("home");
		Stream<String> homeValueStream = null == homeValue ?Stream.empty() : Stream.of(homeValue);
		// c'est possibl de l'ecrire avec les fonction java 9 sans passer par le test
		//homeValueStream = Stream.ofNullable(System.getProperty("home"));
		
		//Stream from Arrays
		int[] numbers3 = {2,2,2,2,2,2};
		int sum1 = Arrays.stream(numbers3).sum() ;
		System.out.println("\n sum: ==> "+sum1);
		
		// stream from file
		long uniqueWord = 0 ;
		try(Stream<String> lines = 
				Files.lines(Paths.get("data.txt"),Charset.defaultCharset())) {
			uniqueWord = lines.flatMap(line -> Arrays.stream(line.split(" ")))
					.distinct()
					.count();
			System.out.println("uniqueWord: ==> "+uniqueWord);
		} catch (Exception e) {
			System.out.println("exception : ==> "+e.getMessage());
		}
		
		
		// Stream.interate
		// methode static Stream.interate   Stream.generate
		Stream.iterate(0, n -> n+2)
			.limit(10)
			.forEach(n -> System.out.println("Stream.interate: ==> "+n));
		
		// exercice suite de fibonacci
		Stream.iterate(new int[] {0,1},t-> new int[] {t[1] ,t[0]+t[1]} )
			.limit(10)
			.forEach(t -> System.out.println("( "+t[0]+" , "+t[1]+")"));
		
		// on va creer un stream continue et on ne peut pas l'arrét avec la fonction filter
		//Stream.iterate(0, n -> n + 4 )
		//	.filter(n -> n < 100)
		//	.forEach( a -> System.out.print(a ));
		
		// on peut bloquer le stream par la fonction takeWhile  defini dans Java 9
//		IntStream.iterate(0, n -> n + 4 )
//			.takeWhile(n -> n < 100)
//			.forEach( a -> System.out.print(a ));
		
		// Stream.generate    c'est une methode static qui cree des flux infini
		// Supplier<T>  c'est la methode qui est utilisée dans la methode static  Stream.generate 
		Stream.generate(Math::random)
			.limit(5)
			.forEach(System.out::println);
		
	}

}
