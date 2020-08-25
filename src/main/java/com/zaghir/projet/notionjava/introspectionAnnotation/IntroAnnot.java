package com.zaghir.projet.notionjava.introspectionAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class IntroAnnot {
	public static void main(String args[])throws NoSuchMethodException{
		if(A.class.isAnnotationPresent(Infos2.class)){
			System.out.println("-- @infos pr�sente sur A");			
		}else{
			System.out.println("-- @infos non pr�sente sur A");			
		}
		if(B.class.isAnnotationPresent(infos.class)){
			System.out.println("-- @infos pr�sente sur B");
		}else{
			System.out.println("-- @infos non pr�sente sur B");
		}
		
		Method m1 = A.class.getDeclaredMethod("f");
		if(m1.isAnnotationPresent(Infos2.class)){
			System.out.println("-- @infos pr�sente sur A.f");
			Infos2 ainf1 = m1.getAnnotation(Infos2.class);
			System.out.println("message = "+ainf1.message());
			System.out.println("value = "+ainf1.value());			
		}
		
		Method m2 = A.class.getDeclaredMethod("f");
		if(m2.isAnnotationPresent(Infos2.class)){
			System.out.println("-- @Infos pr�sente sur A.g");
			Infos2 ainf2 = m2.getAnnotation(Infos2.class);
			System.out.println("message = "+ainf2.message());
			System.out.println("value = "+ainf2.value());
		}
	}

}

@Infos2(message="Message Classe A" , value=20)
class A2{
	@Infos2(message="Message methode f ")
	void f(){}
	
	@Infos2(12)
	void g(){}
	
	void h(){}
}
class B2{}

@Retention(RetentionPolicy.RUNTIME)
@interface Infos2{
	String message() default "Rien";
	int value() default 0 ; 
}