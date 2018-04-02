package lambdaAndStream;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethodeTerminal {
	public static void main(String args[]){
		int [] tab = {10 ,30 , 20 , 0  , 50 , 40 , 80 , 60 , 90 ,  - 10 , -40 , -20 } ;
		OptionalInt max = IntStream.of(tab).max();
		if(max.isPresent()){
			System.out.println("Max pos de tab avec isPresent = "+max.getAsInt());
		}
		// exploration de max avec orElse ( par convention ici 0 si valeur absente)
		System.out.println("Max pos de tab avec orElse = "+max.orElse(0));
		// exploration de max avec  ifPresent
		max.ifPresent(x-> System.out.println("Max pos de tab avec ifPresent"+max.getAsInt()+"  ou  "+x));
		
		int somme = IntStream.of(tab).filter(x-> x>0).sum();
		System.out.println("Somme des positifs de tab = " +somme);
		
		OptionalDouble moyenne = IntStream.of(tab).filter(x-> x< 0).average() ;
		if(moyenne.isPresent()){
			System.out.println("Moyenne des < 0 de tab = "+moyenne.getAsDouble());			
		}else{
			System.out.println(" aucun nombre <0  dans la tab  ");			
		}
		
		System.out.println("Somme de >0 de tab = "+somme);
		// max sur les Stream<Integer>
		Integer [] tabObj = {10 ,30 , 20 , 0  , 50 , 40 , 80 , 60 , 90 ,  - 10 , -40 , -20 } ;
		Optional<Integer> maxObj = Stream.of(tabObj).max(Comparator.naturalOrder());
		if(maxObj.isPresent()){
			System.out.println("Max des positifs de tabObj = "+maxObj.get());
		}
		
	}

}
