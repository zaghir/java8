package com.zaghir.projet.notionjava.lambdaAndStream;

public class RefMethodeClasse {
	public static void main(String args[]){
		Point p1 = new Point(1,3) ; Point p2 = new Point(2,6) ; 
		
		Distanciable dist = (pp1 ,pp2) -> pp2.getX() - pp1.getX(); 
		System.out.println("dist entre p1 et p2 = "+dist.distance(p1, p2));	
		Distanciable dist1 = Point::distance1 ;  // apple � la reference de la methode de la classe comme interface fonctionnel
		System.out.println("dist1 entre p1 et p2 = "+dist1.distance(p1, p2));
		Distanciable dist2 = Point::distance2 ;  // apple � la reference de la methode de la classe comme interface fonctionnel
		System.out.println("dist2 entre p1 et p2 = "+dist2.distance(p1, p2));	
	}
}

