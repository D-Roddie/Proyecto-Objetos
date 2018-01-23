package multi;

import com.acceso.Conector;
import objetos.Juez;
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
public class MultiJuez {
    private AccesoBD conn;
    
    /**
     * Metdo que por medio de un query enviado a la base de datos
     * registra un juez en la tabla tJuez 
     * @param nombre nombre del juez
     * @param apellido1 apellido paterno del juez
     * @param apellido2 apellido materno del juez
     * @param cedula cedula del juez
     * @param telefono telefono del juez
     * @param numero_sala numero de sala a la que pertenecera
     * @param usuario nombre de usuario del juez
     * @param clave contaseña del juez
     */
    public void crear(String nombre, String apellido1, String apellido2, String cedula, String telefono, String numero_sala, String usuario, String clave) {

        String query;
        query = "EXECUTE [dbo].[pa_registrar_juez]'" + nombre
                + "','" + apellido1 + "','" + apellido2 + "','" + cedula + "','"
                + telefono + "','" + numero_sala + "','" + usuario + "','"
                + clave + "'";
        try {
            conn = new Conector().getConector();
            
            conn.ejecutarSQL(query);

        } catch (Exception ex) {
            Logger.getLogger(MultiJuez.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.finalize();
    }
    /**
     * Llena un ArrayList con jueces 
     * @return ArrayList con jueces registrados
     * @throws Exception 
     */
    public ArrayList<Juez> listarJuez() throws Exception {
        ArrayList<Juez> listJuez = new ArrayList<>();

        String query;
        query = "SELECT * FROM tJuez";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            Juez juez = new Juez(
                    rs.getInt("id_juez"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("cedula"),
                    rs.getString("telefono"),
                    rs.getString("numero_sala"),
                    rs.getString("usuario"),
                    rs.getString("clave"));

            listJuez.add(juez);
        }
        conn.finalize();
        return listJuez;
        
    }
    
    /**
     * Busca el nombre de usuario y la contraseña de un
     * juez en la base de datos, y lo asigna al constructor del 
     * juez si conincide, devolviendo al juez encontrado
     * @param username nombre de usuario del juez a buscar en la base de datos
     * @param password contraseña a buscar en la base de datos
     * @return juez de tipo Juez
     * @throws SQLException expecion de Sql
     * @throws Exception 
     */
    public Juez logIn(String username, String password) throws SQLException, Exception{
        
        Juez miJuez = null;
        
        String query = "SELECT usuario, clave FROM tJuez WHERE usuario = '"+ username +"'"
                + " AND clave = '"+ password +"'";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            miJuez = new Juez(rs.getString("usuario"), rs.getString("clave"));  
        }
        conn.finalize();
        return miJuez;
    }
    
    /**
     * Obtiene el id del juez por medio del 
     * nombre de usuario de este
     * @param usernme nombre de usuario del juez
     * @return int id del juez
     * @throws Exception 
     */
    public int getJuezIdByUsername(String usernme) throws Exception{
        String query = "select id_juez from tjuez where usuario = '"+usernme+"';" ;
        int id_juez = 0 ;
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
           id_juez = rs.getInt("id_juez");

        }
        conn.finalize();
        return id_juez;
        
    }
    /**
     * Obtiene el nombre, apellido paterno y materno de 
     * un juez por medio del id de este
     * @param id_juez id del juez
     * @return Juez 
     * @throws Exception 
     */
    public Juez getJuezById(int id_juez) throws Exception{
        Juez quere = null;
        String query = "SELECT nombre, apellido1, apellido2 FROM tJuez "
                + "WHERE id_juez = '"+ id_juez +"';";
          

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            quere = new Juez(rs.getString(1), rs.getString(2), rs.getString(3)   );  
        }

        conn.finalize();

        return quere;
    }
}
