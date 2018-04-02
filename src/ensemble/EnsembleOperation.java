package ensemble;

import java.util.HashSet;
import java.util.Iterator;

public class EnsembleOperation {
	
	public static void main(String args[]){
		int t1[] = {2,5,6,8,9};
		int t2[] = {3,6,7,9};
		HashSet<Integer> e1 =new HashSet<Integer>() ,
				e2 = new HashSet<Integer>() ,
				u1 = new HashSet<Integer>() ,
				i1 = new HashSet<Integer>();
		for(int v: t1) {e1.add(v);}
		for(int v: t2) {e2.add(v);}
		
		System.out.println("e1 ="+e1);
		System.out.println("e2 ="+e2);
		// reunion de e1 et e2 dans u1
		copie(u1, e1);
		u1.addAll(e2);
		System.out.println("u1 ="+u1);
		
		copie(i1, e1);
		i1.retainAll(e2);
		System.out.println("i1 = "+i1);
		
	}
	
	public static <E> void copie(HashSet<E> but , HashSet<E> source ){
		Iterator<E> iter = source.iterator();
		while(iter.hasNext()){
			but.add(iter.next());
		}
	}

}
