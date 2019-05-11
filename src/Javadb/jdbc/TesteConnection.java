package Javadb.jdbc;

import java.sql.Connection;

public class TesteConnection {
	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("ok, conexao aberta");
	//	con.close();
		
	}

}
