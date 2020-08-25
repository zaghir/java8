package com.zaghir.projet.notionjava.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class GenericsRunner {

	static <X> X doubleValue(X value) {
		return value ;
	}
	
	// on cree une fonctionne generique
	// pour typer X il  faut definir le type avant le nom de la methode 
	// ici en limite le type X au type list 
	static <X extends List>  void duplicate(X list) {
		list.addAll(list);
	}
	
	// dans cette methode on accepte que les liste de type number (int double , flot)
	// cette technique s'appel upper bound   ou la limite superieure
	static double sumOfNumberList(List< ? extends Number> numbers) {
		double sum = 0.0;
		for(Number number: numbers) {
			sum += number.doubleValue();
		}
		return sum;
	}
	
	// lower bound  ou la borne inférieure
	// Cette écriture désigne tous les types dont le type T est un type dérivé
	// on peut ajouter à la liste toutes les valeurs avec les type qui derive de Numbers
	static void addCoupleOfValue(List< ? super Number> numbers) {
		numbers.add(1);
		numbers.add(1.2);
		numbers.add(2l);
	}
	
	public static void main(String[] args) {		
		
		MyCustomList<String> list1 = new MyCustomList();
		list1.addElement("element 1");
		list1.addElement("element 2 ");
		System.out.println(list1);
		
		String value1 = list1.get(0);
		System.out.println(value1);
		
		MyCustomList<Integer> list2 = new MyCustomList();
		list2.addElement(Integer.valueOf(5));
		list2.addElement(Integer.valueOf(7));
		
		System.out.println(list2);
		
		Integer number = list2.get(0);
		System.out.println(number);

		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3));
		duplicate(numbers);
		System.out.println(numbers);
		LinkedList<Integer> numbersLink = new LinkedList<>(Arrays.asList(4,5,6));
		duplicate(numbersLink);
		System.out.println(numbersLink);
		
		System.out.println("sumOfNumberList ==> "+sumOfNumberList(Arrays.asList(1, 2, 3, 4, 5, 6)));
		System.out.println("sumOfNumberList ==> "+sumOfNumberList(Arrays.asList(1.2, 2.4, 3.6, 4.8, 5.2, 6.4)));
		System.out.println("sumOfNumberList ==> "+sumOfNumberList(Arrays.asList(1l, 2l, 3l, 4l, 5l, 6l)));
		
		List nums = new ArrayList<Number>();
		addCoupleOfValue(nums);
		System.out.println("addCoupleOfValue ==> "+nums.toString());
	} 

}
