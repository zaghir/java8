package com.zaghir.projet.notionjava.defaultMethod;

public interface ProfilAction {
	
	public default void show() {
		System.out.println(" show --> profile [default] ");
	}

}
