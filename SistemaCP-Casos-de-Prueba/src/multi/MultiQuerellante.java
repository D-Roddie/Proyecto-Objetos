package multi;

import com.acceso.Conector;
import objetos.Querellante;
import com.acceso.AccesoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 1.0 6/12/2017
 */
public class MultiQuerellante {

    private AccesoBD conn;
    /**
     * Registra un querellante en la base de datos
     * @param nombre nombre del querellante
     * @param apellido1 apellido del querellante
     * @param apellido2 apellido materno del querellante
     * @param cedula cedula del querellante
     * @param telefono telefono del querellante
     * @param direccion direccion del querellante
     */
    public void registarQuerellante(String nombre, String apellido1, String apellido2, String cedula, String telefono, String direccion) {

        String query;
        query = "EXECUTE [dbo].[pa_registrar_querellante]'" + nombre
                + "','" + apellido1 + "','" + apellido2 + "','" + cedula + "','" + telefono + "','" + direccion + "'";

        try {
            conn = new Conector().getConector();

            conn.ejecutarSQL(query);

        } catch (Exception ex) {
            Logger.getLogger(MultiQuerellante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Llena un  ArrayList con todos los querellante
     * registrados en la base de datos
     * @return ArrayList de querellantes
     * @throws Exception 
     */
    public ArrayList<Querellante> listarQuerellante() throws Exception {
        ArrayList<Querellante> listQuerellante = new ArrayList<>();

        String query;
        query = "SELECT * FROM tQuerellante";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            Querellante querellante = new Querellante(
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("cedula"),
                    rs.getString("telefono"),
                    rs.getString("direccion"));

            listQuerellante.add(querellante);
        }
        return listQuerellante;

    }
    /**
     * Busca la cedula del querellante
     * en la tabla querellantes y la retorna si la encuentra
     * registrada
     * @param cedula cedula del querellante
     * @return Querellante cedula
     * @throws Exception 
     */
    public Querellante logIn(String cedula) throws Exception {
        Querellante miQuerellante = null;

        String query = "select cedula from [dbo].[tQuerellante] where cedula = '" + cedula + "'";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        
        while (rs.next()) {
            miQuerellante = new Querellante(rs.getString("cedula"));
        }

        return miQuerellante;
    }
    /**
     * Este metodo busca el nombre de un querellante segun su
     * cedula para devolverlo en un String
     * @param cedula cedula del nombre a buscar
     * @return String con el nombre del querellante encontrado
     * @throws SQLException
     * @throws Exception 
     */
    public String nombreByCedula(String cedula) throws SQLException, Exception {
        String nombreQuere = "";
        String query = "select nombre, apellido1, apellido2 from tQuerellante where cedula = '"+cedula+"'";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        
        while (rs.next()) {
            nombreQuere = (rs.getString("nombre"));
        }
        
        return nombreQuere;
    }
    /**
     * Obtiene el nombre, apellido materno y paterno de un
     * querellante por medio del id de este
     * @param id_querellante id del querellante
     * @return Querellante nombre, apellidos
     * @throws Exception 
     */
    public Querellante getQuerellanteById(int id_querellante) throws Exception{
        Querellante quere = null;
        String query = "SELECT nombre, apellido1, apellido2 FROM tQuerellante "
                + "WHERE id_querellante = '"+ id_querellante +"';";
          

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            quere = new Querellante(rs.getString(1), rs.getString(2), rs.getString(3)   );  
        }

        conn.finalize();

        return quere;
    }
    
    /**
     * Obtiene el id del querellante por medio
     * de la cedula de este
     * @param cedula cedula del querellante
     * @return int id del querellante
     * @throws SQLException
     * @throws Exception 
     */
    public int getIdByCedula(String cedula) throws SQLException, Exception {
        int id_querellante = 0;
        String query = "select id_querellante from tQuerellante where cedula = '"+cedula+"'";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        
        while (rs.next()) {
            id_querellante = rs.getInt("id_querellante");
        }
        
        return id_querellante;
    }
    
}
