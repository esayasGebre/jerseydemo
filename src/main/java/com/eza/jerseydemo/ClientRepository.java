package com.eza.jerseydemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
	Connection con;
	public ClientRepository (){
		DbCon dbm = new DbCon();
		con = dbm.getConnection();
	}

	public List<Client> getClients(){
		List<Client> clients = new ArrayList<Client>();
		try {

			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("SELECT id,name FROM client");
			
			while (rs.next()) {
				Client client = new Client();
				client.setId(rs.getInt(1));
				client.setName(rs.getString(2));
				clients.add(client);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error on get clientsss ::" + e.getMessage());
		}
		return clients;

	}
	
	public Client getClient(int id){

		Client client=null;
		try {
			PreparedStatement preparedStmt = con
					.prepareStatement("SELECT id,name FROM client WHERE id = ?");
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				client = new Client();
				client.setId(rs.getInt(1));
				client.setName(rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error on get client ::" + e.getMessage());
		}
		return client;

	}
	
	public void createClient(Client c){
		try {
			PreparedStatement preparedStmt = con
					.prepareStatement("INSERT INTO client (id,name) VALUES(?,?)");
			preparedStmt.setInt(1, c.getId());
			preparedStmt.setString(2, c.getName());
			// execute the preparedstatement
			preparedStmt.execute();
			//con.close();
			
			System.out.println("client '"+ getClient(c.getId()).getName() +"' successfully created:");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("error on create client ::" + ex.getMessage());
		}

	}
	
	
}





/*	List<Client> clients;
{
	clients = Arrays.asList(new Client(1, "esa"), new Client(2, "Henu"),new Client(3, "abiii"));
}*/


/*public List<Client> getClients(){
	List<Client> clients = new ArrayList<Client>();
	try {
		ResultSet rs;
		//Statement st;
		//st = con.createStatement();
		PreparedStatement preparedStmt = con
				.prepareStatement("SELECT id,name FROM client");
		rs = preparedStmt.executeQuery();

		while (rs.next()) {
			Client client = new Client();
			client.setId(rs.getInt(1));
			client.setName(rs.getString(2));
			clients.add(client);
		}
		//con.close();
		return clients;

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("error on get clientsss ::" + e.getMessage());
		return null;
	}

}*/
