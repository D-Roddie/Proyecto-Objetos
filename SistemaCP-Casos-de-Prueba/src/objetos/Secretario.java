package objetos;
/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 1.0 6/12/2017
 */
public class Secretario extends Persona {

    private int id_secretario;
    private String usuario;
    private String clave;
    /**
     * Constructor que recibe todos los atributos 
     * del obtjeto Secretario
     * @param id_secretario  id del secretario
     * @param nombre nombre del secretario
     * @param apellido1 apellido paterno del secretario
     * @param apellido2 apellid materno del secretario
     * @param telefono telefono del secretario
     * @param usuario nombre de usuario del secretario
     * @param clave contraseña del secretario
     */
    public Secretario(int id_secretario, String nombre , String apellido1, String apellido2, String telefono, String usuario, String clave) {
        super(nombre, apellido1, apellido2, telefono);
        this.id_secretario = id_secretario;
        this.usuario = usuario;
        this.clave = clave;
    }
    /**
     * Constructor que recibe el nombre de usuario
     * y la contraseña del secreatario
     * @param usuario nombre de usuario
     * @param clave contraseña del usuario
     */
    public Secretario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public int getId_secretario() {
        return id_secretario;
    }

    public void setId_secretario(int id_secretario) {
        this.id_secretario = id_secretario;
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

    @Override
    public String toString() {
        return "Secretario{" + "id_secretario=" + id_secretario + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", telefono=" + telefono + ", usuario=" + usuario + ", clave=" + clave + '}';
    }

}
