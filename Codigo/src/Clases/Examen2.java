package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Examen2 {
	String[] alumnos = {"Pepe", "Maria", "Luis", "Juan", "Marina", "Carmen", "Antonio", "Ana", "Fernando", "Rosario"};
    String[] asignaturas = {"Ingles", "Matematicas", "Naturales", "Lengua", "Geografia"};
    int[][] notas = {{3, 5, 6, 7, 8, 6, 7, 4, 5, 6}, // ingles
            {6, 4, 7, 5, 7, 5, 6, 9, 2, 9}, // mates
            {3, 6, 4, 7, 8, 6, 5, 5, 9, 2}, // naturales
            {5, 3, 5, 7, 8, 4, 7, 3, 4, 6}, // lengua
            {5, 6, 4, 7, 8, 6, 5, 3, 6, 2}}; // geografia

	public void ejercicio1() {
		ArrayList<String>pasan= new ArrayList<String>();
	    ArrayList<String> noPasan= new ArrayList<String>(); //crear lista con alumnos que pasan y que no pasan
	    for (int i = 0; i < alumnos.length; i++) { // elijo alumno
	        String alumno = alumnos[i];
	        int aprobadas=0;
	        boolean matematicas=true;
            boolean lengua=true;
	        for (int a = 0; a < asignaturas.length; a++) { // elijo asignatura
	            String asignatura = asignaturas[a];
	            int nota = notas[a][i];
	           
	            if(a==1 && nota<5) {
	            	matematicas=false;
	            }
	            else if(a==3 && nota<5) {
	            	lengua=false;
	            }
	            else {
	            	if(nota>=5) {
	            		aprobadas++;
	            	}
	            }
	            //System.out.println(alumno+", " +asignatura+": "+nota);
	        }
	        if(aprobadas>=3 && matematicas==true && lengua==true) {
	        	pasan.add(alumno);
	        }
	        else {
	        	noPasan.add(alumno);
	        }
	          
			}
		    System.out.println("\nPasan:");
	        for(String a:pasan) 
			{  
				System.out.println(a);
			}
	        System.out.println("\nNo pasan:");
	        for(String b:noPasan)//toma el valor de cada elemento de array en las iteraciones,si fuese array de Strings,i seria string
	        {  
				System.out.println(b);
			}
	}
	public void mostrarAlumno(int opcion) {
		
	        String alumno = alumnos[opcion-1];
	        System.out.println(alumno+":");
	        for (int a = 0; a < asignaturas.length; a++) { // elijo asignatura
	            String asignatura = asignaturas[a];
	            int nota = notas[a][opcion-1];
	       
	            System.out.println(asignatura+": "+nota);
	            }
	        }
	      
	
	public void ejercicio2() {
		Scanner scanner = new Scanner(System.in);

        // Pedimos al usuario que elija opcion
        System.out.println("Que alumno quieres visualizar: ");
        for(int i=0;i<alumnos.length;i++) {
        	System.out.println(i+1 +"- "+alumnos[i]);
        }
        int numero = scanner.nextInt();
        mostrarAlumno(numero);
        // Cerramos el objeto Scanner para liberar memoria
        scanner.close();
	}
}
