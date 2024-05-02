package Clases;

public class ArraySimple {

	public static void main(String[] args) {
		int[] array= new int[4];
		array[0]=1;
		array[1]=33;
		array[2]=-9;
		array[3]=75;
		//int[] array2= {1,2,5,66,-3};
		//for
		System.out.println("for");
		for(int i=0;i<array.length;i++) //i es un entero que por cada iteración aumenta su valor hasta un limite
		{
			System.out.println("indice:"+ i +", valor:"+ array[i]);
		}
		//for each
		System.out.println("for each");
		for(int i:array) //toma el valor de cada elemento de array en las iteraciones,si fuese array de Strings,i seria string
		{  
			System.out.println(i);
		}
	}
	

}
