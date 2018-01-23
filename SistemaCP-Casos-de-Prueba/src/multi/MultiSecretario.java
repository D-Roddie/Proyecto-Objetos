package multi;

import com.acceso.Conector;
import objetos.Secretario;
import com.acceso.AccesoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 1.0 6/12/2017
 */
public class MultiSecretario {

    private AccesoBD conn;
    /**
     * Inserta los parametros recibidos en una tabla de
     * la base de datos
     * @param nombre nombre del secretario de justicia
     * @param apellido1 apellido paterno del secretario
     * @param apellido2 apellido materno del seretario
     * @param telefono telefono del secretario
     * @param usuario nombre de usuario del secretario
     * @param clave contaseña del secretario
     * @throws Exception 
     */
    public void crear(String nombre, String apellido1, String apellido2, String telefono, String usuario, String clave) throws Exception {

        String query;
        query = "INSERT INTO tSecretario(nombre,apellido1,apellido2,telefono ,usuario, clave)" +
                "VALUES ('"+nombre+"','"+apellido1+"','"+apellido2+"','"+telefono+"','"+usuario+"', '"+clave+"')";

        conn = new Conector().getConector();

        conn.ejecutarSQL(query);

    }
    /**
     * Llena un ArrayList con secretario de la corte
     * @return ArrauList de secretario
     * @throws Exception 
     */
    public ArrayList<Secretario> listarSecretario() throws Exception {
        ArrayList<Secretario> listSecretario = new ArrayList<>();

        String query;
        query = "SELECT * FROM tSecretario";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        while (rs.next()) {
            Secretario miSecretario = new Secretario(
                    rs.getInt("id_secretario"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getString("telefono"),
                    rs.getString("usuario"),
                    rs.getString("clave"));

            listSecretario.add(miSecretario);
        }
        return listSecretario;

    }

    /**
     * Busca el nombre de usuario y la contraseña de un juez en la base de
     * datos, y lo asigna al constructor del juez si conincide, devolviendo al
     * juez encontrado
     *
     * @param username nombre de usuario del juez a buscar en la base de datos
     * @param password contraseña a buscar en la base de datos
     * @return juez de tipo Juez
     * @throws SQLException excepción de Sql
     * @throws Exception
     */
    public Secretario logIn(String username, String password) throws SQLException, Exception {

        Secretario miSecretario = null;

        String query = "SELECT usuario, clave FROM tSecretario WHERE usuario = '" + username + "'"
                + " AND clave = '" + password + "'";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            miSecretario = new Secretario(rs.getString("usuario"), rs.getString("clave"));
        }

        return miSecretario;
    }
}
