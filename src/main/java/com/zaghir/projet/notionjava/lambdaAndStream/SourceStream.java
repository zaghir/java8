package com.zaghir.projet.notionjava.lambdaAndStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SourceStream {
	public static void main(String args[]){
		Integer tabObj[] = { 10 , 15 , 0 , 4 , 19 , 11 , -15} ;
		System.out.println("-- filtrage des > 0 avec une collection :");
		List<Integer> liste = Arrays.asList(tabObj);
		liste
			.stream()
				.filter( x -> x> 0)
				.forEach( x ->System.out.print(x+" ") );
		
		System.out.println("\n-- filtrage des > 0 avec une collection en parallete");
		liste
			.parallelStream()
				.filter( x -> x> 0) 
				.forEach( x ->System.out.print(x+" "));
		
		System.out.println("\n-- Item  en parallele avec forEachOrdered");
		liste
			.parallelStream()
			.forEachOrdered(x ->System.out.print(x+" "));
		
		System.out.println("\n-- filtre de paires avec une liste de valeus ");
		Stream
			.of(55 ,44 , 87 ,0 , -6 , 41 )
				.filter(x -> 2*(x/2) == x)
				.forEach( x ->System.out.print(x+" "));
		
		System.out.println("\n-- filtrage des >0 avec un tableau ");
		Stream
			.of(tabObj)
				.filter(x -> x> 0)
				.forEach( x ->System.out.print(x+" "));
		
		System.out.println("\n-- avec generation valeurs aliatoire entre 0 et 9  ");
		Stream
			.generate(() -> Math.random() )  // ou ref fonction => Math::random 
				.limit(9)
			.map(x -> (int)(x * 10))
			.forEach( x ->System.out.print(x+" "));
		
		System.out.println("\n-- avec methode itirative   ");
		Stream
			.iterate(100, x -> x+1)
			.limit(10)
			.forEach( x ->System.out.print(x+" "));
	}

}
