package com.zaghir.projet.notionjava.defaultMethod;

public class UserActionApp {

	public static void main(String[] args) {
		UserAction ua = new UserActionImplementation() ;
		ua.get();
		ua.update();
		ua.delete();
		ua.show();

		/*le resultat
		 * 
		 * 	get --> data
 			update -> data [default]
			detete --> data
 			show --> profile [default]
		 */
		
	}

}
