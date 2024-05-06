package Banco;

import Clinica.Paciente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BancoController {
    List<CuentaBancaria> listaCuentas= new ArrayList<CuentaBancaria>();

    public BancoController() throws IOException {
        File f = new File("Banco.txt");
        if (!f.exists()) {
            System.out.println("No existe");
            f.createNewFile();
        }
        //String isbn, titulo, autor, editorial, fechaRegistro, fechaPrestamo, precio, prestado;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea = "";
       CuentaBancaria cb = null;
        while ((linea = br.readLine()) != null) {
            //System.out.println(linea);
            String[] datos = linea.split(",");
            String numCuenta = datos[0], dni = datos[1], titular = datos[2];
            double saldo = Double.parseDouble(datos[3]);
            Date fechaAlta = new Date(Integer.parseInt(datos[4]));
            boolean bloqueada = Boolean.parseBoolean(datos[5]);
            cb= new CuentaBancaria(numCuenta,dni,titular,saldo,fechaAlta,bloqueada);
            listaCuentas.add(cb);
            cb= null;
        }
        fr.close();
        br.close();

        fr = null;
        br = null;

    }

    public List <CuentaBancaria> mostrarCuentas(){}
    public void agregarCuenta(CuentaBancaria cuenta){}
    public List < CuentaBancaria >mostrarCuentasCliente(String dni ){}
    public boolean ingresarRetirarDinero(String numCuenta,int cantidad){}
    public  boolean BloquearCuenta(String numCuenta){}
    public int eliminarCuentasBloqueadasCliente(String dni){}
    public boolean salvarDatos(){}

    public List<CuentaBancaria> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<CuentaBancaria> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
}
