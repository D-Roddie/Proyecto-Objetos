/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.ArrayList;
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
public class GestorQuerellanteTest {

    public GestorQuerellanteTest() {
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
     * Prueba del metodo registarQuerellante de la clase GestorQuerellante.
     */
    @Test
    public void testRegistarQuerellante() throws Exception {
        System.out.println("registarQuerellante");
        String nombre = "Pepito";
        String apellido1 = "Perez";
        String apellido2 = "Rojas";
        String cedula = "2312-1231";
        String telefono = "3324-2134";
        String direccion = "San Jose";
        GestorQuerellante instance = new GestorQuerellante();
        instance.registarQuerellante(nombre, apellido1, apellido2, cedula, telefono, direccion);
    }

    /**
     * Prueba del metodo listarQuerellante de la clase GestorQuerellante.
     */
    @Test
    public void testListarQuerellante() throws Exception {
        System.out.println("listarQuerellante");
        GestorQuerellante instance = new GestorQuerellante();
        ArrayList<Querellante> expResult = instance.listarQuerellante();
        ArrayList<Querellante> result = instance.listarQuerellante();
        assertEquals(expResult, result);

    }

    /**
     * Prueba del metodo inicioSesion de la clase GestorQuerellante.
     */
    @Test
    public void testInicioSesion() throws Exception {
        System.out.println("inicioSesion");
        String cedula = "14938239";
        GestorQuerellante instance = new GestorQuerellante();
        Querellante expResult = instance.inicioSesion(cedula);
        Querellante result = instance.inicioSesion(cedula);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo nombreByCedula de la clase GestorQuerellante.
     */
    @Test
    public void testNombreByCedula() throws Exception {
        System.out.println("nombreByCedula");
        String cedula = "14938239";
        GestorQuerellante instance = new GestorQuerellante();
        String expResult = "Daniel";
        String result = instance.nombreByCedula(cedula);
        assertEquals(expResult, result);

    }

    /**
     * Prueba del metodo getQuerellanteIdByCedula de la clase GestorQuerellante.
     */
    @Test
    public void testGetQuerellanteIdByCedula() throws Exception {
        System.out.println("getQuerellanteIdByCedula");
        String cedula = "14938239";
        GestorQuerellante instance = new GestorQuerellante();
        int expResult = 23;
        int result = instance.getQuerellanteIdByCedula(cedula);
        assertEquals(expResult, result);
    }

}
