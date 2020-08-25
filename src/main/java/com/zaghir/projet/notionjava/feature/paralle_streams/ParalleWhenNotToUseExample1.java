package com.zaghir.projet.notionjava.feature.paralle_streams;

import java.util.stream.IntStream;

public class ParalleWhenNotToUseExample1 {

	public static void main(String[] args) {
		Calculation cal = new Calculation();
		IntStream.rangeClosed(0,2000).forEach(cal :: calculate);
		System.out.println("Result in Seq : "+cal.getTotal());
		
		IntStream.rangeClosed(0,2000).parallel().forEach(cal :: calculate); // in parallel , the result in not the same 
		System.out.println("Result in Parallel : "+ cal.getTotal()); // the variable is updated by diffirent thread 
		

	}

}

class Calculation{
	private int total ;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	public void calculate(int in) {
		total += in ; 
	}
}
