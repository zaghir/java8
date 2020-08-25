package com.zaghir.projet.notionjava.chap01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dish {

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	
	public enum Type { MEAT, FISH, OTHER } ;
}
