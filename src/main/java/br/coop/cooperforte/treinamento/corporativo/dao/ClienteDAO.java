package br.coop.cooperforte.treinamento.corporativo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateful;

import br.coop.cooperforte.treinamento.to.ClienteTO;

@Stateful
public class ClienteDAO {
	
	private List<ClienteTO> clientes = new ArrayList<ClienteTO>();
	
	public List<ClienteTO> findAll() {
		return clientes;
	}
	
	public ClienteTO insert(ClienteTO clienteTO) {
		clienteTO.setId(UUID.randomUUID().toString());
		clientes.add(clienteTO);
		
		return clienteTO;
	}

	public ClienteTO update(ClienteTO clienteTO) {
		
		if(clienteTO != null && clientes.isEmpty() == false){	
			for(ClienteTO cli: clientes){
				if(cli.getId().equals(clienteTO.getId())){
					cli.setNome(clienteTO.getNome());
					cli.setEmail(clienteTO.getEmail());
					cli.setTelefone(clienteTO.getTelefone());
				}
			}
		}
		
		
		return clienteTO;
	}
	
	public void delete(ClienteTO clienteTO) {
		clientes.remove(clienteTO);
	}
	
	public ClienteTO findById(String id) {
		
		for (ClienteTO cli:clientes) {
			if (cli.getId().equalsIgnoreCase(id)) {
				return cli;
			}
		}
		
		return null;		
	}
	
}
