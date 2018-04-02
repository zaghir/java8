package lambdaAndStream;
// interface fonctionnel avec une seule methode ici calculer
interface Calculateur2{ public int calculer(int n);}
public class IntroLambd2 {
	public static void main(String args[]){
		Calculateur2 calculateur = x -> x * x;
		System.out.println(calculateur.calculer(6));
		System.out.println(calculateur.calculer(4));
	}

}
