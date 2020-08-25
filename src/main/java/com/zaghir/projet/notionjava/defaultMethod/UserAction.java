package com.zaghir.projet.notionjava.defaultMethod;

public interface UserAction {

	public default void get() {

		System.out.println(" get -> data [default]");

	}
	
	public default void update() {
		System.out.println(" update -> data [default]");				
	}
	
	// on ne defini pas l'implementation 
	public void delete();

	public default void show() {
		System.out.println(" show -> data [default]");				
	}
}
