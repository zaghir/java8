package com.zaghir.projet.notionjava.lambdaAndStream;

public class RefStat {
	// utilisattion de la reference d'une methode static comme intreface fonctionnel
	
	public static void main(String args[]){
		traite(10 , RefStat::carre);       // au lieu de faire traite( 10,  x -> x*x)
		traite(10 , RefStat::trinome);     // au lieu de faire traite( 10 , x ->2*x*x + 3*x +5 
	}
	
	public static int carre(int n) { return n*n ;}
	public static int trinome(int n ) { return 2*n*n + 3*n +5 ;}
	
	public static void traite(int n , Calculateur cal ){
		int res = cal.calcul(n);
		System.out.println("calcul ( "+n+" )  = "+res);
	}

}
