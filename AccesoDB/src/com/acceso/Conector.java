package com.acceso;

/**
 * Clase Conector
 *
 * @version 1.0
 * @author Laura Monge Izaguirre Clase que inicializa la conexion con los
 * valores correctos y permite manejar una unica conexion para todo el proyecto
 * y
 *
 */
import java.io.*;
import java.util.TreeMap;
import java.util.Properties;

public class Conector {
    //atributo de la clase	 

    private AccesoBD conectorBD = null;

    public Conector() {

    }

    /**
     * Metodo  que devuelve el objeto AccesoBD para que sea utilizado
     * por las clases
     *
     * @return objeto del tipo AccesoBD del paquete CapaAccesoDatos
     * @throws java.sql.SQLException
     */
    public AccesoBD getConector() throws java.sql.SQLException, Exception {

        TreeMap param = getConfiguration();
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        if (conectorBD == null) {
            String connectionUrl = "jdbc:sqlserver://" + param.get("servername").toString()
                    + ":" + param.get("portnumber").toString() + ";DatabaseName="
                    + param.get("databasename") + ";user=" + param.get("user") + ";password=" + param.get("password").toString() + ";";

            conectorBD = new AccesoBD(driver, connectionUrl, param.get("user").toString(), param.get("password").toString());
        }

        return conectorBD;
    }
    /**
     * Metodo que guarda en un treemap un archivo .properties
     * para poder cambiar los credenciales de conexion a la base de datos
     * @return treemap con la configuracion de la conexion
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public TreeMap getConfiguration() throws FileNotFoundException, IOException {
        Properties propiedades = new Properties();
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/database.properties");

        propiedades.load(input);
        TreeMap datosConfiguracion = new TreeMap();

        datosConfiguracion.put("servername", propiedades.getProperty("servername"));
        datosConfiguracion.put("password", propiedades.getProperty("password"));
        datosConfiguracion.put("databasename", propiedades.getProperty("databasename"));
        datosConfiguracion.put("user", propiedades.getProperty("user"));
        datosConfiguracion.put("portnumber", propiedades.getProperty("portnumber"));

        return datosConfiguracion;
    }

}
