package introspectionAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MethodeClass3 {
	public static void main(String args[]) throws IllegalAccessException{
		Point1 p = new Point1();
		Class<?> c = p.getClass();
		Method methodes[] = c.getDeclaredMethods();
		// afficher les informations relatives aux methodes de la classe p
		for(Method methode:methodes){
			System.out.println("--- Methode de nom : "+methode.getName());
			System.out.print("-type d'arguments : ");
			Class<?> typeArgs[] = methode.getParameterTypes();
			for(Class<?> typeArg : typeArgs){
				System.out.print(typeArg.getName()+" ");
			}
			System.out.println();
			
			Class<?> typeRetour = methode.getReturnType();
			System.out.println("-- type valeur de retour : "+typeRetour.getName());
			System.out.println("-- modificateurs : "+methode.getModifiers());
		}
		// affichier les informations relatives au construteurs de la classe p
		Constructor<?> constructors[] = c.getDeclaredConstructors();
		for(Constructor constructor: constructors){
			System.out.println("constructor de nom : "+constructor.getName());
			System.out.println("- type arguments :");
			Class<?> typeArgs[] = constructor.getParameterTypes();
			for(Class<?> typeArg :typeArgs){
				System.out.print( typeArg.getName()+" ");
			}
			System.out.println();
			System.out.println("- modificateurs : "+constructor.getModifiers());
		}
	}

}
