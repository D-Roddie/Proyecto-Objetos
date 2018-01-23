package multi;

import com.acceso.AccesoBD;
import com.acceso.Conector;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import objetos.Caso;
import objetos.Juez;
import objetos.Querellante;

/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 1.0 6/12/2017
 */
public class MultiCaso {

    private AccesoBD conn;
    
    /**
     * Este metodo crea un query de insercion de datos
     * en la tabla de casos y asi registrar uno
     * @param numero numero de caso
     * @param id_demandante id del querellante 
     * @param id_mediador id del juez
     * @param id_estado id del estado
     * @param fecha fecha de creacion
     * @param descripcion descripcion del caso
     * @param comentarioInicial detalle del caso
     * @throws Exception 
     */
    public void crear(String numero, int id_demandante, int id_mediador, int id_estado, LocalDate fecha, String descripcion, String comentarioInicial) throws Exception {

        String query;
        query = "INSERT INTO tCaso(numero_caso, descripcion, fecha_registro, id_estado, id_juez, id_querellante, comentario_estado)"
                + "VALUES ('" + numero + "','" + descripcion + "', '" + fecha + "'," + id_estado + " , " + id_mediador + " , " + id_demandante + ", '"+comentarioInicial+"' );";

        conn = new Conector().getConector();

        conn.ejecutarSQL(query);
        conn.finalize();

    }
    /**
     * Este metodo obtiene por medio de un query a la base de datos
     * el id del querellante registrado dependiendo de la 
     * cedula que se pase ccomo parametro
     * @param cedula cedula del querellante
     * @return Querellante id
     * @throws Exception 
     */
    public Querellante querellanteIDByCedula(String cedula) throws Exception {
        String query = "select id_querellante from tQuerellante where cedula = '" + cedula + "';";
        Querellante miQuere = null;

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            miQuere = new Querellante(rs.getInt("id_querellante"));
        }

