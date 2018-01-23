package objetos;
/**
 * @author Mariam Dominguez y Daniel Rodriguez
 * @version 1.0 6/12/2017
 */
public class Querellante extends Persona {

    private int id_querellante;
    private String cedula;
    private String direccion;
    /**
     * Constructor que recibe los atributos 
     * para registrar a un querellante
     * @param nombre nombre del querellante
     * @param apellido1 apellido paterno del querellante
     * @param apellido2 apellido materno del querellante
     * @param cedula cedual del querellante
     * @param telefono telefono del querellante
     * @param direccion direccion del querellante
     */
    public Querellante(String nombre, String apellido1, String apellido2, String cedula, String telefono, String direccion) {
        super(nombre, apellido1, apellido2, telefono);
        this.cedula = cedula;
        this.direccion = direccion;
    }
    /**
     * Constructor que recibe el id del querellante
     *
     * @param id_querellante id del querellante
     */
    public Querellante(int id_querellante) {
        this.id_querellante = id_querellante;
    }
    /**
     * Constructor que recibe el nombre completo dle querellante
     * @param nombre nombre del querellante
     * @param apellido1 apellido paterno del querellante
     * @param apellido2 apellido materno del querellante
     */
    public Querellante(String nombre, String apellido1, String apellido2) {
        super(nombre, apellido1, apellido2);
    }
    /**
     * Constructor que recibe la cedula de un querellante
     * @param cedula cedula del querellante
     */
    public Querellante(String cedula) {
        this.cedula = cedula;
    }
    
    public int getId_querellante() {
        return id_querellante;
    }

    public void setId_querellante(int id_querellante) {
        this.id_querellante = id_querellante;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido1 + " " + apellido2;
    }

}
