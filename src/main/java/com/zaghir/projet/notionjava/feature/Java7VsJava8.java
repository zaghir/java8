package com.zaghir.projet.notionjava.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java7VsJava8 {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Youssef", "Youssef" , "Meriem" , "Yassine", "Zakaria", "Redoin"); 
		
		// Before
		List<String> uniqueList = new ArrayList<String>() ;
		
		for(String name : names) {
			if(!uniqueList.contains(name)) {
				uniqueList.add(name) ;
			}
		}
		
		System.out.println("Unique list 1 : "+uniqueList);
		

		// After
		List<String> uniqueValues = names.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Unique list 2 : "+uniqueValues);
	}
	

}
