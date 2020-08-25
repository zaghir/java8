package com.zaghir.projet.notionjava.lambdaAndStream;

public class CompositionLambda {
	
	public static void traite(int n  , Calculateur cal){
		int res = cal.calcul(n);
		System.out.println("calcul ( "+n+" )  = "+res);
	}
	public static void main(String args[]){
		FabriqueCalculateur fabriqueCarre = () ->(x-> x*x );
		FabriqueCalculateur fabriqueDouble = () -> x-> x*2 ;
		traite( 10 , fabriqueCarre.fabrique()) ;
		traite( 10 ,fabriqueDouble.fabrique());		
	}
}
