package Banco;

import excepciones.NumeroCuentaException;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class CuentaBancaria {
    private String numCuenta;
    private String dni;
    private String titular;
    private double saldo;
    private LocalDate fechaAlta;
    private boolean bloqueada;

    public CuentaBancaria(String numCuenta, String dni, String titular, double saldo, LocalDate fechaAlta,boolean bloqueada) {
        try {
            if ((numCuenta.charAt(8) == calcularDC(numCuenta).charAt(0)) && (numCuenta.charAt(9) == calcularDC(numCuenta).charAt(1))) {
                this.numCuenta = numCuenta;
                this.dni = dni;
                this.titular = titular;
                this.saldo = saldo;
                this.fechaAlta = fechaAlta;
                this.bloqueada = bloqueada;
            }
            else{
                throw new NumeroCuentaException();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String calcularDC(String ccc) {
        int[] entidadSucursal= new int[10];
        entidadSucursal[0]=0;
        entidadSucursal[1]=0;
        for(int i=2;i<10;i++) {
            entidadSucursal[i]= Character.getNumericValue(ccc.charAt(i-2));
        }
        int[] multD= {1,2,4,8,5,10,9,7,3,6};
        int acuD=0;
        for(int i=0;i<10;i++) {
            acuD+= entidadSucursal[i]* multD[i];
        }
        int d=11-(acuD%11);
        if(d==10) {
            d=1;
        }else if(d==11) {
            d=0;
        }

        int[] numeroCuenta=new int[10];
        for(int i=0;i<10;i++) {
            numeroCuenta[i]= Character.getNumericValue(ccc.charAt(i+10));
        }
        int[] multC={1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
        int acuC=0;
        for (int i = 0; i < 10; i++) {
            acuC += numeroCuenta[i] * multC[i];
        }
        int c = 11 - (acuC % 11);
        if (c == 10) {
            c = 1;
        } else if (c == 11) {
            c = 0;
        }
        return String.valueOf(d) + String.valueOf(c);
    }



    public String getNumCuenta() {
        return numCuenta;
    }
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public boolean isBloqueada() {
        return bloqueada;
    }
    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    @Override
    public String toString() {
        return  numCuenta + ";" + dni + ";" + titular + ";" + saldo
                + ";" + fechaAlta + ";" + bloqueada;
    }

}
