package Clases;

public class Matriz {

	public static void main(String[] args) {
		int[][] matriz= {{3,6,7}
						,{7,4,9}
						,{8,2,5}}; 
		
		int filas=matriz.length;
		int columnas= matriz[0].length;
		for(int i=0;i<filas;i++) //recorre las fila
		{
			System.out.println();
			for(int j=0;j<columnas;j++) //recorre las columna
			{ 
				System.out.print(matriz[i][j]+ " ");
			}
		}
		
		System.out.println();
		for(int[] fila:matriz)
		{
			System.out.println();
			for(int n:fila)
			{
				System.out.print(n + " ");
			}
		}
		System.out.println("matriz transpuesta");
		
		int[][] transpuesta= new int[3][3];
		for(int i=0;i<filas;i++)
		{
			System.out.println();
			for(int j=0;j<columnas;j++) 
			{
				transpuesta[i][j]= matriz[j][i];  //posicion j,i de matriz es la i,j de la transpuesta
				System.out.print(matriz[j][i] +" ");
			}
			
		}
		
		
	}

}
