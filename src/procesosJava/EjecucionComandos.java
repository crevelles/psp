package procesosJava;

import java.io.IOException;

public class EjecucionComandos {

	public static void main(String[] args) {
		// //Ejecutar una orden del SO, por ejemplo DIR el cual NO TIENE EJECUTABLE .exe
		
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		
		try {
			// Usamos el comando cmd para ejecutar DIR porque este comando se ejecuta
			// desde consola y no dispone de ejecutable
			p = r.exec("cmd /c dir");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		int exitVal;
		try {
			// el metodo waitFor hace que el padre espere a que el proceso hijo termine su ejecuci�n
			// y devuelve un valor--> 0 si el hijo se ha ejecutado correctamente o 1 si NO se ha ejecutado
			exitVal = p.waitFor();
			System.out.println(exitVal);
			if(exitVal == 0) {
				System.out.println("Proceso hijo ejecutado correctamente");
			} else {
				System.out.println("Error en la ejecuci�n");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// El proceso de consola se ejecuta correctamente pero nuestra aplicaci�n no muestra
			// el resultado de la ejecucion de la orden DIR en pantalla porque es un proceso hijo.
			// (Los subprocesos no pueden mostrar informaci�n por pantalla ni recibir datos)
	}

}
