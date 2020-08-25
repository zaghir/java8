package com.zaghir.projet.notionjava.collection;

import java.util.ArrayList;
import java.util.Collections;

public class Tri1 {
	public static void main(String args[]){
		int nb[] ={4,9,2,3,8,1,3,5};
		ArrayList<Integer>  t = new ArrayList<Integer>();
		for(Integer v :nb){
			t.add(v);
		}
		
		System.out.println("t initial      = "+t);
		/**  il faut definir la methode compareTo() dans le bean
		 *  ou compare() dans la l'objet de Type Comparator 
		 *  pour faire le tri  ici on a seulement des objet Integer simple  */
		Collections.sort(t);
		System.out.println("t tri          = "+t);
		/** la methode shuffle pour m�langer les valeurs les element de la collection*/
		Collections.shuffle(t);
		System.out.println("t melange       = "+t);
		/** trie invers�  de la collection par Collections.reverseOrder() */
		Collections.sort(t , Collections.reverseOrder());
		System.out.println("t trie inverse  = "+t);
		
	}
	
	

}
