package com.zaghir.projet.notionjava.chap01;

import java.util.Arrays;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class TransactionTest {

	public static void main(String... args) {
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
		
		//Find all transactions in the year 2011 and sort them by value (small to high)
		transactions
			.stream()
			.filter(tr -> tr.getYear() == 2011)
			.sorted(comparing(Transaction::getValue))
			.collect(toList());
		
		// What are all the unique cities where the traders work
		transactions
			.stream()
			.map(tr -> tr.getTrader().getCity())
			.distinct() 
			.collect(toList());
		
		// Finds all traders from Cambridge and sort them by name
		transactions
			.stream()
			.map(tr -> tr.getTrader())
			.filter(tra -> tra.getCity().equals("Cambridge"))
			.distinct()
			.sorted(comparing(Trader::getName))
			.collect(toList());
		// Returns a string of all traders’ names sorted alphabetically 
		String traderStr =
		transactions
			.stream()
			.map(tr -> tr.getTrader().getName())
			.distinct()
			.sorted()
			.reduce("", (n1, n2) -> n1+n2);
		System.out.println("traderStr " +traderStr);
		
		// what’s the highest value of all the transactions
		transactions
			.stream()
			.map( tr -> tr.getValue())
			.reduce(Integer::max) ;
		
		// Finds the transaction with the smallest value
		transactions
			.stream()
			.map( tr -> tr.getValue())
			.reduce((v1,v2) -> v1< v2 ? v1 : v2) ;
		transactions
			.stream()
			.min(comparing(Transaction::getValue));

	}

}
