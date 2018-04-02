package tablesAssociatives;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map1 {
	public static void main(String args[]){
		HashMap<String , String> m = new HashMap<String, String>();
		m.put("c", "10") ; m.put("f", "20") ; m.put("k", "30") ;
		m.put("x", "40") ; m.put("p", "50") ; m.put("g", "60") ;
		System.out.println("map initial :                     "+m);

		//retrouver la valeur associe a la clé "f"
		String ch = m.get("f");
		System.out.println("valeur associee a f :             "+ch);
		
		// ensemble des valeurs ( attention ici collection pas set)
		Collection<String> valeurs = m.values();
		System.out.println("liste des valeurs initiales :     "+valeurs);

		// on suprime la valeur "30" par la vue associee
		valeurs.remove("30");
		System.out.println("liste des valeurs apres sup  :    "+valeurs);
		
		//ensemble des cles 
		Set<String> cles = m.keySet();
		System.out.println("liste des cles initiales  :       "+cles);
		//on suprime la cle "p" par la vue associee
		cles.remove("p");
		System.out.println("liste des cles apres sup  :       "+valeurs);
		
		//modification de la valeur associee à la cle x
		String old = m.put("x","25");
		if( old != null){
			System.out.println("Valeur associee a x avant modif :"+old);
			System.out.println("map apres modification de x     :"+m);
			System.out.println("liste des valeurs apres modif de x:"+valeurs);
		}
		
		// on parcourt les entrees (Map.Entry) du map juqu'a trouver la valeur 20
		// et on supprime l'element correspondant (suppose exister)
		Set<Map.Entry<String, String>> entrees = m.entrySet();
		Iterator<Map.Entry<String, String>> iter = entrees.iterator();
		while(iter.hasNext()){
			Map.Entry<String , String> entree = iter.next();
			String valeur = entree.getValue();
			if(valeur.equals("20")){
				System.out.println("valeur 20 trouvee en cle "+entree.getKey() );
				iter.remove(); // suprimer la vue associee
				break ;
			}
		}
		System.out.println("map apres sup element suivant 20 : "+m);
		
		//on suprime l'element de cle "f"
		m.remove("f");
		System.out.println("map apres supression f:            "+m);
		System.out.println("liste des cles apres suppression f: "+cles);
		System.out.println("liste des valeurs apres supp de  f: "+valeurs);
	}
	
}
