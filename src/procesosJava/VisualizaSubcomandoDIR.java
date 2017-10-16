package procesosJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class VisualizaSubcomandoDIR {

	public static void main(String[] args) {

		/*
		 * En este ejemplo visualizamos la orden DIR
		 */
		
		
		Runtime r = Runtime.getRuntime();
		Process p = null;

		try {
			p = r.exec("cmd /c dir");
			/*Recogemos los datos del proceso hijo para mostrarlos:
			 * Se captura el flujo de datos que genera el proceso hijo creamos un BUffer en memoria con la información
			 */
			InputStream is        = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			
			//Capturamos los datos que genera el proceso hijo y lo mostramos por pantalla
			InputStream iSerroe = p.getErrorStream();
			InputStreamReader isRerror = new InputStreamReader(iSerroe);
			BufferedReader bfRerror = new BufferedReader(isRerror);
			
			String linea = br.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			
			
			String lineaError = bfRerror.readLine();
			while(lineaError != null) {
				System.out.println(lineaError);
				lineaError = bfRerror.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int exitVal;
		try {

			exitVal = p.waitFor();
			System.out.println(exitVal);
			if (exitVal == 0) {
				System.out.println("Proceso hijo ejecutado correctamente");
			} else {
				System.out.println("Error en la ejecución");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
