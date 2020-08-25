package com.zaghir.projet.notionjava.lambdaAndStream;
interface Calculateur1{ public int calculer(int n);}
public class IntroLambda1 {
	public static void main(String[] args){
		
		// classe anonyme
		Calculateur1 calculateur = new Calculateur1() {
			
			@Override
			public int calculer(int n) {
				
				return n*n;
			}
		};
		
		System.out.println(calculateur.calculer(6));
		System.out.println(calculateur.calculer(4));
	}

}
