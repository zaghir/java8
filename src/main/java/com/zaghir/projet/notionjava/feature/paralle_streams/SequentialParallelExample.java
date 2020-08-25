package com.zaghir.projet.notionjava.feature.paralle_streams;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class SequentialParallelExample {

	
	static void  printStream(Stream<String> stream) {
		stream.forEach(s-> {
			System.out.println(LocalTime.now()+" Value :"+s+" - thread : "+Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public static void main(String[] args) {
		
		// to know a valible processors in the machine 
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		String str[] = {"1","2","3","4","5","6","7","8","9","10"};
		System.out.println("-----Sequenctial Run -----");
//		printStream(Arrays.stream(str));
		printStream(Arrays.stream(str).sequential());  // by default is sequential
		System.out.println("-----Parallel Run -----");
		printStream(Arrays.stream(str).parallel());
		
	}

}
