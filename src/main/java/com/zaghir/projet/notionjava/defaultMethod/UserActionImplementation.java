package com.zaghir.projet.notionjava.defaultMethod;

public class UserActionImplementation implements UserAction , ProfilAction{

	@Override
	public void delete() {
		System.out.println("detete --> data");
		
	}
	
	// on peut redefinir le comportement de la methode get defini dans l'interface 
	public void get() {
		System.out.println("get --> data");
	}
	
	
	// on va utiliser la methode update defini dans l'interface 
    
	
	// pour resourde le probleme d'heritage en diaman qui consiste ici d' avoir la methode show() dans deux interface differentes
	// et de specifier quelle methode utilisé par l'operateur super
	// je choisi la methode de profile
	public void show() {
		ProfilAction.super.show();
	}

}
