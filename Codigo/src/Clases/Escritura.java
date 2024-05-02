package Clases;

import java.io.*;

public class Escritura {
	public void escribir() {
		String texto="Esto es un texto de ejemplo";
		try {
			//FileWriter escritura= new FileWriter("Escritura.txt"); //crea un nuevo fichero
			FileWriter escritura= new FileWriter("lectura.txt",true); //escribe sobre fichero existente en caso de existir, sino lo crea
			BufferedWriter buffer= new BufferedWriter(escritura);
			buffer.write(texto);
			buffer.newLine();
			buffer.close();
			/*
			for(int i=0;i<texto.length();i++){
				escritura.write(texto.charAt(i));
			}
			*/
			escritura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
