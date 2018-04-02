package lambdaAndStream;
import java.util.Comparator;
import java.util.stream.Stream;

public class StreamMethodeIntermedaire {
	public static void main(String args[]){
		Integer [] tab = {10 ,30 , 20 , 0  , 50 , 40 , 80 , 60 , 90 ,  - 10 , -40 , -20 } ;
		System.out.println("-- Carres des negatifs , double des positifs ");
		Stream
			.of(tab)
				.map(e -> {  // notez ici on peut utiliser maToInt
					if(e > 0 ) return 2*e ; 
							else return e * e ;}
				)
				.forEach( e ->System.out.print(e+" ") );
		
		System.out.println("\n-- valeus et nombres de negatifs");
		long nbNegatif = Stream
							.of(tab)
								.filter(e-> e< 0)
								.peek(e-> System.out.print(e+" "))
								.count();
		System.out.println("** nombre negatif : "+nbNegatif);
		
		System.out.println("-- valeurs tries par ordre naturel");
		Stream
			.of(tab)
				.sorted()
				.forEach( e ->System.out.print(e+" ") );
		
		System.out.println("\n-- Valeurs triees orde naturel en parallele avec forEachOrdred :");
		Stream
			.of(tab)
				.parallel()  // noter ici forEachOrdered
				.forEachOrdered(e-> System.out.print(e+" "));
		
		System.out.println("\n-- Valeurs triees ordre inverse , sans doublons: ");
		Stream
			.of(tab)
				.sorted(Comparator.reverseOrder()) // imposible si int[] tab
				.distinct()
				.forEach(e-> System.out.print(e+" "));		
	}

}
