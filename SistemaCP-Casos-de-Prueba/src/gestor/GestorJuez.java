package gestor;

import multi.MultiJuez;
import objetos.Juez;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 1.0 6/12/2017
 */
public class GestorJuez {
    /**
     * Registra a un juez en la base de datos con 
     * los parametros que que recibe
     * @param nombre nombre del juez
     * @param apellido1 apellido paterno del juez
     * @param apellido2 apellido materno del juez
     * @param cedula cedula de identificacion del juez
     * @param telefono telefono del juez
     * @param numero_sala numero de sala a la que pertenece el juez
     * @param usuario nombre de usuario del juez
     * @param clave contraseña del juez
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws Exception 
     */
    public void registrarJuez(String nombre, String apellido1, String apellido2, String cedula, String telefono, String numero_sala, String usuario, String clave) throws ClassNotFoundException, SQLException, Exception {
        MultiJuez juezNuevo = new MultiJuez();
        juezNuevo.crear(nombre, apellido1, apellido2, cedula, telefono, numero_sala, usuario, clave);
    }
    /**
     * Guarda a los jueces en un ArrayList de jueces
     * @return ArrayList de jueces 
     * @throws Exception 
     */
    public ArrayList<Juez> listarJuez() throws Exception {
        MultiJuez juezNuevo = new MultiJuez();
        ArrayList<Juez> listJuezMulti = juezNuevo.listarJuez();

        return listJuezMulti;

    }

    /**
     * Recibe el nombre de usuario y la contraseña del formulario de login del
     * juez
     *
     * @param username nombre de usuario del juez que hara log in
     * @param password contraseña del juez que hara log in
     * @throws java.sql.SQLException
     */
    public Juez inicioSesion(String username, String password) throws SQLException, Exception {
        MultiJuez juez = new MultiJuez();
        Juez miJuez = juez.logIn(username, password);
        return miJuez;
    }
    
    /**
     * Obtiene el id del juez por medio del nombre de usuario
     * @param usernme nombre de usuario de juez
     * @return int id del juez
     * @throws Exception 
     */
    public int getJuezIdByUsername(String usernme) throws Exception{
        MultiJuez juez = new MultiJuez();
        int id_juez = juez.getJuezIdByUsername(usernme) ;
        
        return id_juez;
    }
    
    
}
