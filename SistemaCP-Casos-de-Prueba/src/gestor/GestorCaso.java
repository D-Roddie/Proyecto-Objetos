
package gestor;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import multi.MultiCaso;
import objetos.*;

/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 1.0 6/12/2017
 */
public class GestorCaso {
    
    /**
     * Este metodo envia la informacion para ser 
     * registrada en la base de datos
     * @param numero numero de caso
     * @param id_demandante id del querellante
     * @param id_mediador id del juez
     * @param estado estado del caso
     * @param fecha fecha de creacion
     * @param descripcion descripcion del caso
     * @param comentarioInicial comentario inicial de estado
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws Exception 
     */
    public void registrarCaso(String numero, int id_demandante, int id_mediador, int estado, LocalDate fecha, String descripcion, String comentarioInicial) throws ClassNotFoundException, SQLException, Exception {
        MultiCaso caso = new MultiCaso();           
        caso.crear(numero, id_demandante, id_mediador, estado, fecha, descripcion, comentarioInicial);
    }
    /**
     * Este metodo guarda el id de un querellante
     * registrado en la base de datos
     * @param cedula
     * @return
     * @throws Exception 
     */
    public Querellante querellanteIDByCedula(String cedula) throws Exception{
        Querellante miQuerellante;
        MultiCaso caso = new MultiCaso();
        miQuerellante = caso.querellanteIDByCedula(cedula);
        
        return miQuerellante;
    }
    /**
     * Este metodo guarda todos los id de los jueces
     * registrados en la base de datos
     * @return Arraylist de id de jueces registrados
     * @throws Exception 
     */
    public ArrayList<Integer> idJueces() throws Exception{
        MultiCaso juezNuevo = new MultiCaso();
        ArrayList<Integer> listJuezMulti = juezNuevo.listarIdsJuez();

        return listJuezMulti;
    }
    /**
     * Este metodo devuelve el id de un juez
     * de manera aleatoria
     * @return id de un juez
     * @throws Exception 
     */
    public int setRandomJuezId() throws Exception{
        int randomID = 0;
        ArrayList<Integer> listJuezMulti = idJueces();
        
        Random randomizer = new Random();
        randomID = listJuezMulti.get(randomizer.nextInt( listJuezMulti.size()));
        
        return randomID;
    }
    /**
     * Este metodo retorna los casos de un juez
     * @param id_juez id del juez a buscar
     * @return ArrayList de casos
     * @throws Exception 
     */    
    public ArrayList<Caso> getCasosByJuez(int id_juez) throws Exception{
        ArrayList<Caso> listCasosMulti;
        MultiCaso casoNuevo = new MultiCaso();
        listCasosMulti = casoNuevo.getListaCasosByJuez(id_juez);
        
        return listCasosMulti;
    }
    /**
     * Este metodo retorna los casos de un querellante
     * @param id_querellante id de un querellante a buscar
     * @return ArrayList de casos
     * @throws Exception 
     */
    public ArrayList<Caso> getCasosByQuerellante(int id_querellante) throws Exception{
        ArrayList<Caso> listCasosMulti;
        MultiCaso casoNuevo = new MultiCaso();
        listCasosMulti = casoNuevo.getListaCasosByQuerellante(id_querellante);
        
        return listCasosMulti;
    }
    /**
     * Este metodo retorna el id de un caso registrado en la base de datos
     * dependiendo del numero de caso 
     * @param numeroCaso numero de un caso
     * @return retorna un id de un caso
     * @throws Exception 
     */
    public int getIdCasoByNumero(String numeroCaso) throws Exception{
        int id_caso;
        MultiCaso caso = new MultiCaso();
        id_caso = caso.getIdCasoByNumero(numeroCaso);
        
        return id_caso;
    }
    /**
     * Este metodo retorna el id de un estado dependiendo
     * del id del caso que se solicite
     * @param idCaso id del caso 
     * @return id de estado 
     * @throws Exception 
     */
    public int getIdEstadoByIdCaso(int idCaso) throws Exception{
        int idEstado;
        MultiCaso caso = new MultiCaso();
        idEstado = caso.getIdEstadoByIdCaso(idCaso);
        
        return idEstado;
    }
    /**
     * Este metodo recibe los parametros para modificar un caso en la base
     * de datos
     * @param idEstado id del estado al que se pasara el caso
     * @param comentario detalle del caso que se desea modificar
     * @param idCaso id del caso a modificar
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws Exception 
     */
    public void modificarEstado(int idEstado, String comentario, int idCaso) throws ClassNotFoundException, SQLException, Exception {
        MultiCaso caso = new MultiCaso();           
        caso.updateCaso(idEstado, comentario, idCaso);
    }
    /**
     * Este metodo recibe los parametros a registrar en el historial y se 
     * los pasa al multi para insertalos en la base de datos
     * @param comentario detalle de cambio de caso
     * @param idEstado id del estado a registrar
     * @param idCaso id del caso a registrar
     * @param fechaCambio fecha en la que se hizo el cambio
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws Exception 
     */
    public void registrarHistorial(String comentario, int idEstado, int idCaso, LocalDate fechaCambio) throws ClassNotFoundException, SQLException, Exception {
        MultiCaso caso = new MultiCaso();           
        caso.insertarHistorial(comentario, idEstado, idCaso, fechaCambio);
    }
    /**
     * Obtiene el dellate del estado por medio del id
     * del caso que recibe como parametro
     * @param idCaso id del caso a obtener el detalle
     * @return String con el detalle del caso
     * @throws Exception 
     */
    public String getComentarioByIdCaso(int idCaso) throws Exception{
        String detalle;
        MultiCaso caso = new MultiCaso();
        detalle = caso.getComentarioByIdCaso(idCaso);
        
        return detalle;
    }
    /**
     * Recibe el id del estado del cual se obtiene 
     * el nombre 
     * @param idEstado id del estado a buscar
     * @return String con el nombre de estado segun el id del estado
     * @throws Exception 
     */
    public String getEstadoById(int idEstado) throws Exception{
        String nombreCaso;
        MultiCaso caso = new MultiCaso();
        nombreCaso = caso.getEstadoById(idEstado);
        
        return nombreCaso;
    }
    /**
     * Obtiene un arraylist de casos segun el id de este
     * @param idCaso id del caso a buscar el historial
     * @return ArrayList de casos 
     * @throws Exception 
     */
    public ArrayList<Caso> getHistorialByCaso(int idCaso) throws Exception{
        ArrayList<Caso> listCasosMulti;
        MultiCaso casoNuevo = new MultiCaso();
        listCasosMulti = casoNuevo.getHistorialCaso(idCaso);
        
        return listCasosMulti;
    }
}


