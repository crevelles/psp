package aplicacionSolicitaCadenaPadreEjecuta;

import java.io.*;
import java.util.Scanner;

public class EjecutaSubproceso {

	public static void main(String[] args) {

		
		// Aplicación JAva que ejecuta otra aplicación JAVA
		Runtime r = Runtime.getRuntime();
		Process p = null;

		try {
			p = r.exec("java -jar SolicitaCadena.jar");
			//capturamos el flujo de entrada de datos del proceso hijo
			OutputStream os = p.getOutputStream();
			os.write("hola amigo\n".getBytes());

			os.flush();
			
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String linea;
			
			
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
