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

public class ListClient {
	private JLabel l1;
	private JLabel l2;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JTable tableau;
	private JScrollPane scrollPane;

	public  ListClient() throws SQLException {

		JFrame frame = new JFrame("Liste des clients");
		l1 = new JLabel("Liste des clients");
		l1.setFont(new Font("Arial", Font.BOLD, 20));

		btn1 = new JButton("Ajouter");
		btn2 = new JButton("Modifier");
		btn3 = new JButton("Supprimer");
		btn4 = new JButton("Refresh");
		ModelReq req =new ModelReq();
		List<Client> listClient = req.getListClient();
		String [] title = {"Identifiant", "Nom", "Prenom", "Date de naissance"};

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Object[][] data = new Object[listClient.size()][5];

		for(int i = 0; i < listClient.size(); i++) {
			data[i][0]= listClient.get(i).getId();
			data[i][1]= listClient.get(i).getNom();
			data[i][2]= listClient.get(i).getPrenom();
			data[i][3]= sdf.format(listClient.get(i).getDate().getTime());
		}


		tableau = new JTable(data, title);
		tableau.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
		l1.setBounds(80, 30, 400, 30);

		scrollPane = new JScrollPane(tableau);
		btn1.setBounds(1110, 200, 150, 30);
		btn2.setBounds(1110, 240, 150, 30);
		btn3.setBounds(1110, 280, 150, 30);
		btn4.setBounds(1110, 320, 150, 30);
		scrollPane.setBounds(100,130,1000,400);

		frame.add(l1);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(scrollPane);

		frame.setSize(1300,600); 
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 


			  btn1.addActionListener( new ActionListener()
				{
				    public void actionPerformed(ActionEvent e)
				    {
				       new CreateUser();
				    }
			 });
			  
			  btn2.addActionListener( new ActionListener()
				{
				    public void actionPerformed(ActionEvent e)
				    {
				      // new Login();
				       //frame.dispose();
				    }
			 });
			  
			  btn3.addActionListener( new ActionListener()
				{
				    public void actionPerformed(ActionEvent e)
				    {
				    	int row = tableau.getSelectedRow();
						ModelReq req= new ModelReq();
						try {
							req.deleteClient(Integer.valueOf(tableau.getValueAt(row, 0).toString()));
							frame.dispose();
							new ListClient();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    }
			 });
			  
			  btn4.addActionListener( new ActionListener()
				{
				    public void actionPerformed(ActionEvent e)
				    {
				    	frame.dispose();
						try {
							new ListClient();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    }
			 });



	}
}
