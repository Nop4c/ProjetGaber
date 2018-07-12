package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ModelReq;
import refClass.Circuit;

public class AdminPage {

	private JLabel l1;
	private JLabel l2;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JTable tableau;
	private JScrollPane scrollPane;

	public  AdminPage() throws SQLException {
		JFrame frame = new JFrame("Liste des circuits");
		l1 = new JLabel("Liste des circuits");
		l1.setFont(new Font("Arial", Font.BOLD, 20));
		l2 = new JLabel("Bienvenue Admin !");
		String [] title = {"Description", "Ville de départ", "Pays de départ", "Ville d'arrivée", "Pays d'arrivée", 
				"Date de départ", "Nombre de place disponible","Durée", "Prix"};

		btn1 = new JButton("Ajouter");
		btn2 = new JButton("Déconnexion");
		btn3 = new JButton("Modifier");
		btn4 = new JButton("Supprimer");
		btn5 = new JButton("Refresh");
		  ModelReq req =new ModelReq();
		  List<Circuit> listCircuit = req.getListCircuit();
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
		btn3.setBounds(800, 850, 150, 30);
		btn4.setBounds(1000, 850, 150, 30);
		btn5.setBounds(1700, 850, 150, 30);
		scrollPane.setBounds(100,130,1600,700);

		frame.add(l1);
		frame.add(l2);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(btn5);
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
				new ModifyCircuit(null);
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
				int row = tableau.getSelectedRow();
				System.out.println(tableau.getValueAt(row, 0).toString());
				System.out.println(tableau.getValueAt(row, 5).toString());
				Circuit circuit = new Circuit(tableau.getValueAt(row, 0).toString(), tableau.getValueAt(row, 1).toString(), tableau.getValueAt(row, 2).toString(), tableau.getValueAt(row, 3).toString(), 
						tableau.getValueAt(row, 4).toString(), stringToCalendar(tableau.getValueAt(row, 5).toString()), Integer.valueOf(tableau.getValueAt(row, 6).toString()), Integer.valueOf(tableau.getValueAt(row, 7).toString()), Integer.valueOf(tableau.getValueAt(row, 8).toString()));
				new ModifyCircuit(circuit);
			}
		});

		btn4.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		  btn5.addActionListener( new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			       frame.dispose();
			       try {
					new AdminPage();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			       
			    }
		 });

	}
	  public static Calendar stringToCalendar(String stringDate) {
		    if (stringDate == null) {
		      return null;
		    }
		    Calendar calendar = new GregorianCalendar();
		    try {
		      Timestamp newDate = Timestamp.valueOf(stringDate);
		      calendar.setTime(newDate);
		    }
		    catch (Exception e) {
		      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		      try {
		        calendar.setTime(simpleDateFormat.parse(stringDate));
		      }
		      catch (ParseException pe) {
		        calendar = null;
		      }
		    }
		    return calendar;
		  }
}
