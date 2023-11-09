package conexion;

import java.sql.*;

public class Conexion {
//  Las variables estaticas pueden ser accedidas desde otras clases sin necesidad de crear un objeto de dicha clase
//  Al indicar que una variables es final significa que no podra ser modificada despues

//  Cadena de conexion con mysql
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_farmacia?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
//  Aca especificamos el usuario
	private static final String JDBC_USER = "root";
//  Aca la contraseña de mysql
	private static final String JDBC_PASSWORD = "123456";

	// Metodo para obtener la conexion a al base de datos
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}

//  Metodos para cerrar

//  El metopdo resultset nos permite utilizar metodos para obtener datos de columnas correspondientes a una fila
	public static void close(ResultSet rs) throws SQLException {
		rs.close();
	}

//  Statement sirve para procesar una sentencia sql y obtener sus resultados
	public static void close(Statement smtm) throws SQLException {
		smtm.close();
	}

//  PreparedStatement nos permite utilizar metodos para establecer parametros 
	public static void close(PreparedStatement smtm) throws SQLException {
		smtm.close();
	}

//  Connection, se encarga de hacer la conexion
	public static void close(Connection conn) throws SQLException {
		conn.close();
	}

}
