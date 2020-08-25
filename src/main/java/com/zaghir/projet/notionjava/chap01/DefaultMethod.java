package com.zaghir.projet.notionjava.chap01;


interface Traitement{
	
	
	public default void traitementOne() {
		System.out.println("traitementOne");
	}
	
	public default void traitementTwo() {
		System.out.println("traitementTwo");
	}
	
}

public class DefaultMethod implements Traitement{
	
	public void traitementTwo() {
		System.out.println("new  traitementTwo ");
	}

	public static void main(String... args) {
		
		DefaultMethod def = new DefaultMethod();
		def.traitementOne();
		def.traitementTwo();
	}
}