        return miQuere;

    }
    /**
     * Metodo que llena un ArrayList de integer por medio
     * de un query a la base de datos guardando
     * todos los id's de los jueces registrados
     * @return ArrayList de integers con todos los id's de jueces
     * @throws Exception 
     */
    public ArrayList<Integer> listarIdsJuez() throws Exception {
        ArrayList<Integer> listJuez = new ArrayList<>();

        String query;
        query = "SELECT id_juez FROM tJuez";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        while (rs.next()) {
            int juez = (rs.getInt("id_juez"));

            listJuez.add(juez);
        }
        conn.finalize();
        return listJuez;

    }
    /**
     * Metodo que llena un ArrayList con los casos
     * de un juez en particula, dependiendo del id 
     * del juez que se pase como parametro
     * @param id_juez id del juez al que se filtraran los casos
     * @return ArrayList de casos por juez
     * @throws SQLException
     * @throws Exception 
     */
    public ArrayList<Caso> getListaCasosByJuez(int id_juez) throws SQLException, Exception {

        ArrayList<Caso> listCasos = new ArrayList<>();
        String query = "select numero_caso, fecha_registro, id_querellante, descripcion, "
                + "id_estado, comentario_estado from tCaso  where id_juez =  "+id_juez+"";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        MultiQuerellante multi = new MultiQuerellante();    
        while (rs.next()) {
            Date d = rs.getDate("fecha_registro");
            listCasos.add(new Caso(rs.getString(1), d.toLocalDate(), 
                    multi.getQuerellanteById(rs.getInt(3)), getEstadoById(rs.getInt("id_estado")), 
                    rs.getString("descripcion"), rs.getString("comentario_estado")));

        }
        conn.finalize();
        return listCasos;
    }
    
    /**
     * Metodo que obtiene un ArrayList de casos por querellante, 
     * recibe el id del querellante
     * @param id_querellante id del querellante a filtrar
     * @return ArrayList de casos por querellante
     * @throws SQLException
     * @throws Exception 
     */
    public ArrayList<Caso> getListaCasosByQuerellante(int id_querellante) throws SQLException, Exception {

        ArrayList<Caso> listCasos = new ArrayList<>();
        String query = "select numero_caso, fecha_registro, id_juez, descripcion, id_estado, comentario_estado "
                + "from tCaso  where id_querellante =  "+id_querellante+"";

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        MultiJuez mulJuez = new MultiJuez();
        while (rs.next()) {
            Date d = rs.getDate("fecha_registro");
            listCasos.add(new Caso(rs.getString(1), d.toLocalDate(), 
                    mulJuez.getJuezById(rs.getInt(3)), getEstadoById(rs.getInt("id_estado")), 
                    rs.getString("descripcion"), rs.getString("comentario_estado")));

        }
        conn.finalize();
        return listCasos;
    }
    
    /**
     * Metodo que retorna el nombre del estado
     * registrado en la base de datos por id del estado recibido
     * @param id_estado id del estado a filtrar
     * @return String con el nombre del estado
     * @throws Exception 
     */
    public String getEstadoById(int id_estado) throws Exception{

        String query = "SELECT nombre_estado FROM tEstado "
                + "WHERE id_estado = '"+ id_estado +"';";
          

        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
        String nombre = "";
        while (rs.next()) {
            nombre = (rs.getString(1) );  
        }

        conn.finalize();

        return nombre;
    }
    /**
     * Metodo que retorna el id del caso por el numero
     * de este
     * @param numeroCaso numero de caso a filtrar
     * @return int id del caso
     * @throws Exception 
     */
    public int getIdCasoByNumero(String numeroCaso) throws Exception{
        int id_caso = 0;
        
        String query = "select id_caso from tCaso where numero_caso = '"+numeroCaso+"' ;";
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
 
        while (rs.next()) {
            id_caso = rs.getInt("id_caso");  
        }

        conn.finalize();

        
        return id_caso;
    }
    /**
     * Obtiene el id del estado por medio
     * del id del caso
     * @param idCaso id del caso a filtrar
     * @return int id de estado
     * @throws Exception 
     */
    public int getIdEstadoByIdCaso(int idCaso) throws Exception{
        int id_estado = 0;
        
        String query = "select id_estado from tCaso where id_caso = "+idCaso+";";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
 
        while (rs.next()) {
            id_estado = rs.getInt("id_estado");  
        }

        conn.finalize();
        
        return id_estado;
    }
    
    /**
     * Actualiza el estado y detalle del caso, recibe el id del estado al
     * que se modificara , el detalle de cambio de estado y el id del
     * caso que sera actualizado
     * 
     * @param idEstado id de estado al que se cambiara
     * @param comentario detalle del estado a cambiar
     * @param idCaso id del caso que se modificara
     * @throws Exception 
     */
    public void updateCaso(int idEstado, String comentario, int idCaso) throws Exception{
        String query = "update tCaso "
                + "set id_estado = "+idEstado+", comentario_estado = '"+comentario+"' "
                + "where id_caso = "+idCaso+";";
        
        
        conn = new Conector().getConector();

        conn.ejecutarSQL(query);
        conn.finalize();

        
    }
    /**
     * Metodo que por medio de un query registra en la tabla
     * historial todas lo modificaciones hechas en un caso
     * @param comentario detalle del cambio
     * @param idEstado id del estado cambiado
     * @param idCaso id del caso a registrar
     * @param fechaCambio fecha en la que se hizo el cambio
     * @throws Exception 
     */
    public void insertarHistorial(String comentario, int idEstado, int idCaso, LocalDate fechaCambio) throws Exception{
        String query = "insert into tHistorialCasos(comentario_estado, id_estado, id_caso, fecha_cambio)" +
                        "values ('"+comentario+"', "+idEstado+" , "+idCaso+", '"+fechaCambio+"');";
        
        
        conn = new Conector().getConector();

        conn.ejecutarSQL(query);
        conn.finalize();
    }
    
    /**
     * Metodo que obtiene el detalle del caso
     * por medio del id de este
     * @param idCaso id del caso a obtener la información
     * @return String con el actual del caso
     * @throws Exception 
     */
    public String getComentarioByIdCaso(int idCaso) throws Exception{
     
        String comentario = "";
        String query = "select comentario_estado from tCaso where id_caso = "+idCaso+";";
        
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);
 
        while (rs.next()) {
            comentario = rs.getString("comentario_estado");  
        }

        conn.finalize();
        
        return comentario;
    }
    /**
     * Llena un ArrayList con el historial de el caso
     * @param idCaso id del caso a buscar el historial
     * @return ArrayList de caso
     * @throws Exception 
     */
    public ArrayList<Caso> getHistorialCaso(int idCaso) throws Exception{
        String query = "select comentario_estado, id_estado, fecha_cambio from tHistorialCasos where id_caso = "+idCaso+";";
        ArrayList<Caso> listCasos = new ArrayList<>();
        conn = new Conector().getConector();

        ResultSet rs = conn.ejecutarSQL(query, true);

        
        while (rs.next()) {
            Date d = rs.getDate("fecha_cambio");
            listCasos.add(new Caso( d.toLocalDate(), rs.getString("comentario_estado"), getEstadoById(rs.getInt("id_estado"))));

        }
        conn.finalize();
        return listCasos;
    }
}

