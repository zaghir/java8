package com.zaghir.projet.notionjava.lambdaAndStream;

public class TableauLambda {
	
	public static void traite(int n  , Calculateur cal){
		int res = cal.calcul(n);
		System.out.println("calcul ( "+n+" )  = "+res);
	}
	public static void main(String args[]){
		Calculateur[] tabCalc = {
			x-> x*x,
			x-> 2*x,
			x-> (int)Math.sqrt(x)
		};
		for(Calculateur cal :tabCalc) traite(10, cal);
	}

}
