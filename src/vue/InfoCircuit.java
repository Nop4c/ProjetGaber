package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.ModelReq;
import model.Service;
import refClass.Circuit;
import refClass.Client;
import refClass.Etape;
import refClass.Reservation;

public class InfoCircuit {
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JTextField tf1;
	private JTextField tf2;
	private JButton btn1;
	private JButton btn2;
	private JOptionPane jop1;
	private JOptionPane jop2;
	 private JTable tableau;
	 private JScrollPane scrollPane;

	public  InfoCircuit(Circuit circuit, Client client) throws SQLException {
		JFrame frame = new JFrame("Information circuit");
		l1 = new JLabel("Information circuit : "+circuit.getDescriptif());
		l1.setFont(new Font("Arial", Font.BOLD, 20));
		
		l3 = new JLabel("Etapes ");	
		l3.setFont(new Font("Arial", Font.BOLD, 20));
		ModelReq req = new ModelReq();
		List<Etape> listEtape = req.getListEtape(circuit.getId());
		String [] title = {"Ordre", "Nom du lieu", "Ville", "Pays", "Date", "Durée"};

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Object[][] data = new Object[listEtape.size()][10];

		for(int i = 0; i < listEtape.size(); i++) {
			data[i][0]= listEtape.get(i).getOrdre();
			data[i][1]= listEtape.get(i).getNomLieu();
			data[i][2]= listEtape.get(i).getVille();
			data[i][3]= listEtape.get(i).getPays();
			data[i][4]= sdf.format(listEtape.get(i).getDateEtape().getTime());
			data[i][5]= listEtape.get(i).getDuree();
		}


		tableau = new JTable(data, title);
		tableau.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

		scrollPane = new JScrollPane(tableau);
		
		l5 = new JLabel("Réservation");
		l6 = new JLabel("Nombre de place : ");
		l5.setFont(new Font("Arial", Font.BOLD, 16));
		l6.setFont(new Font("Arial", Font.BOLD, 16));
		tf1 = new JTextField();
		tf2 = new JTextField();

		btn1 = new JButton("Réservation");

		scrollPane.setBounds(100,130,700,400);
		l1.setBounds(80, 30, 400, 30);
		l3.setBounds(80, 70, 400, 30);
		l5.setBounds(900, 200, 200, 30);
		l6.setBounds(900, 240, 200, 30);
		tf1.setBounds(900, 280, 50, 30);
		btn1.setBounds(900, 320, 150, 30);

		frame.add(l1);
		frame.add(l3);
		frame.add(l5);
		frame.add(l6);
		frame.add(tf1);
		frame.add(scrollPane);
		frame.add(btn1);

		frame.setSize(1200,700);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 

		btn1.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Service service = new Service();
				jop1 = new JOptionPane();			
				int option = jop1.showConfirmDialog(null, "Etes-vous sur de vouloir réserver "+ tf1.getText() +" place(s) pour le circuit " + circuit.getDescriptif()+" pour un total de "+ service.calculPrix(Integer.valueOf(tf1.getText()),circuit.getPrixInscription())+"€ ?", "Réservation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (option == 0) {
					jop2 = new JOptionPane();
		    		Random rand = new Random(); 
		    		Integer nombreAleatoire = rand.nextInt(10000 - 0 + 1) ;
					ModelReq req = new ModelReq();
					Reservation res = new Reservation(nombreAleatoire, Integer.valueOf(tf1.getText()), circuit.getDateDepart(), circuit.getId(), client.getId());
					try {
						req.createReservation(res);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					jop2.showMessageDialog(null, "Payement Accepté  , Réservation validée", "Information", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
			}
		});

	}
}
