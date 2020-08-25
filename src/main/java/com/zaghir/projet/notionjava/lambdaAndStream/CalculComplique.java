package com.zaghir.projet.notionjava.lambdaAndStream;
interface Calculateur3{ public int calculer(int n);}
public class CalculComplique {
	public static void main(String args[]){
		int n1 = 5 , n2 =4 ,n3 =-5 ;
		Calculateur3 calculateur = x -> {
			if(x > 0 && 2*(x)== x) return x ;
			else if(x>0) return x+1;
			else return -x;
		};
		int res = calculateur.calculer(n1);
		System.out.println("res 1  ==> "+res);
		System.out.println("res 2  ==> "+calculateur.calculer(n2));
		System.out.println("res 3  ==> "+calculateur.calculer(n3));
		
	}

}
