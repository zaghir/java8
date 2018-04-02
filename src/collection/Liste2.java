package collection;

import java.util.LinkedList;
import java.util.ListIterator;

import clavier.Clavier;

public class Liste2 {
	
	public static void main(String args[]){
		LinkedList<String> l = new LinkedList<String>();
		/* on ajoute à la liste tous les mots lus sur le clavier */
		System.out.println("donner une suite des mots (mot vide pour finir)");
		while(true){
			String ch = Clavier.lireString();
			if(ch.length() == 0) break ;
			l.add(ch) ;
		}
		System.out.println("Liste des mots à l'endroit");
		ListIterator<String> lt = l.listIterator();
		while(lt.hasNext()) {System.out.print(lt.next()+" ");}
		System.out.println();
		
		System.out.println("Liste des mots à l'envers");
		lt = l.listIterator(l.size());  // iterateur à la fin de la liste
		while(lt.hasPrevious()){System.out.print(lt.previous()+" ");}
		System.out.println();
		
	}

}
