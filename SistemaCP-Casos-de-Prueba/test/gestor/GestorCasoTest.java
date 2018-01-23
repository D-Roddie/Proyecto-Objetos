/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.time.LocalDate;
import java.util.ArrayList;
import objetos.Caso;
import objetos.Querellante;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class GestorCasoTest {

    public GestorCasoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Prueba del metodo registrarCaso, de la clase GestorCaso.
     */
    @Test
    public void testRegistrarCaso() throws Exception {
        System.out.println("registrarCaso");
        String numero = "45634";
        int id_demandante = 2;
        int id_mediador = 3;
        int estado = 3;
        LocalDate fecha = LocalDate.now();
        String descripcion = "Roba a mano armada";
        String comentarioInicial = "Muchas pruebas";
        GestorCaso instance = new GestorCaso();
        instance.registrarCaso(numero, id_demandante, id_mediador, estado, fecha, descripcion, comentarioInicial);
    }

    /**
     * Prueba del metodo querellanteIDByCedula de la clase GestorCaso.
     */
    @Test
    public void testQuerellanteIDByCedula() throws Exception {
        System.out.println("querellanteIDByCedula");
        String cedula = "0268-0603";
        GestorCaso instance = new GestorCaso();
        Querellante expResult = instance.querellanteIDByCedula("13");
        Querellante result = instance.querellanteIDByCedula(cedula);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo idJueces de la clase GestorCaso.
     */
    @Test
    public void testIdJueces() throws Exception {
        System.out.println("idJueces");
        GestorCaso instance = new GestorCaso();
        ArrayList<Integer> expResult = instance.idJueces();
        ArrayList<Integer> result = instance.idJueces();
        assertEquals(expResult, result);

    }

    /**
     * Prueba del metodo setRandomJuezId de la clase GestorCaso.
     */
    @Test
    public void testSetRandomJuezId() throws Exception {
        System.out.println("setRandomJuezId");
        GestorCaso instance = new GestorCaso();
        int expResult = 0;
        int result = instance.setRandomJuezId();
        assertEquals(expResult, result);

    }

    /**
     * Prueba del metodo getCasosByJuez de la clase GestorCaso.
     */
    @Test
    public void testGetCasosByJuez() throws Exception {
        System.out.println("getCasosByJuez");
        int id_juez = 23;
        GestorCaso instance = new GestorCaso();
        ArrayList<Caso> expResult = instance.getCasosByJuez(id_juez);
        ArrayList<Caso> result = instance.getCasosByJuez(id_juez);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo getCasosByQuerellante de la clase GestorCaso.
     */
    @Test
    public void testGetCasosByQuerellante() throws Exception {
        System.out.println("getCasosByQuerellante");
        int id_querellante = 17;
        GestorCaso instance = new GestorCaso();
        ArrayList<Caso> expResult = instance.getCasosByQuerellante(id_querellante);
        ArrayList<Caso> result = instance.getCasosByQuerellante(id_querellante);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo getIdCasoByNumero de la clase GestorCaso.
     */
    @Test
    public void testGetIdCasoByNumero() throws Exception {
        System.out.println("getIdCasoByNumero");
        String numeroCaso = "A10";
        GestorCaso instance = new GestorCaso();
        int expResult = 6;
        int result = instance.getIdCasoByNumero(numeroCaso);
        assertEquals(expResult, result);

    }

    /**
     * Prueba de metodo getIdEstadoByIdCaso de la clase GestorCaso.
     */
    @Test
    public void testGetIdEstadoByIdCaso() throws Exception {
        System.out.println("getIdEstadoByIdCaso");
        int idCaso = 8;
        GestorCaso instance = new GestorCaso();
        int expResult = 4;
        int result = instance.getIdEstadoByIdCaso(idCaso);
        assertEquals(expResult, result);

    }

    /**
     * Prueba del metodo modificarEstado de la clase GestorCaso.
     */
    @Test
    public void testModificarEstado() throws Exception {
        System.out.println("modificarEstado");
        int idEstado = 3;
        String comentario = "Llamar a victima";
        int idCaso = 7;
        GestorCaso instance = new GestorCaso();
        instance.modificarEstado(idEstado, comentario, idCaso);
    }

    /**
     * Prueba del metodo registrarHistorial de la clase GestorCaso.
     */
    @Test
    public void testRegistrarHistorial() throws Exception {
        System.out.println("registrarHistorial");
        String comentario = "Pruebas validas";
        int idEstado = 2;
        int idCaso = 12;
        LocalDate fechaCambio = LocalDate.now();
        GestorCaso instance = new GestorCaso();
        instance.registrarHistorial(comentario, idEstado, idCaso, fechaCambio);

    }

    /**
     * Prueba del metodo getComentarioByIdCaso de la clase GestorCaso.
     */
    @Test
    public void testGetComentarioByIdCaso() throws Exception {
        System.out.println("getComentarioByIdCaso");
        int idCaso = 7;
        GestorCaso instance = new GestorCaso();
        String expResult = instance.getComentarioByIdCaso(idCaso);
        String result = instance.getComentarioByIdCaso(idCaso);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo getEstadoById de la clase GestorCaso.
     */
    @Test
    public void testGetEstadoById() throws Exception {
        System.out.println("getEstadoById");
        int idEstado = 3;
        GestorCaso instance = new GestorCaso();
        String expResult = "Consulta";
        String result = instance.getEstadoById(idEstado);
        assertEquals(expResult, result);

    }

    /**
     * Prueba del metodo getHistorialByCaso de la clase GestorCaso.
     */
    @Test
    public void testGetHistorialByCaso() throws Exception {
        System.out.println("getHistorialByCaso");
        int idCaso = 10;
        GestorCaso instance = new GestorCaso();
        ArrayList<Caso> expResult = instance.getHistorialByCaso(idCaso);;
        ArrayList<Caso> result = instance.getHistorialByCaso(idCaso);
        assertEquals(expResult, result);
    }

}
