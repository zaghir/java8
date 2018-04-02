package ensemble;

import java.util.HashSet;

public class Ensemble2 {
	public static void main(String args[]){
		String phrase ="le verbe manger c'est le verbe le plus utilisé en france" ;
		String voy = "aeiouy";
		HashSet<String> lettres = new HashSet<String>();
		for(int i = 0 ; i<phrase.length() ; i++){
			lettres.add(phrase.substring(i, i+1));			
		}
		System.out.println("lettres presentes : "+lettres);
		HashSet<String> voyelles = new HashSet<String>();
		for(int i = 0 ; i<voy.length() ; i++){
			voyelles.add(voy.substring(i, i++));
		}
		lettres.removeAll(voyelles);
		System.err.println("lettres sans les voyelles :"+lettres);
	}
}
