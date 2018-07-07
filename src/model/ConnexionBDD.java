package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnexionBDD {

	public static void main(String[] args) {
		 Connection con = null;
		 ResultSet rs = null;
		 PreparedStatement pstmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:root","admin","azerty");
            pstmt = con.prepareStatement("SELECT * FROM CLIENT");
            
            rs = pstmt.executeQuery();
            while(rs.next()) {
            	System.out.println(rs.getString(2));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        } finally {
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
        
    }
	
}
