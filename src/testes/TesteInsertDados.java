package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Javadb.jdbc.ConnectionFactory;

public class TesteInsertDados {
	public static void main(String[] args) throws SQLException  {
    Connection con = null;
    try {
         con = new ConnectionFactory().getConnection();
         String sql = " insert into clientes(nome,email,endereco) values (?,?,?)";
         PreparedStatement stmt;
         stmt = con.prepareStatement(sql);
         stmt.setString(1, "Maria");
         stmt.setString(2, "maria@maria.com");
         stmt.setString(3, "Av. Brasil, 100");
         
         stmt.execute();
         stmt.close();
         System.out.println("Gravado com sucesso !");
        con.close();      
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		con.close();
	}
    
    
	}
}
