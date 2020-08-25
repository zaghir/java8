package com.zaghir.projet.notionjava.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lambda1 {
	
	
	public static  void main(String args[]) {
		// le compilateur c'est lui qui instancie l interface Runnable , car au moment de la compilation 
		// tout deviennet des classe

		// avec l'expression lambda 
		Runnable r1 = () -> System.out.println("run 1 with lambda");
		Runnable r2 = () -> System.out.println("run 2 with lambda");
		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				System.out.println("run 3  with anonymous class ");
			}			
		};		
		process(r1);
		process(r2);
		process(r3);
		// Dans l'interface Runnable il y a une seule fonction sans parametere , donc le compilateur l'utilise
		// avec l'implementation passée en paramétre ici c'est un System.out.println("run 3 with lambda") comme traitement
		process(() -> System.out.println("run 3 with lambda"));
		
		
		try {
			// 1ere implementation
			System.out.println("processFile() ===> "+processFile((BufferedReader br)-> br.readLine()));
			//2 eme implementation
			System.out.println("processFile() ===> "+processFile((BufferedReader br)-> {
				String s = br.readLine()+" "  ;
				s += br.readLine()+" " ;
				s += br.readLine() ;
				return s;}));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Runnable c'est l'interface fonctionnel car elle a une seule methode abstrait
	public static void process(Runnable r ) {
		r.run();
	}
	
	
//	public static String processFile() throws IOException {
//		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
//			return br.readLine();
//		}
//	}
	
	public static String processFile(BufferedReaderProcessor b) throws IOException {
		// on veut parametrer le processing de fichier data.txt
		// on creer une interface fonctionnelle 
		// au moment de l'appel on defini le comportement
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			return b.process(br);
		}
	}
	
	
	

}
