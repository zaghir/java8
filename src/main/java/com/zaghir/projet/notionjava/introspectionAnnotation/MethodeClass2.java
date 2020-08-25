package com.zaghir.projet.notionjava.introspectionAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MethodeClass2 {
	public static void main(String args[]){
		Point1 p = new Point1();
		Class<?> c = p.getClass();
		Field champs[] = c.getFields();
		// affichier les champs relatives aux champs de la classe de p
		for(Field champ :champs){
			System.out.println("--- champs de nom "+champ.getName());
			System.out.println("type :"+champ.getType().getName());
			int mod  =champ.getModifiers();			
			System.out.println("modificateurs : "+mod);
			if(Modifier.isPrivate(mod)) System.out.println("private");
			if(Modifier.isPublic(mod)) System.out.println("public");
			if(Modifier.isStatic(mod)) System.out.println("static");
		}
	}
	

}

