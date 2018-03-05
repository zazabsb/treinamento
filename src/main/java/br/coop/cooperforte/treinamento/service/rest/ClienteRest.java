package br.coop.cooperforte.treinamento.service.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.rpc.ServiceException;

import br.coop.cooperforte.treinamento.to.ClienteTO;

@Path("/cliente")
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces(value = { MediaType.APPLICATION_JSON })
public abstract class ClienteRest {
	
	@GET
	@Path("/lista")
	public abstract List<ClienteTO> clientes(@Context HttpServletRequest req) throws ServiceException;
	
	@POST
	@Path("/insert")
	public abstract ClienteTO insert(@Context HttpServletRequest req, ClienteTO clienteTO) throws ServiceException;

	@POST
	@Path("/update")
	public abstract ClienteTO update(@Context HttpServletRequest req, ClienteTO clienteTO) throws ServiceException;

	@GET
	@Path("/{id}")
	public abstract ClienteTO findById(@Context HttpServletRequest req, @PathParam("id") String id) throws ServiceException;
	
	@DELETE
	@Path("/delete")
	public abstract void delete(@Context HttpServletRequest req, ClienteTO clienteTO) throws ServiceException;
}
