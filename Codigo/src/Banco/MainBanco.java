package Banco;

public class MainBanco {
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        System.out.println(cuentaBancaria.CalcularDC("23452222","0123456558"));
        cuentaBancaria.generarAleatorio();
    }
}
