package collection;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import lambdaAndStream.Point;

public class AlgorithmeMaxMin {
	
	public static void main(String args[]){
		Point p1 = new Point(1,3);
		Point p2 = new Point(2,1);
		Point p3 = new Point(5,2);
		Point p4 = new Point(3,2);
		LinkedList<Point> l = new LinkedList<Point>();
		l.add(p1); l.add(p2); l.add(p3); l.add(p4);
		
		/** Max de l suivant l'ordre defini par le comparTo de Point*/
		Point pMax1 = Collections.max(l);
		
		System.out.println("Max suivant compareTo (par X) = "+pMax1.toString());
		
		/**max de l , suivant l'ordre defini par un comparateur anonyme*/
		Point pMax2 = Collections.max(l , new Comparator(){
			
			public int compare(Object o1, Object o2) {
				Point p1 = (Point)o1 ; 
				Point p2 = (Point)o2;
				if(p1.getY() < p2.getY()) {
					return -1;
				} else if(p1.getY()== p2.getY()) {
					return 0 ;
				}else {
					return 1;				
				}
			}}) ;
		
		System.out.println("Max suivant comparator (par Y) = "+pMax2 );
	}

}
