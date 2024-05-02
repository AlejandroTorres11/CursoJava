package Clases;

import java.util.ArrayList;
import java.util.Arrays;

public class Examen3 {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
	        ArrayList<Integer> reparto = generaAleatoriosSinRepeticion(20, 0, 19);

	        String[] baraja = {"1O", "2O", "3O", "4O", "5O",
	                "1C", "2C", "3C", "4C", "5C",
	                "1E", "2E", "3E", "4E", "5E",
	                "1B", "2B", "3B", "4B", "5B"};

	        // Mostrar los números generados aleatoriamente
	        System.out.println(reparto.toString());

	        // Distribuir cartas a los jugadores
	        String[][] manosJugadores = repartirCartas(baraja, reparto);

	        // Mostrar la mano de cada jugador
	        int numeroGanador = 0;
	        for (int i = 0; i < manosJugadores.length; i++) {
	            System.out.println("Jugador " + (i + 1) + ": " + Arrays.toString(manosJugadores[i]));
	            for (int j = 0; j < manosJugadores[i].length; j++) { //cartas
	                if(manosJugadores[i][j] =="5C"){ //comprobar si es carta ganadora
	                    numeroGanador=i+1;
	                }

	            }
	        }

	        System.out.println("El ganador es el jugador "+numeroGanador);
	    }
	    public static ArrayList<Integer> generaAleatoriosSinRepeticion(int cantidad, int limInferior, int limSuperior) {
	        ArrayList<Integer> resultado= new ArrayList<Integer>();
	        int n=0;
	        while(n<cantidad){
	            int numero= (int) Math.floor(Math.random()* (limSuperior -limInferior +1)+ limInferior);
	            System.out.println(numero);
	            if(resultado.contains(numero)){
	                System.out.println("Está dentro");
	            }
	            else{
	                resultado.add(numero);
	                n++;
	                System.out.println("No está dentro");
	            }
	        }
	        return resultado;
	    }

	    public static String[][] repartirCartas(String[] baraja, ArrayList<Integer> reparto) {
	        String[][] manosJugadores = new String[4][5]; // cuatro jugadores con cinco cartas
	        int indiceCarta = 0;

	        for (int i = 0; i < manosJugadores.length; i++) { //jugadores
	            for (int j = 0; j < manosJugadores[i].length; j++) { //cartas
	                manosJugadores[i][j] = baraja[reparto.indexOf(indiceCarta)]; // Asignar una carta al jugador
	                indiceCarta++; // Moverse a la siguiente carta
	            }
	        }
	        return manosJugadores;
	    }
}
