package com.acceso;

/**
 *Clase AccesoBD
 *@version 2.0
 *@author Laura Monge Izaguirre
 *Clase que maneja el acceso a la base de datos.
 *Se debe hacer una instancia de la
 *clase para poder utilizar sus servicios
 *
 *
 */
import java.sql.*;

public class AccesoBD{
	//atributos del objeto
	private Connection conn=null;
	private Statement st;
	
	/**
	 *M�todo constructor que recibe todos
	 *los parametros necesarios para abrir
	 *una conexi�n valida
	 *@param driver especificacion del tipo
	 *de driver que se utiliza, el cual responde
	 *al repositorio utilizado
	 *@param conexion cadena de conexion con la
	 *base de datos
	 *@param usuario nombre del usuario de la base 
	 *de datos, si no se utiliza, se debe enviar
	 *un string vacio
	 *@param clave palabra clave del usuario
	 *para realizar su autenticacion en la base
	 *de datos
	 */
	public AccesoBD(String driver, String conexion,	String usuario, String clave) throws SQLException,Exception{
		Class.forName(driver);
		conn = DriverManager.getConnection(conexion, usuario, clave);
		st = conn.createStatement(); 
	}
        
        
        public AccesoBD(String driver, String conexion) throws SQLException,Exception{
		Class.forName(driver);
		conn = DriverManager.getConnection(conexion);
		st = conn.createStatement();
	}
        
	/**
	 *Metodo que ejecuta una sentencia en la
	 *base de datos, la cual no tiene retorno,
	 *es decir un insert, delete o update
	 *@param sentencia cadena sql que sera
	 *ejecutada en la base de datos
	 *
	 */
	
	public void ejecutarSQL(String sentencia) 
	throws SQLException,Exception{	
		st.execute(sentencia);		
	}
	
	/**
	 *M�todo que ejecuta una sentencia en la
	 *base de datos y devuelve un ResultSet
	 *con los resultados	 
	 *@param sentencia cadena sql que sera
	 *ejecutada en la base de datos
	 *@param retorno booleana que indica que se
	 *desea un resultado de la consulta
	 */	
	public ResultSet ejecutarSQL(String sentencia,
	boolean retorno)
	throws SQLException,Exception{
		ResultSet rs;
		rs = st.executeQuery(sentencia);
		return rs;
	}
	
	/**
	 *Permite controlar el inicio una transaccion 
	 *desde afuera.  A partir de este momento 
	 *todas las sentencias esperaron la orden para
	 *ser aceptadas en la base de datos
	 *
	 */
	public void iniciarTransaccion()
	throws java.sql.SQLException{
		conn.setAutoCommit(false);	
	}
	
	/**
	 *Permite controlar el termino una transaccion 
	 *desde afuera.  A partir de este momento 
	 *todas las sentencias se ejecturon de forma
	 *individual en la base de datos
	 *
	 */
	
	public void terminarTransaccion()
	throws java.sql.SQLException{
		conn.setAutoCommit(true);
	}
	
	/**
	 *Indica que la transaccion ha sido aceptada
	 *
	 */	
	
	public void aceptarTransaccion()
	throws java.sql.SQLException{
		conn.commit();
	}
	
	/**
	 *Indica que la transaccion debe ser
	 *deshecha porque no se realizo de
	 *forma exitosa
	 *
	 */	
	
	public void deshacerTransaccion()
	throws java.sql.SQLException{
		conn.rollback();	
	}
	
	/**
	 *Metodo sobreescrito de la clase Object
	 *que es invocado por el Garbage Collector
	 *cuando es invocado libera la conexion
	 *abierta durante la creacion del objeto
	 *
	 */
	public void finalize(){
		try {
			conn.close();	
		}
		catch(Exception e){
			/*este metodo es llamado por el
			 *garbage collector, por lo tanto
			 *se atrapa la excepcion pero no se 
			 *reporta*/			
		}
	}				
}