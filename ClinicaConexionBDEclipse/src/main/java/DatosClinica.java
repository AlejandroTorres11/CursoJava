

import java.sql.ResultSet;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.*;
public class DatosClinica {
    private Connection conexion;

    public DatosClinica(Connection con) {
        this.conexion=con;
    }

    public List<Paciente> getConsultaPacientes(String consulta) throws Exception
    {
        List<Paciente> listaPacientes = new ArrayList<Paciente>();

        PreparedStatement pst = conexion.prepareStatement(consulta);
        ResultSet rs = pst.executeQuery();
        System.out.println("baliza2");
        Paciente paciente;
        while(rs.next()){
            int historiaClinica= rs.getInt("historiaClinica");
            String nombre= rs.getString("nombre");
            String servicio= rs.getString("servicio");
            String seguroMedico= rs.getString("seguroMedico");
            int importe= rs.getInt("importe");
            Date fechaCita= rs.getDate("fechaCita");
            boolean atendido= rs.getBoolean("atendido");

            paciente= new Paciente(historiaClinica,nombre,servicio,seguroMedico,importe,fechaCita,atendido);
            listaPacientes.add(paciente);
        }
        return listaPacientes;

    }

    public boolean agregarPaciente(Paciente p) throws SQLException {
        boolean agregado = false;
        
        String nombre= p.getNombre();
        String servicio= p.getServicio();
        String seguroMedico= p.getSeguroMedico();
        Date fecha = p.getFechaCita();
        int importe= p.getImporte();
        boolean atendido= p.isAtendido();
        String instruccion = "insert into pacientes values (?,?,?,?,?,?,?)";
        PreparedStatement pst = conexion.prepareStatement(instruccion);
        pst.setInt(1, 0);
        pst.setString(2, nombre);
        pst.setString(3, servicio);
        pst.setString(4, seguroMedico);
        pst.setInt(5, importe);
        java.sql.Date fechaCita= new java.sql.Date(fecha.getTime());
        pst.setDate(6,  fechaCita);
        pst.setBoolean(7, atendido);
        
        System.out.println(p.toString());
        pst.executeUpdate();
        pst=null;
        agregado=true;
        return agregado;
    }
    public boolean borrarPaciente(String instruccion) throws SQLException{
        boolean borrado= false;
        PreparedStatement pst = conexion.prepareStatement(instruccion);
        pst.executeUpdate();
        pst=null;
        borrado=true;
        return borrado;
    }
}
