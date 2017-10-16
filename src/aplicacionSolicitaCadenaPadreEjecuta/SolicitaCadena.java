package aplicacionSolicitaCadenaPadreEjecuta;

import java.util.Scanner;

public class SolicitaCadena {

	public static void main(String[] args) {
		
		
		Scanner teclado = new Scanner(System.in);
		String cadena = null;
		System.out.println("Introduce cadena: ");
		cadena = teclado.nextLine();
		System.out.println("La cadena introducida es: " + cadena);
		teclado.close();
		
		
		
	}

}
