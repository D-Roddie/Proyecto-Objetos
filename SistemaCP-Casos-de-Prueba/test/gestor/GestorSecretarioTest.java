/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.ArrayList;
import objetos.Secretario;
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
public class GestorSecretarioTest {

    public GestorSecretarioTest() {
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
     * Prueba del metodo registrarSecretario de la clase GestorSecretario.
     */
    @Test
    public void testRegistrarSecretario() throws Exception {
        System.out.println("registrarSecretario");
        String nombre = "Marta";
        String apellido1 = "Gonzales";
        String apellido2 = "Morales";
        String telefono = "1234-1233";
        String usuario = "martagon";
        String clave = "123";
        GestorSecretario instance = new GestorSecretario();
        instance.registrarSecretario(nombre, apellido1, apellido2, telefono, usuario, clave);
    }

    /**
     * Prueba del metodo listarSecretario de la clase GestorSecretario.
     */
    @Test
    public void testListarSecretario() throws Exception {
        System.out.println("listarSecretario");
        GestorSecretario instance = new GestorSecretario();
        ArrayList<Secretario> expResult = instance.listarSecretario();
        ArrayList<Secretario> result = instance.listarSecretario();
        assertEquals(expResult, result);

    }

    /**
     * Prueba del metodo inicioSesion de la clase GestorSecretario.
     */
    @Test
    public void testInicioSesion() throws Exception {
        System.out.println("inicioSesion");
        String username = "";
        String password = "";
        GestorSecretario instance = new GestorSecretario();
        Secretario expResult = instance.inicioSesion("admin", "admin");
        Secretario result = instance.inicioSesion(username, password);
        assertEquals(expResult, result);
    }

}
