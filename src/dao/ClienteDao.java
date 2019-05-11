package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Javadb.jdbc.ConnectionFactory;
import modelo.Cliente;

public class ClienteDao {
	
	private Connection con;
	
	public ClienteDao() {
		this.con= new ConnectionFactory().getConnection();
		
	}
	
	/*
	 *	 Colocar o metodo de fechamento
	public fechaClienteDao() {
			
		stmt.close();		
	}
	
	*/
	public void inserir(Cliente cliente) {
		String sql = "insert into clientes(nome,email,endereco) values (?,?,?);";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,cliente.getNome());
			stmt.setString(2,cliente.getEmail());
			stmt.setString(3,cliente.getEndereco());
			stmt.execute();
			stmt.close();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
			
			
		}
				
	}
	
	public List<Cliente> getClientes(){
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.con.prepareStatement("select * from clientes;");
			ResultSet  rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				
				clientes.add(cliente);
			}
			rs.close(); // fecha o result set
			stmt.close(); // fecha states
			return clientes;
			
			
		} catch (Exception e) {
			// Todos : handle exception
			throw new RuntimeException(e);
		}
	}
	
	
	
	public void status() {
		try {
			System.out.println(con.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void fechar() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(Cliente cliente) {
		String sql = "update clientes set nome=?, endereco=?,email=? where id=?";
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setLong(4, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void excluir(Cliente cliente) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete from cliente where id=?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		}catch (Exception e){
			throw new RuntimeException(e);
			
		}
	}

}

	
	