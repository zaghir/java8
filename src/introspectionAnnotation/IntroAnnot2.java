package introspectionAnnotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class IntroAnnot2 {
	public static void main(String args[]) throws NoSuchMethodException{
		// afficher les Annotions sur une classe
		Annotation[] annotatioDeA = A.class.getAnnotations();
		System.out.println("----------- Annotations de la classe A :");
		for(Annotation a : annotatioDeA){
			System.out.println(a.annotationType().getName()+" ");
		}
		
		// afficher les annotations sur une methodes 
		Method m1 = A.class.getDeclaredMethod("f");
		Annotation[] annotationDEf = m1.getAnnotations();
		System.out.println("----------- Annotations de la method A.f : ");
		for(Annotation a:annotationDEf){
			System.out.println(a.annotationType().getName());
		}
		
		// afficher les annoations sur une classe qui herite d'une autre classe
		Annotation[] annotationsDeB = B.class.getDeclaredAnnotations();
		System.out.println("----------- Annotations declarees de la classe B :");
		for(Annotation a : annotationsDeB){
			System.out.println(a.annotationType().getName());
		}
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface infos{
	String message() default "Rien";
	int value() default 0 ;
}

@Deprecated
@infos(message="Message Class A" , value= 20)
class A{
	@Deprecated
	@infos(message="Message methode f")
	void f(){
		
	}	
}

class B extends A{
	@Override
	void f(){
		
	}
}
