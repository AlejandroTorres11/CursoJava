package Clinica.Conexion;

import Clinica.Paciente;

import java.sql.PreparedStatement;
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

        Paciente paciente;
        while(rs.next()){
            int historiaClinica= rs.getInt("historiaClinica");
            String nombre= rs.getString("nombre");
            String servicio= rs.getString("servicio");
            String seguroMedico= rs.getString("seguroMedico");
            int importe= rs.getInt("importe");
            Date fechaDate= rs.getDate("fechaCita");
            LocalDate fechaCita = fechaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            boolean atendido= rs.getBoolean("atendido");

            paciente= new Paciente(historiaClinica,nombre,servicio,seguroMedico,importe,fechaCita,atendido);
        }
        return listaPacientes;

    }

    public boolean agregarPaciente(Paciente p) throws SQLException {
        boolean agregado = false;
        String nombre= p.getNombre();
        String servicio= p.getServicio();
        String seguroMedico= p.getSeguroMedico();
        LocalDate fecha = p.getFechaCita();
        Date fechaCita = java.sql.Date.valueOf(fecha);
        int importe= p.getImporte();
        boolean atendido= p.isAtendido();
        String instruccion = "INSERT INTO libros VALUES (?,?,?,?,?,?)";
        PreparedStatement pst = conexion.prepareStatement(instruccion);

        pst.setString(1, nombre);
        pst.setString(2, servicio);
        pst.setString(3, seguroMedico);
        pst.setInt(4, importe);
        pst.setDate(5, (java.sql.Date) fechaCita);
        pst.setBoolean(6, atendido);

        pst.executeUpdate();
        pst=null;
        agregado=true;
        return agregado;
    }
    public boolean borrarPaciente( String instruccion) throws SQLException{
        boolean borrado= false;
        PreparedStatement pst = conexion.prepareStatement(instruccion);
        pst.executeUpdate();
        pst=null;
        borrado=true;
        return borrado;
    }
}
