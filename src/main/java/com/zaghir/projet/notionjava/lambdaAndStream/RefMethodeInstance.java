package com.zaghir.projet.notionjava.lambdaAndStream;

public class RefMethodeInstance {
	
	public static void main(String args[]){
		Point p1 = new Point(1 , 3) ,
				p2 = new Point(3 ,9) ,
				p =  new Point(1 ,2),
				origine = new Point(0 , 0) ;
		
		DistanciableDe distOrigine = p::distance_a ; // le compilateur va comparer le point distOrigine avec l autre point
		// equivanent a distOrigine = pp -> distOrigine.distance_a(pp)
		System.out.println("dist de p1 � l'origine = "+distOrigine.distance_a(p1));
		
		DistanciableDe distP = p::distance_a ;
		System.out.println("dist de p1 � p = "+p.distance_a(p1));
	}

}
