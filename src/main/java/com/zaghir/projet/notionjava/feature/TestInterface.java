package com.zaghir.projet.notionjava.feature;

@FunctionalInterface
public interface TestInterface {

	public void add();
	// this not work because @FunctionalInterface accept one method
	// public void delete();
	
	default String sayHello() {
		return "Hello";
	}
	
	static boolean isTrue() {
		return true ; 
	}
}
