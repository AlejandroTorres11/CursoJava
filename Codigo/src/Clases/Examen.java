package Clases;

public class Examen {
	/*ISBN-13: Debemos multiplicar cada numero por 1 si la posicion que ocupa es imppar o por 3 si la posicion que ocupa es par y calcular la suma de todos
    salvo del ulti9mo que es el digito de control. Dividimos el resultado de la suma anterior entre 10 y obtenemos el resto de la division.Restmaos a 10 el resto obtenido.
    El isbn será válido si el valor obtenido es igual al digito de control (ultimpo digito del isbn).(Si el resultado de la resta es 10 el DC será 0)
    Ejemplo:
    Comprueba la validez del siguiente isbn-13: 978-84-415-2682-2
 */
	public static boolean compruebaIsbn(String isbn) {
		isbn = isbn.replace("-","");
		System.out.println(isbn);
		int control=Character.getNumericValue(isbn.charAt(isbn.length()-1));
		System.out.println(control);
		int suma=0;
		boolean resultado;
		for(int i=0;i<isbn.length()-1;i++) {
			if(i %2==0) {
				suma=suma + Character.getNumericValue(isbn.charAt(i))*1;
			}
			else {
				suma=suma + Character.getNumericValue(isbn.charAt(i))*3;
			}
		}
		System.out.println(suma);
		int resto=suma %10;
		if(10-resto==control) {
			resultado=true;
		}
		else{
			resultado=false;
		}
		System.out.println(resultado + "\n" + "siguiente:\n");
		return resultado;
	}
	 public static long factorial(long n) {
	        //se pueden hacer mejoras como poner tipos que acepten numeros mas grandes.
	        long resultado = 1;
	        for (long i = 1; i <= n; i++) {
	            resultado *= i;
	            //System.out.println(resultado);
	        }
	        return resultado;
	    }
	    public static long factorialRecursivo(long n) {
	        //factorial pero usando recursividad
	        if (n == 0 || n == 1) {
	            return 1;
	        }
	        return n * factorialRecursivo(n - 1);
	    }
	    public static boolean esCurioso(int n) {
	        System.out.println("¿Es "+ n + " curioso?");
	        String numero= Integer.toString(n);
	        int digito=0;
	        int suma=0;
	        boolean curioso;
	        for(int i=0;i<numero.length();i++) {
	            digito=Character.getNumericValue(numero.charAt(i));
	            long factorial=factorial(digito);
	            System.out.println("factorial de " +digito +" = "+factorial);
	            //System.out.println(factorial);
	            suma+=factorial;
	        }
	        System.out.println("la suma es: " +suma);
	        if (suma==n) {
	            curioso=true;
	            System.out.println("Es curioso\n");
	        }
	        else{
	            curioso=false;
	            System.out.println("No es curioso\n");
	        }

	        return curioso;
	    }

	public static void main(String[] args) {
		compruebaIsbn("978-84-415-2682-2");
		compruebaIsbn("978-84-8130-252-3");
		compruebaIsbn("978-84-8450-382-8");
		compruebaIsbn("978-84-95354-15-0");
		esCurioso(145);
        esCurioso(1);
        esCurioso(500);
        esCurioso(700);
        esCurioso(20);
	}

}
