package procesosJava;

import java.io.IOException;

public class EjemplosSubprocesos {

	public static void main(String[] args) {
		//Ejemplo creación subproceso para la ejecución el block de notas:
		/*
		 *  2 JEMPLOS: Runtime y ProcessBuilder,
		 *  En este ejemplo se lanzará  block de notas y paint porque vamos a crear 2 subprocesos 
		 *  independientes (Runtime y ProcessBuilder)
		 */
		
		
		
		//Mediante la clase Runtime podemos crear subprocesos, para ello creamos un objeto de la clae Runtime
		Runtime r = Runtime.getRuntime();
		
		//declaramos variable de la clase process
		Process p  = null;
		Process p2 = null;
		
		
		try {
			//desde el proceso padre llamamos al proceso hijo (notepad)
			p = r.exec("notepad");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//Usamos la clase ProcessBuilder para crear un 2º subproceso
		ProcessBuilder pb = new ProcessBuilder("c:\\windows\\system32\\mspaint.exe");
		try {
			p2 = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		
		
		
		
		
	}

}
