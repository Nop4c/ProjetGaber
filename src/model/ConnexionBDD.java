package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnexionBDD {
	 Connection con = null;
	 ResultSet rs = null;
	 PreparedStatement pstmt = null;

	 public ConnexionBDD() {};
	 
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
	
}
