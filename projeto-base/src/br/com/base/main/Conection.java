/**
 * 
 */
package br.com.base.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author professor
 *
 */
public class Conection {
	
	public static Connection getConnection() throws SQLException {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/base", "root", "");
			System.out.println("Conectado!");
			return conexao;
			
		}catch(Exception e) {
			
			System.out.println("Error: " +e.getMessage());
			return null;
		}
	}
	
	public static void close(Connection conexao) {
		try {
			conexao.close();
		}catch(Exception e){
			System.out.println("Error: " +e.getMessage());
		}
		
	}
}
