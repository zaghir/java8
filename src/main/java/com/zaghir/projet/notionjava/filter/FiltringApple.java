package com.zaghir.projet.notionjava.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaghir.projet.notionjava.bean.Apple;
import com.zaghir.projet.notionjava.bean.Color;

public class FiltringApple {

	private static Logger logger = LoggerFactory.getLogger(FiltringApple.class);

	public static void main(String[] args) {

		List<Apple> inventory = Arrays.asList(
				new Apple(80, Color.GREEN),
				new Apple(155, Color.GREEN),
				new Apple(120, Color.RED));

		Collections.sort(inventory, new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				if (o1.getWeight() == o2.getWeight()) {
					return 0;
				}
				if (o1.getWeight() > o2.getWeight()) {
					return 1;
				} else {
					return -1;
				}

			}

		});
		
		logger.info("Methode 2 isGreenApple {}" , filterApples(inventory,FiltringApple::isGreenApple));
		logger.info("Methode 2 isRedApple {}" , filterApples(inventory,FiltringApple::isRedApple));
		
		logger.info("Methode 2 isGreenApple  en java-8  ==> {}" ,
				filterApples(inventory , (apple)-> Color.GREEN.equals(apple.getColor())));
		/*You need to iterate through the elements one by one using a foreach
		loop processing them in turn. We call this way of iterating over data external iteration.
		In contrast, using the Streams API, you don’t need to think in terms of loops. The
		data processing happens internally inside the library call this internal iteration*/
		
		logger.info("Methode 2 AppleRedAndHeavyPredicate ==> {}" , filterApples(inventory ,new AppleRedAndHeavyPredicate()));
		
		
		
		int portNumber = 1337;
		Runnable r =() -> System.out.println(portNumber);
		/**
		 * On ne peut pas modifier la variable local portNumber car elle est capturé par la fonction lambda
		 * la fonction labda est executé dans le heap de la memoire 
		 * la variable local est enregisté dans le stak(pile) de la memoire
		 * le programme peut acceder directement à la stak mais pas au heap
		 * pour qu'il accede il a besoin d'un pointeur defini dans la stak qui pointe vers les addrese memoire dans le heap   
		 * 97
		 * */
		//portNumber = 222 ;
		
		/// methode reference 
		List<String> str =Arrays.asList("a","b","A","B","C");
		str.sort((s1 , s2) -> s1.compareToIgnoreCase(s2));
		logger.info("compareToIgnoreCase ==> {}" ,str);
		str.sort(String::compareToIgnoreCase);
		
		ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
		ToIntFunction<String> stringToIntMethodref = Integer::parseInt;
		
		BiPredicate<List<String>, String> contains = (list , element) -> list.contains(element);
		BiPredicate<List<String>, String> containsMethodRef = List::contains;
		
		//Predicate<String> startsWithNumber = (String string) -> this.startsWithNumber(string);
		
		

	}

	///==================== 1 ere methode ==================== 
	/// filter the green apples
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> list = new ArrayList();
		for (Apple apple : inventory) {
			if(Color.GREEN.equals(apple.getColor())) {
				list.add(apple);
			}
		}
		return list ;
	}

	/// heavy apples (say over 150 g),
	public static List<Apple> heavyApple(List<Apple> inventory){
		List<Apple> list = new ArrayList();
		for (Apple apple : inventory) {
			if(apple.getWeight()> 150) {
				list.add(apple);
			}
		}
		return list ;
	}
	
//	==================== 2 eme methode ====================
	public static boolean isGreenApple(Apple apple) {
		return Color.GREEN.equals(apple.getColor());
	}
	public static boolean isRedApple(Apple apple) {
		return Color.RED.equals(apple.getColor());		
	}
	
	// predicat de rechereche
//	public static List<Apple> filterApples(List<Apple> inventory, Predicat<Apple> p){
//		List<Apple> list = new ArrayList();
//		for(Apple apple: inventory) {
//			if(p.test(apple)) {
//				list.add(apple);
//			}
//		}
//		return list ;
//	}
	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
		List<Apple> list = new ArrayList();
		for(Apple apple: inventory) {
			if(p.test(apple)) {
				list.add(apple);
			}
		}
		return list ;
	}
	
	
	// filter generic
	public static <T> List<T> filter(List<T> list , Predicate<T> p){
		List<T> result = new ArrayList();
		for(T e:list) {
			if(p.test(e)) {
				result.add(e);
			}				
		}
		return result;
	}
	
	public static void executorService() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> threadName = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return Thread.currentThread().getName();
			}
		});
	}
	
	
	
	
}
