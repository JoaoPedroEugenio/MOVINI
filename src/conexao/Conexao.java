package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private String usuario = "postgres";
	private String senha = "admin";
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	
	public Connection getConexao() {
		try {		
			return DriverManager.getConnection(url,usuario,senha);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public boolean close(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
}
