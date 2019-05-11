package testes;

import java.util.List;

import dao.ClienteDao;
import modelo.Cliente;

public class TesteGetClientes {
public static void main(String[] args) {
	ClienteDao dao = new ClienteDao();
	List<Cliente> clientes = dao.getClientes();
	for (Cliente cliente : clientes) {
		System.out.println("Nome.. :"+cliente.getNome());
		System.out.println("E-mail.. :"+cliente.getEmail());
		System.out.println("Endereço.. :"+cliente.getEndereco());
		System.out.println("---------------------------------------");
		
	}
	
	dao.status();
	dao.fechar();
	dao.status();
	
}
}
