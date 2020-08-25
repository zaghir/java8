package com.zaghir.projet.notionjava.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import com.zaghir.projet.notionjava.bean.Apple;

public class MethodReference {

	private int x, y;

	

	public MethodReference() {
		x = 2;
		y = 4;
	}

	public int sum(int a, int b) {
		return a + b;
	}

	public int muliple(int a, int b) {
		return a * b;
	}

	public String hello() {
		return "hello";
	}

//	public calcul() {
//		int calc = muliple(x, y);
//		String str = MethodReference::hello;
//		ToIntFunction<In>  = MethodReference::sul;
//		return calc ;
//	}

	public List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for (Integer i : list) {
			result.add(f.apply(i));
		}
		return result;
	}

	public static void main(String args[]) {
		Supplier<MethodReference> sm = MethodReference::new;
		MethodReference m = sm.get();

		List<Integer> weights = Arrays.asList(7, 3, 4, 10);
		
		
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);
		System.out.println(" ===> "+h.apply(1));
		
		Function<Integer, Integer> i = x -> x + 1;
		Function<Integer, Integer> j = x -> x * 2;
		Function<Integer, Integer> k = i.compose(j);
		System.out.println(" ===> "+k.apply(1));
		
		

	}

}
