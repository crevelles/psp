package procesosJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppJAVAEjecutaAppJAVA {

	public static void main(String[] args) {
		
		// Aplicación JAva que ejecuta otra aplicación JAVA
		
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		try {
			p = r.exec("java -jar VisualizaSubcomandoDIR.jar");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStream is        = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		

		
		try {
			String linea = br.readLine();
			
			while(linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		

	}

}
