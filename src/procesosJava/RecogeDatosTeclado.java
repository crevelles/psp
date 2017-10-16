package procesosJava;

import java.io.*;

public class RecogeDatosTeclado {

	public static void main(String[] args) {
		
		/*  Ejemplo de entradad de datos por teclado desde proceso padre y suministrado al proceso hijo
		 	Ejecutará la orden DATE (desde consola) que solicitará datos por teclado
		 */ 
		
		
			Runtime r = Runtime.getRuntime();
			Process p = null;
			try {
				p = r.exec("cmd /c date");
				
				//flujo de salida por pantalla
				InputStream is  = p.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				
				//flujo de error
				InputStream isError = p.getErrorStream();
				InputStreamReader isRError = new InputStreamReader(isError);
				BufferedReader bfE = new BufferedReader(isRError);
				
				
				//flujo entrada de datos
				OutputStream ou =  p.getOutputStream();
				ou.write("04/10/2017".getBytes());
				ou.flush();
				
				String linea = br.readLine();
				
				while(linea != null) {
					System.out.println(linea);
					linea = br.readLine();
				}
				
				String lineaError = bfE.readLine();
				
				while(lineaError!= null) {
					System.out.println(lineaError);
					lineaError = bfE.readLine();
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		

		
		
	}

}
