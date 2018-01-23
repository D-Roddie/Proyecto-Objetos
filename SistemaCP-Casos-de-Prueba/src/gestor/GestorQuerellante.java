package gestor;

import multi.MultiQuerellante;
import objetos.Querellante;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 1.0 6/12/2017
 */
public class GestorQuerellante {
    
    
    /**
     * Recibe y enevia los parametros para registrar un querellante
     * @param nombre nombre del querellante
     * @param apellido1 apellido paterno del querellante
     * @param apellido2 apellido mmaterno del querellante
     * @param cedula cedula del querellante 
     * @param telefono telefono del querellante
     * @param direccion direccion del querellante
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws Exception 
     */
    public void registarQuerellante(String nombre, String apellido1, String apellido2, String cedula, String telefono, String direccion) throws ClassNotFoundException, SQLException, Exception {
        MultiQuerellante querellanteNuevo = new MultiQuerellante();
        querellanteNuevo.registarQuerellante(nombre, apellido1, apellido2, cedula, telefono, direccion);
    }
    /**
     * Llena un ArrayList de querellante 
     * 
     * @return ArrayList de querellantes 
     * @throws Exception 
     */
    public ArrayList<Querellante> listarQuerellante() throws Exception {
        MultiQuerellante querellanteNuevo = new MultiQuerellante();
        ArrayList<Querellante> listQuerellanteMulti = querellanteNuevo.listarQuerellante();

        return listQuerellanteMulti;

    }
    /**
     * Recibe la cedula del querellante que 
     * esta haciendo login
     * @param cedula cedula del querellante que hara log in
     * @return un querellante 
     * @throws Exception 
     */
    public Querellante inicioSesion(String cedula) throws Exception {
        MultiQuerellante querellanteNuevo = new MultiQuerellante();
        Querellante miQuerellante = querellanteNuevo.logIn(cedula);

        return miQuerellante;
    }
    /**
     * Recibe una cedula para devolver el
     * nombre del querellante
     * @param cedula cedula del querellante al que se quiere el nombre
     * @return String con el nombre del querellante
     * @throws Exception 
     */
    public String nombreByCedula(String cedula) throws Exception {
        MultiQuerellante querellanteNuevo = new MultiQuerellante();
        String nombreQuere = querellanteNuevo.nombreByCedula(cedula);

        return nombreQuere;
    }
    /**
     * Recibe la cedula de un querellante y devuelve el 
     * id de este 
     * @param cedula cedula del querellante 
     * @return int id del qurellante
     * @throws Exception 
     */
    public int getQuerellanteIdByCedula(String cedula) throws Exception{
        MultiQuerellante juez = new MultiQuerellante();
        int id_querellante = juez.getIdByCedula(cedula) ;
        
        return id_querellante;
    }
}
