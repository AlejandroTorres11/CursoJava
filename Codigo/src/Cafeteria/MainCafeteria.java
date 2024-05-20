package Cafeteria;

public class MainCafeteria {
    public static void main(String[] args) {
        Cafeteria caf = new Cafeteria();
        caf.generarBandejas();
        caf.generarComensales();
        System.out.println("bandejas");
        caf.mostrarPilaBandejas();
        System.out.println(caf.pBandejas.mayorNumero());
        System.out.println("Comensales");
        caf.mostrarListaComensales();
        caf.atenderTodosCursos();
        System.out.println("servidos");
        caf.mostrarServidos();
        System.out.println("Bandejas");
        caf.mostrarPilaBandejas();
        System.out.println("Pendientes");
        caf.mostrarPendientes();
        System.out.println("Gestionar Pendientes");
        caf.atenderPendientes();
        System.out.println("mostrar pendientes");
        caf.mostrarPendientes();
        System.out.println("mostrar pila");
        caf.mostrarPilaBandejas();
        System.out.println("mostrar todas bandejas");
        caf.mostrarPilaBandejasTotales();


        /*
        System.out.println("1");
        caf.atenderCurso(1);
        caf.mostrarPilaBandejas();
        System.out.println(caf.pBandejas.mayorNumero());
        caf.mostrarListaComensales();
        System.out.println("2");
        caf.atenderCurso(2);
        caf.mostrarPilaBandejas();
        caf.mostrarListaComensales();
         */


    }
}
