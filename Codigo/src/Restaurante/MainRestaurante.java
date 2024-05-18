package Restaurante;

public class MainRestaurante {
    public static void main(String[] args) {

        Restaurante r= new Restaurante();
        r.generarReservas();
        r.mostrarReservas();
        r.generarMesas();
        r.mostrarMesas();
        System.out.println();
        //r.gestionarUnaReserva();
        r.gestionarReservas();
        System.out.println("Mesas disponibles");
        r.mostrarMesas();
        System.out.println("Mesas ocupadas:");
        r.mostrarMesasOcupadas();
        System.out.println("Reservas:");
        r.mostrarReservas();
        System.out.println("Atendiendose:");
        r.mostrarAtendiendose();
        System.out.println("Pendientes: ");
        r.mostrarPendientes();
        System.out.println("las servimos: ");
        r.servirMesas();
        System.out.println("Mesas libres");
        r.mostrarMesas();
        System.out.println("Mesas Ocupadas");
        r.mostrarMesasOcupadas();
        System.out.println("Reservas Atendiendose");
        r.mostrarAtendiendose();
        /*
        System.out.println("Atender pendientes");
        r.atenderPendientes();
        System.out.println("Pendientes");
        r.mostrarPendientes();
        System.out.println("Atendiendose");
        r.mostrarAtendiendose();
        System.out.println("Mesas");
        r.mostrarMesas();
        System.out.println("Mesas ocupadas");
        r.mostrarMesasOcupadas();
         */
        System.out.println("----------------------------------fINALIZAR------------------------------------------------------------");
        int i=r.finalizarPendientes();
        System.out.println(i);
    }

}
