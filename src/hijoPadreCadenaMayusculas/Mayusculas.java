package hijoPadreCadenaMayusculas;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Mayusculas {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		Runtime r = Runtime.getRuntime();
		Process p = null;

			try {
				
				System.out.println("Introduce cadena");
				String tex = teclado.nextLine();
				
				p = r.exec("java -jar Hijo.jar");
				
				//capturamos el flujo de entrada de datos del proceso hijo
				OutputStream os = p.getOutputStream();
				 
				os.write(tex.getBytes());
				os.flush();
				
				InputStream is = p.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String linea;
				
//					while((linea = br.readLine()) != null) {
//						System.out.println(linea);
//					}
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		
		
	}

}
