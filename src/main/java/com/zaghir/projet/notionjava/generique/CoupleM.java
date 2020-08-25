package com.zaghir.projet.notionjava.generique;

public class CoupleM {
	
	public static void main(String args[]){
		Integer oi = 3 ;
		Double od1 = 2.5 ;
		Couple<Integer , Double> couple1 = new Couple<Integer , Double>(oi,od1);
		couple1.affiche();
				
		Integer od2 = 6 ;
		Couple<Integer , Integer> couple2 = new Couple<Integer , Integer>(od2 ,od2);
		couple2.affiche();
		
		Integer n = couple1.getPremier();
		System.out.println("Premier element du couple Ch1 = "+n);
		 
	}

}

class Couple<T,U>{
	private T x ;  // le premier element du couple
	private U y ;  // le second element de couple
	
	public Couple(T premier ,U second){
		this.x = premier ;
		this.y = second ;		
	}
	
	public T getPremier(){
		return x;
	}
	
	public void affiche(){
		System.out.println("premiere valeur X = "+ x +" deuxieme valeur Y ="+y);
	}
}
