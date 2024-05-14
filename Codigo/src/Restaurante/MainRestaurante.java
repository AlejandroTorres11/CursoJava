package Restaurante;

public class MainRestaurante {
    public static void main(String[] args) {

        Restaurante r= new Restaurante();
        r.generarReservas();
        r.mostrarReservas();
        r.generarMesas();
        r.mostrarMesas();
        System.out.println();
        r.gestionarUnaReserva();
        //.gestionarReservas();
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

    }

}
