package com.zaghir.projet.notionjava.collection;

import java.util.LinkedList;
import java.util.ListIterator;

public class Liste1 {
	public static void main(String args[]){
		LinkedList<String> l = new LinkedList<String>();
		System.out.print("Liste en A :");
		affiche(l);
		l.add("a"); l.add("b"); 
		System.out.print("Liste en B : ");
		affiche(l);
		
		ListIterator<String> it = l.listIterator();
		
		it.next(); // on se place sur le premier element
		it.add("c"); it.add("b"); // et on ajoute deux elements 
		System.out.print("Liste en C : ");
		affiche(l);
		
		it = l.listIterator();
		it.next(); // on progresse d'un element
		it.add("b"); it.add("d"); // et on ajoute deux element
		System.out.print("Liste en D : ");
		affiche(l);
		
		it = l.listIterator(l.size()) ; // on se place � la fin de la liste
		
		while(it.hasPrevious()){ // on recherche le dernier b
			String ch = it.previous() ; 
			if(ch.equals("b")){
				it.remove(); // on suprime cet element				
			}			
		}
		
		System.out.print("Liste en E : ");
		affiche(l);
		
		it = l.listIterator();
		it.next(); 		it.next();  // on se place sur le deuxieme element   
		
		it.set("x"); // on le remplace par x 
		
		System.out.print("Liste en F : ");
		affiche(l);
		
		it = l.listIterator(2) ;  // se placer sur le deuxieme element 
		it.next() ; // initialise l'element
		it.set("x2");
		System.out.println("Liste en G :"+l.toString()); // le meme resultat que affiche(l) 
		
	}
	public static void affiche(LinkedList<String> l ){
		ListIterator<String> iter = l.listIterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+" ");			
		}
		System.out.println();
	}

}
