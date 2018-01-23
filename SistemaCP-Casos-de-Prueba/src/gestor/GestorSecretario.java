package gestor;


import multi.MultiSecretario;
import objetos.Secretario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 1.0 6/12/2017
 */
public class GestorSecretario {
    /**
     * Recibe a los parametros para ser mandados al multi
     * para registralos en la base de datos
     * @param nombre   nombre del secretario
     * @param apellido1 apellido paterno del secretario
     * @param apellido2 apellido materno del secretario
     * @param telefono telefono del secretario 
     * @param usuario nombre de usuario del secretario
     * @param clave contraseña del secretario
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws Exception 
     */
    public void registrarSecretario(String nombre, String apellido1, String apellido2, String telefono, String usuario, String clave) throws ClassNotFoundException, SQLException, Exception {
        MultiSecretario secretarioNuevo = new MultiSecretario();
        secretarioNuevo.crear(nombre, apellido1, apellido2, telefono, usuario, clave);
    }
    
    /**
     * Este metodo guarda en un ArrayList de secretario 
     * al secretario de la corte registrado
     * @return ArrayList de secretario
     * @throws Exception 
     */
    public ArrayList<Secretario> listarSecretario() throws Exception {
        MultiSecretario multi = new MultiSecretario();
        ArrayList<Secretario> listSecretarioMulti = multi.listarSecretario();

        return listSecretarioMulti;

    }
    
    
    /**
     * Recibe el nombre de usuario y la contraseña del formulario de login del
     * secretario
     *
     * @param username nombre de usuario del secretario que hara log in
     * @param password contraseña del secretario que hara log in
     * @throws java.sql.SQLException
     */
    public Secretario inicioSesion(String username, String password) throws SQLException, Exception {
        MultiSecretario multi = new MultiSecretario();
        Secretario miSecretario = multi.logIn(username, password);
        return miSecretario;
    }

}
