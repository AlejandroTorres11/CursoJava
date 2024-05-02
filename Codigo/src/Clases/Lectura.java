package Clases;

import java.io.*;

public class Lectura {

	public void leer() {
		try {
			FileReader lectura= new FileReader("texto.txt");
			BufferedReader buffer= new BufferedReader(lectura);//creamos buffer para mayor eficiencia
			
			String linea=""; //lee linea a linea hasta \n
			while(linea!=null) {
				linea=buffer.readLine();
				if(linea!=null)
				System.out.println(linea);
			}
			lectura.close();
			/*
			 int car=0;
			while (car!= -1) {
				car=lectura.read();
			    char letra = (char) car;
			    System.out.print(letra);
			}
			lectura.close();
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encuentra el archivo");
		}
	}
}

