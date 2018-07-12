package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import refClass.Circuit;
import refClass.Client;
import refClass.Etape;
import refClass.Reservation;

public class ModelReq {
	ConnexionBDD conn;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	

	public void openBDD(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:root","sys as sysdba","root");
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
	}
	
	public void closeBDD() {
		if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public void createUser(Client client, String mdp) throws SQLException {
		 openBDD();
		
		 
		 pstmt = con.prepareStatement("INSERT INTO Client(id, nom, prenom, date_naissance, mot_De_Passe) VALUES (?,?,?,?,?)");
		 pstmt.setInt(1, client.getId());
		 pstmt.setString(2, client.getNom());
		 pstmt.setString(3, client.getPrenom());
		 Date sqlDate = new Date(client.getDate().getTimeInMillis());
		 pstmt.setDate(4, sqlDate);
		 pstmt.setString(5, mdp);
		 
		 pstmt.executeUpdate();

		 closeBDD();
		
	}
	
	public boolean getLoginPassword(String nom, String prenom, String password) throws SQLException {
		 openBDD();
		 pstmt = con.prepareStatement("SELECT * from Client where nom = ? and  prenom = ? and Mot_De_Passe = ?");
		 pstmt.setString(1, nom);
		 pstmt.setString(2, prenom);
		 pstmt.setString(3, password);
		 rs = pstmt.executeQuery();
		 if(rs.next()) {
			 closeBDD();
			 return true;
		 }
		 closeBDD();
		 return false;
	}
	
	public List <Circuit> getListCircuit() throws SQLException {
		List <Circuit> listCircuit = new ArrayList<>();
		 openBDD();
		 pstmt = con.prepareStatement("SELECT * from Circuit");
		 rs = pstmt.executeQuery();
		 while(rs.next()) {
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(rs.getDate(7));
			 Circuit circuit = new Circuit(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4) ,  rs.getString(5), rs.getString(6), calendar,  rs.getInt(8), rs.getInt(9), rs.getInt(10));
			 listCircuit.add(circuit);
		 }
		 closeBDD();
		 return listCircuit;
		 
	}
	
	public void createCircuit(Circuit circuit) throws SQLException {
		 openBDD();
		
		 
		 pstmt = con.prepareStatement("INSERT INTO Circuit(identifiant, descriptif, villedepart, paysdepart, villeArrivee, paysArrivee, dateDepart, nbrPlaceDisponible, duree, prixInscription)"
		 		+ " VALUES (?,?,?,?,?,?,?,?,?,?)");
		 pstmt.setInt(1, circuit.getId());
		 pstmt.setString(2, circuit.getDescriptif());
		 pstmt.setString(3, circuit.getVilleDepart());
		 pstmt.setString(4, circuit.getPaysDepart());
		 pstmt.setString(5, circuit.getVilleArrivee());
		 pstmt.setString(6, circuit.getPaysArrivee());
	     Date sqlDate = new Date(circuit.getDateDepart().getTimeInMillis());
		 pstmt.setDate(7, sqlDate);
		 pstmt.setInt(8, circuit.getNbrPlaceDisponible());
		 pstmt.setInt(9, circuit.getDuree());
		 pstmt.setInt(10, circuit.getPrixInscription());
		 
		 pstmt.executeUpdate();

		 closeBDD();
		
	}

