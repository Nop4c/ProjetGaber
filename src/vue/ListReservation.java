package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ModelReq;
import refClass.Circuit;
import refClass.Client;
import refClass.Reservation;

public class ListReservation {
	private JLabel l1;
	private JTable tableau;
	private JScrollPane scrollPane;

	public  ListReservation(Client client) throws SQLException {

		JFrame frame = new JFrame("Mes réservations");
		l1 = new JLabel("Mes réservations");
		l1.setFont(new Font("Arial", Font.BOLD, 20));

		ModelReq req =new ModelReq();
		List<Reservation> listReservation = req.getReservation(client.getId());
		String [] title = {"Nom", "Nombre de place", "Date"};

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Object[][] data = new Object[listReservation.size()][4];
		for(int i = 0; i < listReservation.size(); i++) {
			data[i][0]= req.getCircuitById(listReservation.get(i).getNom()).getDescriptif();
			data[i][1]= listReservation.get(i).getNbPlace();
			data[i][2]= sdf.format(listReservation.get(i).getDate().getTime());
		}

		tableau = new JTable(data, title);
		tableau.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
		l1.setBounds(80, 30, 400, 30);

		scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(100,130,500,200);

		frame.add(l1);
		frame.add(scrollPane);

		frame.setSize(700,400); 
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 



	}
}
