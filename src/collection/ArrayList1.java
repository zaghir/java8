package collection;

import java.util.ArrayList;

// programme pour creer un vecteur contenant dix objet de type integer
public class ArrayList1 {
	public static void main(String args[]){
		ArrayList<Integer> v = new ArrayList<Integer>();
		System.out.println("En A : taille de v = "+v.size() );
		
		/* on ajoute 10 objet de type Integer*/
		for(int i = 0 ; i< 10 ; i++) v.add(new Integer(i));
		System.out.println("En B : taille de v = "+v.size() );
		
		/* afficher le contenu par acces direct (get) a chaque element */
		System.out.println("En B : taille de v = " );
		for(Integer e:v){
			System.out.print(e+" " );
		}
		System.out.println();
		
		/* suppression des elements d'une position donnée */
		v.remove(3);
		v.remove(5);
		v.remove(5);
		System.out.println("En C : contenu v = "+v );
		
		/* ajout d'element a une position données */
		v.add(2, new Integer(100));  
		v.add(2, new Integer(200));
		System.out.println("En D : contenu v = "+v );
		
		/* modification d'element d'une position données */
		v.set(2, new Integer(1000)); // modification element de range 2
		v.set(5, new Integer(2000));
		System.out.println("En E : contenu v = "+v );		
		/* il y a la methode  ensureCapacity(minCapacity); pour les vecteurs demande d'allouer au vecteur une capacite au moins egals a capacité minima
		 * il y a aussi trimToSize() demande de ramener la capacité du vecteur à sa taille actuelle en libérant les espace memoires non utilisé c'est utile quand on sait que la taille ne change pas   
		 */
		
	}

}
