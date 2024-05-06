package Banco;

import Clinica.Paciente;
import excepciones.CuentaBloqueadaException;
import excepciones.NumeroCuentaException;
import excepciones.SaldoInsuficienteException;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class BancoController {
    List<CuentaBancaria> listaCuentas= new ArrayList<CuentaBancaria>();
    public BancoController() throws IOException,Exception, NumeroCuentaException {
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
            String[] datos = linea.split(";");
            String numCuenta = datos[0], dni = datos[1], titular = datos[2];
            double saldo = Double.parseDouble(datos[3]);
            LocalDate fechaAlta = LocalDate.parse(datos[4]);
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
    public List<CuentaBancaria> ordenarSaldo() {
        Collections.sort(listaCuentas, Comparator.comparing(CuentaBancaria::getSaldo));
        return listaCuentas;
    }
    public List<CuentaBancaria> ordenarfecha() {
        Collections.sort(listaCuentas, Comparator.comparing(CuentaBancaria::getFechaAlta));
        return listaCuentas;
    }
    public List <CuentaBancaria> mostrarCuentas(){
        for(CuentaBancaria cb: listaCuentas){
            System.out.println(cb);
        }
        return listaCuentas;
    }
    public void agregarCuenta(CuentaBancaria cuenta){
        listaCuentas.add(cuenta);
    }

    public List < CuentaBancaria> mostrarCuentasCliente(String dni ){
        List<CuentaBancaria> cuentas= new ArrayList<CuentaBancaria>();
        for(CuentaBancaria cb: listaCuentas){
            if(cb.getDni().equals(dni)){
                System.out.println(cb);
                cuentas.add(cb);
            }
        }
        return cuentas;
    }

    public boolean RetirarDinero(String numCuenta, double cantidad) throws SaldoInsuficienteException, CuentaBloqueadaException{

        boolean resultado= false;
        for(CuentaBancaria cb: listaCuentas) {
            if(cb.getNumCuenta().equals(numCuenta)) {
                if(!cb.isBloqueada()) {
                    if(cb.getSaldo()>=cantidad) {
                        cb.setSaldo(cb.getSaldo()-cantidad);
                        resultado=true;
                        break;
                    }
                    else {
                        //System.out.println("no");
                        throw new SaldoInsuficienteException();
                    }
                }else {
                    throw new CuentaBloqueadaException();
                }

            }
        }
        return resultado;
    }

    public void ingresarDinero(String numCuenta,int cantidad){
        for(CuentaBancaria cb: listaCuentas){
            if(cb.getNumCuenta().equals(numCuenta)){
                System.out.println("SI");
                cb.setSaldo(cb.getSaldo()+cantidad);
                break;
            }
        }
    }
    public  boolean bloquearCuenta(String numCuenta){
        boolean r=false;
        for(CuentaBancaria cb: listaCuentas){
            if(cb.getNumCuenta().equals(numCuenta)){
                cb.setBloqueada(true);
                r=true;
                break;
            }
        }
        return r;
    }
    public int eliminarCuentasBloqueadasCliente(String dni){
        int resultado=0;
        for(CuentaBancaria cb: listaCuentas){
            if(cb.getDni().equals(dni) && cb.isBloqueada()){
                listaCuentas.remove(cb);
                resultado++;
                break;
            }
        }
        return resultado;
    }
    public boolean salvarDatos() throws IOException{
        boolean salvado = false;
        FileWriter fw;
        fw = new FileWriter("Clinica.txt");//borramos el fichero y creamos uno nuevo
        BufferedWriter bw = new BufferedWriter(fw);
        for (CuentaBancaria cb: listaCuentas) {
            bw.write(cb.toString());
            bw.newLine();
        }
        fw.flush();

        bw.close();
        fw.close();
        salvado = true;
        return salvado;
    }

}
