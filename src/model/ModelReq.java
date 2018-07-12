package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import refClass.Circuit;
import refClass.Client;

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
		 Calendar calendar = client.getDate();
	     long date =  calendar.LONG;
	     java.sql.Date date_sql = new java.sql.Date(date);
		 pstmt.setDate(4, date_sql);
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
			 Circuit circuit = new Circuit(rs.getString(2), rs.getString(3), rs.getString(4) ,  rs.getString(5), rs.getString(6), calendar,  rs.getInt(8), rs.getInt(9), rs.getInt(10));
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
		 Calendar calendar = circuit.getDateDepart();
	     long date =  calendar.LONG;
	     java.sql.Date date_sql = new java.sql.Date(date);
		 pstmt.setDate(7, date_sql);
		 pstmt.setInt(8, circuit.getNbrPlaceDisponible());
		 pstmt.setInt(9, circuit.getDuree());
		 pstmt.setInt(10, circuit.getPrixInscription());
		 
		 pstmt.executeUpdate();

		 closeBDD();
		
	}

	public void updateCircuit(Circuit circuit) throws SQLException {
		 openBDD();
		
		 
		 pstmt = con.prepareStatement("UPDATE Circuit set descriptif = ?, villedepart = ?, paysdepart = ?, villeArrivee = ?, paysArrivee = ?, dateDepart = ?, "
		 		+ "nbrPlaceDisponible = ?, duree = ?, prixInscription = ?)"
		 		+ " Where Id = ");
		 pstmt.setInt(1, circuit.getId());
		 pstmt.setString(2, circuit.getDescriptif());
		 pstmt.setString(3, circuit.getVilleDepart());
		 pstmt.setString(4, circuit.getPaysDepart());
		 pstmt.setString(5, circuit.getVilleArrivee());
		 pstmt.setString(6, circuit.getPaysArrivee());
		 Calendar calendar = circuit.getDateDepart();
	     long date =  calendar.LONG;
	     java.sql.Date date_sql = new java.sql.Date(date);
		 pstmt.setDate(7, date_sql);
		 pstmt.setInt(8, circuit.getNbrPlaceDisponible());
		 pstmt.setInt(9, circuit.getDuree());
		 pstmt.setInt(10, circuit.getPrixInscription());
		 
		 pstmt.executeUpdate();

		 closeBDD();
		
	}
}
