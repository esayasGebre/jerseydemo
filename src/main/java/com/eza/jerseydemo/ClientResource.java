package com.eza.jerseydemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("c")
public class ClientResource {

	ClientRepository clientRepository = new ClientRepository();
	
	@GET 
    @Produces({/*MediaType.APPLICATION_XML, */MediaType.APPLICATION_JSON})
	public List<Client> getClients(){
		System.out.println("get clients...");
		return clientRepository.getClients();

	}
	
	@POST
	@Path("client")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Client createClient(Client  c){
		
		System.out.println("first---"+c);
		clientRepository.createClient(c);
		System.out.println(c);
		return c;
	}
	
	
	@GET
	@Path("client/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client getClient(@PathParam("id") int id){
		System.out.println("get a client...id:" + id);
		return clientRepository.getClient(id);
	}
	
	
	

}
