package com.zaghir.projet.notionjava.filter;

import java.util.function.Function;

public class Letter {

	public static String addHeader(String text) {
		return "From Raoul, Mario and Alan: " + text;
	}

	public static String addFooter(String text) {
		return text + " Kind regards";
	}

	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}
	
	public static void main(String args[]) {
		Function<String , String > addheader = Letter::addHeader;
		Function<String ,String > transformationPipeline = addheader.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);
		System.out.println("transformationPipeline ==> " +transformationPipeline.apply("Youssef"));
	}
}
