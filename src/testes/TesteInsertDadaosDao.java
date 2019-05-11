package testes;

import dao.ClienteDao;
import modelo.Cliente;

public class TesteInsertDadaosDao {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		
		cliente.setNome("Joao");
		cliente.setEmail("joao@joao.com");
		cliente.setEndereco("Av. Sao Joao, 500");
		
		ClienteDao dao =new ClienteDao();
		dao.inserir(cliente);
		System.out.println("Cliente Gravado com Sucesso !");
		
		
		
	}

}
