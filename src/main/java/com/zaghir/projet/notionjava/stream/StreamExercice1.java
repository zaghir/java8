package com.zaghir.projet.notionjava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

import com.zaghir.projet.notionjava.bean.Trader;
import com.zaghir.projet.notionjava.bean.Transaction;

public class StreamExercice1 {

	public static void main(String args[]) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));

		// 1 - Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> year2011 = transactions.stream()
				.filter(tr -> tr.getYear() == 2011)
				.sorted(comparing(Transaction::getValue))
				.collect(toList());
		System.out.println("years 2011 : ==> "+year2011);
		
		// 2 What are all the unique cities where the traders work?
		List<String> uniqueCities = transactions.stream()
				.map(tr -> tr.getTrader().getCity())
				.distinct()
				.collect(toList());
		System.out.println("uniqueCities: ==> "+uniqueCities);
		
		// 3 Find all traders from Cambridge and sort them by name.
		List<Trader> traders = transactions.stream()
				.filter(tr -> tr.getTrader().getCity().equals("Cambridge"))
				.map(tr -> tr.getTrader())
				.distinct()
				.sorted(comparing(Trader::getName))
				.collect(toList());
		System.out.println(" Find all traders from Cambridge and sort them by name  : ==> " +traders);

		// 4 Return a string of all traders’ names sorted alphabetically.
		String tradersnames = transactions.stream()
				.map(tr -> tr.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (str1 , str2)-> str1+"-"+str2);
		System.out.println("tradersnames: ==> "+tradersnames);
		// 5 Are any traders based in Milan?
		boolean traderMilan = transactions.stream()				
				.anyMatch(tr->tr.getTrader().getCity().equals("Milan"));
		System.out.println("traderMilan: ==> "+traderMilan);
		
		// 6 Print the values of all transactions from the traders living in Cambridge.
		 transactions.stream()
				.filter(tr-> "Cambridge".equals(tr.getTrader().getCity()))
				.map(tr-> tr.getValue())
				.forEach(System.out::println);
			
		// 7 What’s the highest value of all the transactions?
		 Optional<Integer> highest  = transactions.stream()
				 .map(tr -> tr.getValue())
				 .reduce(Integer::max );
		 System.out.println("highest : => "+highest.get());
	
		 
		 // 8 Find the transaction with the smallest value.
		 Optional<Transaction> smallestTransaction  = transactions.stream()				 
				 .reduce( (x1 ,x2) -> x1.getValue() < x2.getValue() ? x1 :x2 );
		 System.out.println("smallestTransaction : ==> "+smallestTransaction);
		 
		 Optional<Transaction> smallestTransaction2  = transactions.stream()
				 .min(comparing(Transaction::getValue));			 
				 
		 System.out.println("smallestTransaction2 : ==> "+smallestTransaction2);
		 
		  
		 
	}

}
