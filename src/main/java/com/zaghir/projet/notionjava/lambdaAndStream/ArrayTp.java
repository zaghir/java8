package com.zaghir.projet.notionjava.lambdaAndStream;
import java.util.ArrayList;

public class ArrayTp {
	
	//private int[] table = new int[6];  // on peut le declarer aussi comme ca
	private int[] table = {700, 200 ,600 ,300 , 400 ,100}; // on initialise au moment de la creation
	
	public int[] getTable(){
		return table;
	}
	public int[] triCroissantTable( int[] t){		
		boolean flag = true ;
		int temp ;
		while(flag){
			flag = false;			
			for(int i = 0 ; i <t.length - 1 ; i++){
				if(t[i] > t[i+1]){
					temp = t[i];
					t[i] = t[i+1];
					t[i+1] = temp;
					flag = true;
				}
				
			}			
		}
		return t ;
	}
	
	public void autoboxingUnboxing(){
		/**
		 * autoboxing c'est de creer des objet a partir des premitifs ex: int on va creer l'objet Integer car les List n'accepte pas des int
		 * unboxing c'est le d�ballage c'est l'operation Inverse depuis un objet on va recuperer la valeur d'une premitive
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(Integer.valueOf(56)); // autoboxing
		list.add(78); // autoboxing on passe par l'enveloppeur Integer
		list.add(Integer.valueOf(96));
		int valeurPremetiveInt ;
		for(Integer integer : list){
			valeurPremetiveInt = integer.intValue();
			System.out.println("unboxing valeur => "+valeurPremetiveInt);
		}
		
		/**
		 * trouver l'index de l'objet � chercher  
		 */
		System.out.println("Recherche de l'index => "+list.indexOf(Integer.valueOf(96)));
		
		
	}
	
	public static void main(String[] args){
		ArrayTp ar = new ArrayTp();
//		int[] t  ={700, 200 ,600 ,300 , 400 ,100}; 
//			
//		for(int i = 0 ; i < t.length  ; i++){
//			System.out.println(" valeur "+i+" table Origine "+t[i] );
//		}
//		System.out.println("------------------");
//		int[] arTrie = ar.triCroissantTable(t);	
//		for(int i = 0 ; i < t.length  ; i++){
//			System.out.println(" valeur "+i+" table Trie "+arTrie[i] );
//		}
		ar.autoboxingUnboxing();
		
	}

}
