package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ModelReq;
import refClass.Circuit;
import refClass.Client;

public class ListCircuit {
	 private JLabel l1;
	 private JLabel l2;
	 private JButton btn1;
	 private JButton btn2;
	 private JTable tableau;
	 private JScrollPane scrollPane;
	public  ListCircuit(Client client) throws SQLException {
		
	  JFrame frame = new JFrame("Liste des circuits");
	  l1 = new JLabel("Liste des circuits");
	  l1.setFont(new Font("Arial", Font.BOLD, 20));
	  l2 = new JLabel("Bienvenue "+client.getPrenom() +" "+client.getNom()+" !");
	  
	  ModelReq req =new ModelReq();
	  List<Circuit> listCircuit = req.getListCircuit();
	  String [] title = {"Description", "Ville de départ", "Pays de départ", "Ville d'arrivée", "Pays d'arrivée", 
			  "Date de départ", "Nombre de place disponible","Durée", "Prix"};
	 
	  btn1 = new JButton("En savoir plus");
	  btn2 = new JButton("Déconnexion");
	  Object[][] data = new Object[listCircuit.size()][9];
	  
	 for(int i = 0; i < listCircuit.size(); i++) {
		 data[i][0]= listCircuit.get(i).getDescriptif();
		 data[i][1]= listCircuit.get(i).getVilleDepart();
		 data[i][2]= listCircuit.get(i).getPaysDepart();
		 data[i][3]= listCircuit.get(i).getVilleArrivee();
		 data[i][4]= listCircuit.get(i).getVilleDepart();
		 data[i][5]= listCircuit.get(i).getDateDepart().getTime();
		 data[i][6]= listCircuit.get(i).getNbrPlaceDisponible();
		 data[i][7]= listCircuit.get(i).getDuree();
		 data[i][8]= listCircuit.get(i).getPrixInscription();
	 }
	 
	  
	  tableau = new JTable(data, title);
	  tableau.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
	  l1.setBounds(80, 30, 400, 30);
	  l2.setBounds(1700, 30, 200, 30);

	  scrollPane = new JScrollPane(tableau);
	  btn1.setBounds(600, 850, 150, 30);
	  btn2.setBounds(1700, 70, 150, 30);
	  scrollPane.setBounds(100,130,1600,700);
	  
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(btn1);
	  frame.add(btn2);
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
		       new InfoCircuit();
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
	  

	  
	}
}
