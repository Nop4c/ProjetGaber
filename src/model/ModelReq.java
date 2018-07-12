package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

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
	     System.out.println(client.getDate());
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


}
