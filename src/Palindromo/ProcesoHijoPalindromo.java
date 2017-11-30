package Palindromo;

import java.util.Scanner;

public class ProcesoHijoPalindromo {

	public static void main(String[] args) {
		
		/**
		 *  Lee cadenas desde el teclado con un bucle infinito y comprueba si la cadena es 
		 *  un número capicua o si es un texto si es palindromo, MOSTRANDO  en pantalla los
		 *  mensajes correspondientes 
		 */
		
		
		Scanner teclado = new Scanner(System.in);
		String linea;
		int numero;
		boolean esPalindromo;
		boolean esNumerico;
		
		
		while((linea = teclado.nextLine())!=null) {
			esNumerico   = false;
			esPalindromo = esPalindromo(linea);
			try {
				numero = Integer.parseInt(linea);
			}catch (NumberFormatException e) {
				esNumerico = true;
			}
			/**
			 *  Se imprime en pantallalos resultados
			 */
			if(esPalindromo) {
				if(esNumerico) {
					System.out.println("Es palindormo");
				} else {
					System.out.println("El número introducido  es capicua");
				}
			} else {
				if(esNumerico) {
					System.out.println("No es palindromo");
				} else {
					System.out.println("No es un capicua");
				}
			}
			
		}
		

	}

	private static boolean esPalindromo(String linea) {
		/**
		 * Recorre la cadena mediante un while, para cuando se encuentra 2 caracteres diferentes
		 */
		boolean palindromo = true;
		int i = 0;
		int j = linea.length() -1; // El ultimo elemento de la cadena
		
		while(palindromo && i<j) {
			if(linea.charAt(i) == linea.charAt(j)) {
				i++;
				j--;
			} else {
				palindromo = false;
			}
		}
		
		return palindromo;
	}
	
	
	
	

}
