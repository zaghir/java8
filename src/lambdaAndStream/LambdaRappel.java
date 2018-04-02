package lambdaAndStream;

public class LambdaRappel {
	
	public static void traite(int n  , Calculateur cal){
		int res = cal.calcul(n);
		System.out.println("calcul ( "+n+" )  = "+res);
	}
	public static void main(String args[]){
		traite(10 , x -> x*x);
		traite(20, x-> 2*x+x);
	}
	

}
