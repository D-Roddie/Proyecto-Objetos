package objetos;

/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 2.0 17/12/2017
 */
public class Juez extends Persona {

    private int id_juez;
    private String numero_sala;
    private String usuario;
    private String clave;
    private String cedula;
    /**
     * Constructor del juez que recibe todos los atributos del objeto Juez
     * @param id_juez id del juez  
     * @param nombre nombre del juez
     * @param apellido1 apellido paterno del juez
     * @param apellido2 apellido materno del juez
     * @param cedula cedula del juez
     * @param telefono telefono del juez
     * @param numero_sala numero de sala del juez
     * @param usuario nombre de usuario del juez
     * @param clave contraseña del juez
     */
    public Juez(int id_juez, String nombre, String apellido1, String apellido2, String cedula, String telefono, String numero_sala, String usuario, String clave) {
        super(nombre, apellido1, apellido2, telefono);
        this.id_juez = id_juez;
        this.numero_sala = numero_sala;
        this.usuario = usuario;
        this.clave = clave;
        this.cedula = cedula;
    }
    /**
     * Constructor que recibe los atributos de usuario y clave
     * @param usuario nombre de usuario del juez
     * @param clave contraseña del juez
     */
    public Juez(String usuario, String clave) {
        super();
        this.usuario = usuario;
        this.clave = clave;
    }
    /**
     * Constructor que recibe el nombre completo del juez
     * @param nombre nombre del juez
     * @param apellido1 apellido paterno del juez
     * @param apellido2 apellido materno del juez
     */
    public Juez(String nombre, String apellido1, String apellido2) {
        super(nombre, apellido1, apellido2);
    }
    
    

    public Juez(int id_juez) {
        this.id_juez = id_juez;
    }

    public int getId_juez() {
        return id_juez;
    }

    public void setId_juez(int id_juez) {
        this.id_juez = id_juez;
    }

    public String getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(String numero_sala) {
        this.numero_sala = numero_sala;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return  nombre + " " + apellido1 + " " + apellido2 ;
    }

}
