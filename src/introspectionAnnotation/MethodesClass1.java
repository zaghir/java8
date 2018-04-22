package introspectionAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodesClass1 {
	public static void main(String args[]){
		Point1 p = new Point1();
		Class<?> c = p.getClass();
		
		Field[] champs = c.getFields();
		System.out.println("--- Champs de Point :");
		for(Field champ:champs){
			System.out.print(champ.getName()+" ");
		}
		System.out.println();
		Method[] methodes = c.getMethods();
		System.out.println("--- Noms de toutes les methode de Point :");
		for(Method method :methodes){
			System.out.print(method.getName()+" ");
		}
		System.out.println();
		Constructor<?>[] constructors = c.getConstructors();
		System.out.println("--- Construteurs de Point :");
		for(Constructor<?> constructor :constructors){
			System.out.print(constructor.getName()+" ") ;
		}
		
	}
	

}

class Point1{
	public static int compte = 0;
	public int x , y ;
	public Point1(){ x = 0; compte++; }
	public Point1(int x , int y){ this.x = x ; this.y = y ;}
	public void deplace(int dx ,int dy ){ x+= dx ; y+=dy;}
	private void symetrise(){ x = -x ; y = -y; }
	public static void afficheNbr(){
		System.out.println("il y a "+compte+" points");
	}
}