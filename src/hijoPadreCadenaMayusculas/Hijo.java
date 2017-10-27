package hijoPadreCadenaMayusculas;

import java.util.Scanner;

public class Hijo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
//		
		System.out.println(teclado.nextLine().toUpperCase());
		System.out.println(teclado.nextLine().toUpperCase());
		
		String cadena = null;
		//cadena = teclado.nextLine();
		
		while(!cadena.equalsIgnoreCase("fin")) {
			System.out.println(cadena.toUpperCase());
			cadena = teclado.nextLine();
		}
		
	

	}

}
