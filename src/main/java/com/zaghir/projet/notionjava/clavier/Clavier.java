package com.zaghir.projet.notionjava.clavier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Clavier {
	
	public static String lireString(){ // l'ecture d une chaine
		String ligneLue = null ;
		InputStreamReader lecteur = new InputStreamReader(System.in);
		BufferedReader entree = new BufferedReader(lecteur);
		try {
			ligneLue = entree.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return ligneLue ;
	}
	
	public static float lireFloat(){ // lecture d'un float
		float x = 0 ; // valeur � lire
		String ligneLue = lireString();
		x = Float.parseFloat(ligneLue) ;
		return x ;
	}

}
