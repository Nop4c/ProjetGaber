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
import model.Service;
import refClass.Circuit;
import refClass.Client;

public class ListCircuit {
	 private JLabel l1;
	 private JLabel l2;
	 private JButton btn1;
	 private JButton btn2;
	 private JButton btn3;
	 private JTable tableau;
	 private JScrollPane scrollPane;
	public  ListCircuit(Client client) throws SQLException {
		
	  JFrame frame = new JFrame("Liste des circuits");
	  l1 = new JLabel("Liste des circuits");
	  l1.setFont(new Font("Arial", Font.BOLD, 20));
	  l2 = new JLabel("Bienvenue "+client.getPrenom() +" "+client.getNom()+" !");
	  
	  ModelReq req =new ModelReq();
	  List<Circuit> listCircuit = req.getListCircuit();
	  String [] title = {"Référence", "Description", "Ville de départ", "Pays de départ", "Ville d'arrivée", "Pays d'arrivée", 
			  "Date de départ", "Nombre de place disponible","Durée", "Prix"};
	 
	  btn1 = new JButton("En savoir plus");
	  btn2 = new JButton("Déconnexion");
	  btn3 = new JButton("Mes réservations");
	  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	  Object[][] data = new Object[listCircuit.size()][10];
	  
	 for(int i = 0; i < listCircuit.size(); i++) {
		 data[i][0]= listCircuit.get(i).getId();
		 data[i][1]= listCircuit.get(i).getDescriptif();
		 data[i][2]= listCircuit.get(i).getVilleDepart();
		 data[i][3]= listCircuit.get(i).getPaysDepart();
		 data[i][4]= listCircuit.get(i).getVilleArrivee();
		 data[i][5]= listCircuit.get(i).getPaysArrivee();
		 data[i][6]= sdf.format(listCircuit.get(i).getDateDepart().getTime());
		 data[i][7]= listCircuit.get(i).getNbrPlaceDisponible();
		 data[i][8]= listCircuit.get(i).getDuree();
		 data[i][9]= listCircuit.get(i).getPrixInscription();
	 }
	 
	  
	  tableau = new JTable(data, title);
	  tableau.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
	  l1.setBounds(80, 30, 400, 30);
	  l2.setBounds(1700, 30, 200, 30);

	  scrollPane = new JScrollPane(tableau);
	  btn1.setBounds(600, 850, 150, 30);
	  btn2.setBounds(1700, 70, 150, 30);
	  btn3.setBounds(1000, 850, 150, 30);
	  scrollPane.setBounds(100,130,1600,700);
	  
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(btn1);
	  frame.add(btn2);
	  frame.add(btn3);
	  frame.add(scrollPane);
	 
	  frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	  frame.setLayout(null);
	  frame.setVisible(true);
	  frame.setResizable(false);
	  frame.setLocationRelativeTo(null); 
	  
	  
	  btn1.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		       
		       Service service = new Service();
				int row = tableau.getSelectedRow();
				Circuit circuit = new Circuit(Integer.valueOf(tableau.getValueAt(row, 0).toString()),tableau.getValueAt(row, 1).toString(), tableau.getValueAt(row, 2).toString(), tableau.getValueAt(row, 3).toString(), tableau.getValueAt(row, 4).toString(), 
						tableau.getValueAt(row, 5).toString(), service.stringToCalendar(tableau.getValueAt(row, 6).toString()), Integer.valueOf(tableau.getValueAt(row, 7).toString()), Integer.valueOf(tableau.getValueAt(row, 8).toString()), Integer.valueOf(tableau.getValueAt(row, 9).toString()));
				try {
					new InfoCircuit(circuit, client);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
	 });
	  
	  btn2.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		       new Login();
		       frame.dispose();
		    }
	 });
	  
	  btn3.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	try {
					new ListReservation(client);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }
	 });
	  

	  
	}
}
