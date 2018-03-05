package br.coop.cooperforte.treinamento.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

import br.coop.cooperforte.treinamento.corporativo.dao.ClienteDAO;
import br.coop.cooperforte.treinamento.service.rest.ClienteRest;
import br.coop.cooperforte.treinamento.to.ClienteTO;

@Stateless
public class Cliente extends ClienteRest {
	
	@EJB
	private ClienteDAO clienteDAO;
	
	public List<ClienteTO> clientes(HttpServletRequest req) throws ServiceException {
		return clienteDAO.findAll();
	}

	public ClienteTO insert(HttpServletRequest req, ClienteTO clienteTO) throws ServiceException {
		return clienteDAO.insert(clienteTO);		
	}

	public ClienteTO findById(HttpServletRequest req, String id) throws ServiceException {
		return clienteDAO.findById(id);
	}
	
	public void delete(HttpServletRequest req, ClienteTO clienteTO) throws ServiceException {
		clienteDAO.delete(clienteTO);
	}

	@Override
	public ClienteTO update(HttpServletRequest req, ClienteTO clienteTO) throws ServiceException {
		return clienteDAO.update(clienteTO);
	}
}
