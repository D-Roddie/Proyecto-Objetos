/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.ArrayList;
import objetos.Juez;
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
public class GestorJuezTest {

    public GestorJuezTest() {
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
     * Prueba del metodo registrarJuez de la clase GestorJuez.
     */
    @Test
    public void testRegistrarJuez() throws Exception {
        System.out.println("registrarJuez");
        String nombre = "Juanito";
        String apellido1 = "Manzana";
        String apellido2 = "Perez";
        String cedula = "2345234";
        String telefono = "2228-9983";
        String numero_sala = "26";
        String usuario = "juanza";
        String clave = "123";
        GestorJuez instance = new GestorJuez();
        instance.registrarJuez(nombre, apellido1, apellido2, cedula, telefono, numero_sala, usuario, clave);
    }

    /**
     * Prueba del metodo listarJuez de la clase GestorJuez.
     */
    @Test
    public void testListarJuez() throws Exception {
        System.out.println("listarJuez");
        GestorJuez instance = new GestorJuez();
        ArrayList<Juez> expResult = instance.listarJuez();
        ArrayList<Juez> result = instance.listarJuez();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo inicioSesion de la clase GestorJuez.
     */
    @Test
    public void testInicioSesion() throws Exception {
        System.out.println("inicioSesion");
        String username = "mariam";
        String password = "123";
        GestorJuez instance = new GestorJuez();
        Juez expResult = instance.inicioSesion(username, password);
        Juez result = instance.inicioSesion(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo getJuezIdByUsername de la clase GestorJuez.
     */
    @Test
    public void testGetJuezIdByUsername() throws Exception {
        System.out.println("getJuezIdByUsername");
        String usernme = "kila";
        GestorJuez instance = new GestorJuez();
        int expResult = 17;
        int result = instance.getJuezIdByUsername(usernme);
        assertEquals(expResult, result);
    }

}
