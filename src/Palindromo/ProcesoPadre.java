package Palindromo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class ProcesoPadre {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		//Creamos una instancia de Runtime
		Runtime r = Runtime.getRuntime();
		Process p = null;	
		/**
		 *  COn el método exec de la clase Runtime ejecutamos un subproceso (proceso ProcesoHijoPalindromo)
		 *  el metodo devuelve un objeto de la clase Process.
		 *  A través de este objeto se comunica con el proceso padre (ProcesoPadre)
		 */		
		try {
			p = r.exec("java -jar Palindromo.jar");
			System.out.println("Introduce una cadena: ");
			String cadena = teclado.nextLine();			
			/**
			 * Mediante el metodo getOutPutStream capturamos la entrada estandar de proceso hijo que es el teclado.
			 * A partir de ese momento los datos que el  hijo espera recibir del teclado ya no los recibe de esa fuente,
			 * los recibe del padre. 
			 */			
			PrintStream ps = new PrintStream(p.getOutputStream());
			/**
			 * Mediante el metodo getInputStream capturamos la salida estandar del proceso hijo, que es la pantalla
			 * A partir de este momento lo que el proceso hijo escriba en pantalla, el proceso padre lo recupera con 
			 * el metodo readLine() de la clase BufferReader
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while(!cadena.equalsIgnoreCase("fin")) {
				ps.println(cadena);
				ps.flush();
				System.out.println(br.readLine());
				System.out.println("Introduce una cadena: ");
				cadena = teclado.nextLine();
			}
			System.out.println("Finalizando");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
