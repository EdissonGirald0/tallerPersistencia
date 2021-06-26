package controlador;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Cliente;

public class ClienteDao {

    private final Conector conectar;
    private final Cliente modelo;
    private Connection con;

    public ClienteDao() {
        //llama el conector
        conectar = new Conector();
        //llama el  modelo cliente
        modelo = new Cliente();
    }
//metodo para insertar cliente
    public void insertarCliente(String nombre, String apellido, String tipoDocumento,
            int numeroDocumento, int numeroCuenta, int saldo) throws SQLException {
        //instancia preliminar de los datos
        PreparedStatement prees;
        String sql;
        modelo.setNombre(nombre);
        modelo.setApellido(apellido);
        modelo.setTipoDocumento(tipoDocumento);
        modelo.setNumeroDocumento(numeroDocumento);
        modelo.setNumeroCuenta(numeroCuenta);
        modelo.setSaldo(saldo);
        try {
            con = conectar.getConexion();
            //sentencia SQL
            sql = "insert into datos(nombre, apellido, tipoDocumento,\n"
                    + "            numeroDocumento, numeroCuenta, saldo) values(?,?,?,?,?,?)";
            prees = con.prepareStatement(sql);
            prees.setString(1, modelo.getNombre());
            prees.setString(2, modelo.getApellido());
            prees.setString(3, modelo.getTipoDocumento());
            prees.setInt(4, modelo.getNumeroDocumento());
            prees.setInt(5, modelo.getNumeroCuenta());
            prees.setInt(6, modelo.getSaldo());
            //Actualiza la base de datos
            prees.executeUpdate();
            System.out.println("Los datotos fueron agregados satifactoriamente");
        } catch (SQLException e) {
            System.out.println("Los datotos no fueron agregados");
        }

    }

}
