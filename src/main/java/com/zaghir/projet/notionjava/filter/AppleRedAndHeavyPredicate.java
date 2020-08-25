package com.zaghir.projet.notionjava.filter;

import com.zaghir.projet.notionjava.bean.Apple;
import com.zaghir.projet.notionjava.bean.Color;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		
		return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
	}

}
