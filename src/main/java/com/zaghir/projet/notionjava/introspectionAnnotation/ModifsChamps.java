package com.zaghir.projet.notionjava.introspectionAnnotation;

import java.lang.reflect.Field;

public class ModifsChamps {
	public static void main(String args[])throws IllegalAccessException{
		Point1 p1 = new Point1();
		Point1 p2 = new Point1(10,20);
		Class<?> c = p1.getClass();
		Field champs[] = c.getDeclaredFields();
		//recuprer les valeur du premier champ p1 et p2 
		int xp1 = champs[0].getInt(p1); // on suppose le type(int) connu
		Object xp2 = champs[0].get(p2);// on ne suppose pas de type particulier on obtiendra un objet de type Integer
		System.out.println("type de xp2 = "+xp2.getClass().getName());
		System.out.println("Pour p1, champ "+champs[0].getName()+" = "+xp1);
		System.out.println("Pour p2, champ "+champs[1].getName()+" = "+xp2);
		//Modification des valeurs du premier champ de p1 et p2
		Integer io = 100; 
		champs[0].set(p2, io);
		champs[1].set(p1, 999);
		System.out.println("Pour p1, champ "+ champs[0].getName()+" = "+champs[0].getInt(p1));
		System.out.println("Pour p2, champ "+ champs[1].getName()+" = "+champs[1].getInt(p2));
		System.out.println("appel affiche sur p1 - ");
		p1.afficheNbr();
		System.out.println("appel affiche sur p2 - ");
		p2.afficheNbr();
	}

}
