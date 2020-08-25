package com.zaghir.projet.notionjava.ensemble;

import java.util.HashSet;
import java.util.Iterator;

public class Ensemble1 {
	
	public static void main(String args[]){
		int t[] = {2,5,-6,2,-8,9,5};
		HashSet<Integer> ens = new HashSet<Integer>();
		/* on ajoute des objets de type integer*/
		for(int v:t){
			boolean ajouter = ens.add(v);
			if(ajouter){
				System.out.println("On ajoute "+v);
			}else{
				System.out.println(" "+v+" est deja present ");
			}
		}
		System.out.print("Ensembre en A = "); affiche(ens);
		/* On suprime un eventuel objet de valeur Integer(5) */
		Integer cinq = 5 ;
		boolean enleve = ens.remove(cinq);
		if(enleve){
			System.out.println( " on a suprim� le 5");
		}
		System.out.print( " Ensemble en B = "); affiche(ens);
		
		/* on teste la presence de Integer(5) */
		boolean existe = ens.contains(cinq);
		if(!existe){
			System.out.println("On ne trouve pas 5");
		}
	}
	
	public static <E> void affiche(HashSet<E> ens){
		Iterator<E> iter =ens.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+" ");
		}
		System.out.println();
	}
}
