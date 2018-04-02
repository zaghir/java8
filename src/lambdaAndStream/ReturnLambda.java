package lambdaAndStream;

public class ReturnLambda {
	
	public static Calculateur fabriqueCalculateur(){
		double m = Math.random();
		if(m<0.5) return x-> x*x;
			else return x-> x*2 ;			
	}
	
	public static void traiter(int n , Calculateur cal){
		int res = cal.calcul(n);
		System.out.println("calcule ( "+n+" ) = "+res);
	}
	public static void main(String args[]){
		for(int i = 0 ; i< 4 ; i++){
			traiter(i , fabriqueCalculateur());
		}
	}

}