	public void updateCircuit(Circuit circuit) throws SQLException {
		 openBDD();
		
		 
		 pstmt = con.prepareStatement("UPDATE Circuit set descriptif = ?, villedepart = ?, paysdepart = ?, villeArrivee = ?, paysArrivee = ?, dateDepart = ?, "
		 		+ "nbrPlaceDisponible = ?, duree = ?, prixInscription = ?"
		 		+ " WHERE identifiant = ?");

		 pstmt.setString(1, circuit.getDescriptif());
		 pstmt.setString(2, circuit.getVilleDepart());
		 pstmt.setString(3, circuit.getPaysDepart());
		 pstmt.setString(4, circuit.getVilleArrivee());
		 pstmt.setString(5, circuit.getPaysArrivee());
	     Date sqlDate = new Date(circuit.getDateDepart().getTimeInMillis());
		 pstmt.setDate(6,  sqlDate);
		 pstmt.setInt(7, circuit.getNbrPlaceDisponible());
		 pstmt.setInt(8, circuit.getDuree());
		 pstmt.setInt(9, circuit.getPrixInscription());
		 pstmt.setInt(10, circuit.getId());
		 pstmt.executeUpdate();

		 closeBDD();
		
	}
	public List <Etape> getListEtape(Integer id) throws SQLException {
		List <Etape> listEtape = new ArrayList<>();
		 openBDD();
		 pstmt = con.prepareStatement("SELECT * from Etape WHERE identifiantcircuit = ?");
		 pstmt.setInt(1, id);
		 rs = pstmt.executeQuery();
		 while(rs.next()) {
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(rs.getDate(6));
			 Etape etape = new Etape(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),calendar,rs.getInt(7));
			 listEtape.add(etape);
		 }
		 closeBDD();
		 return listEtape;
	}
		 
	public void deleteCircuit(Integer id) throws SQLException {
		 openBDD();
		 
		 pstmt = con.prepareStatement("Delete From Circuit WHERE identifiant = ?");
		 pstmt.setInt(1, id);

		 pstmt.executeUpdate();

		 closeBDD();
		
	}
	
	public List <Client> getListClient() throws SQLException {
		List <Client> listClient = new ArrayList<>();
		 openBDD();
		 pstmt = con.prepareStatement("SELECT * from Client");
		 rs = pstmt.executeQuery();
		 while(rs.next()) {
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(rs.getDate(4));
			 Client client = new Client(rs.getInt(1),rs.getString(2), rs.getString(3), calendar);
			 listClient.add(client);
		 }
		 closeBDD();
		 return listClient;
		 
	}
	public void deleteClient(Integer id) throws SQLException {
		 openBDD();
		 
		 pstmt = con.prepareStatement("Delete From Client WHERE id = ?");
		 pstmt.setInt(1, id);

		 pstmt.executeUpdate();

		 closeBDD();	
	}
	
	public List <Reservation> getReservation(Integer id) throws SQLException {
		List <Reservation> listReservation = new ArrayList<>();
		System.out.println(id);
		 openBDD();
		 pstmt = con.prepareStatement("SELECT * from Reservation where client_id = ?");
		 pstmt.setInt(1, id);
		 rs = pstmt.executeQuery();
		 while(rs.next()) {
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(rs.getDate(3));
			 Reservation reservation = new Reservation(rs.getInt(4),rs.getInt(2), calendar);
			 listReservation.add(reservation);
		 }
		 closeBDD();
		 return listReservation;
		 
	}
	
	public Client getClientByName(String nom, String prenom) throws SQLException {
		 openBDD();
		 pstmt = con.prepareStatement("SELECT * from Client where nom = ? and prenom = ?");
		 pstmt.setString(1, nom);
		 pstmt.setString(2, prenom);
		 rs = pstmt.executeQuery();
		 if(rs.next()) {
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(rs.getDate(4));
			 Client client = new Client(rs.getInt(1),rs.getString(2), rs.getString(3), calendar);
			 closeBDD();
			 return client;
		 }
		 closeBDD();
		 return null;
		 
	}
	public Circuit getCircuitById(Integer id) throws SQLException {
		 openBDD();
		 pstmt = con.prepareStatement("SELECT * from Circuit where identifiant = ?");
		 pstmt.setInt(1, id);
		 rs = pstmt.executeQuery();
		 if(rs.next()) {
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(rs.getDate(7));
			 Circuit circuit = new Circuit(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4) ,  rs.getString(5), rs.getString(6), calendar,  rs.getInt(8), rs.getInt(9), rs.getInt(10));
			 
			 closeBDD();
			 return circuit;
		 }
		 closeBDD();
		 return null;
		 
	}
	
	public void createReservation(Reservation reservation) throws SQLException {
		 openBDD();
		
		 
		 pstmt = con.prepareStatement("INSERT INTO Reservation(id, NbPlace, Dates, Circuit_Id, Client_id)"
		 		+ " VALUES (?,?,?,?,?)");
		 pstmt.setInt(1, reservation.getId());
		 pstmt.setInt(2, reservation.getNbPlace());
	     Date sqlDate = new Date(reservation.getDate().getTimeInMillis());
		 pstmt.setDate(3, sqlDate);
		 pstmt.setInt(4, reservation.getCircuitId());
		 pstmt.setInt(5, reservation.getClientId());


		 
		 pstmt.executeUpdate();

		 closeBDD();
		
	}
	
	public void deleteEtape(Integer id) throws SQLException {
		 openBDD();
		 
		 pstmt = con.prepareStatement("Delete From Etape WHERE id = ?");
		 pstmt.setInt(1, id);
		 pstmt.executeUpdate();

		 closeBDD();	
	}
	
	public void createEtape(Etape etape) throws SQLException {
		 openBDD();
		
		 
		 pstmt = con.prepareStatement("INSERT INTO Etape(IdentifiantCircuit, Ordre, NomLieu, Ville, Pays, DateEtape, Duree)"
		 		+ " VALUES (?,?,?,?,?,?,?)");
		 pstmt.setInt(1, etape.getId());
		 pstmt.setInt(2, etape.getOrdre());
		 pstmt.setString(3, etape.getNomLieu());
		 pstmt.setString(4, etape.getVille());
		 pstmt.setString(5, etape.getPays());
	     Date sqlDate = new Date(etape.getDateEtape().getTimeInMillis());
		 pstmt.setDate(6, sqlDate);
		 pstmt.setInt(7, etape.getDuree());


		 
		 pstmt.executeUpdate();

		 closeBDD();
		
	}
	
}
