package lambdaAndStream;
import java.util.function.IntUnaryOperator;

public class LambdaRappelIntUnaryOperator {
	
	public static void traite(int n  , IntUnaryOperator cal){
		int res = cal.applyAsInt(n);
		System.out.println("calcul ( "+n+" )  = "+res);
	}
	public static void main(String args[]){
		traite(10 , x -> x*x);
		traite(20, x-> 2*x+x);
	}
	

}
