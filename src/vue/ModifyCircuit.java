package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.ModelReq;
import refClass.Circuit;

public class ModifyCircuit {


	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JLabel l8;
	private JLabel l9;
	private JLabel l10;
	private JLabel l11;
	private JLabel l12;
	private JLabel l13;
	private JLabel l14;

	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf8;
	private JTextField tf9;
	
	private JButton btn1;
	private JButton btn2;

	private JOptionPane jop1;

	public  ModifyCircuit(Circuit circuit) {
		JFrame frame = new JFrame("Ajouter/Modifier");
		l1 = new JLabel("Ajouter/Modifier");
		l1.setFont(new Font("Arial", Font.BOLD, 20));

		l2 = new JLabel("Descrtiptif");
		l3 = new JLabel("Ville de départ");
		l4 = new JLabel("Pays de départ");
		l5 = new JLabel("Ville d'arrivée");
		l6 = new JLabel("Pays d'arrivée");
		l7 = new JLabel("Date de départ");
		l8 = new JLabel("Nombre de place disponible");
		l9 = new JLabel("Duree");
		l10 = new JLabel("Prix");

		btn1 = new JButton("Valider");
		btn2 = new JButton("Retour");

		if(circuit == null) {
			tf1 = new JTextField();
			tf2 = new JTextField();
			tf3 = new JTextField();
			tf4 = new JTextField();
			tf5 = new JTextField();
			tf6 = new JTextField();
			tf7 = new JTextField();
			tf8 = new JTextField();
			tf9 = new JTextField();
		} else {
			tf1 = new JTextField(circuit.getDescriptif());
			tf2 = new JTextField(circuit.getVilleDepart());
			tf3 = new JTextField(circuit.getPaysDepart());
			tf4 = new JTextField(circuit.getVilleArrivee());
			tf5 = new JTextField(circuit.getPaysArrivee());
			System.out.println(circuit.getDescriptif());
			System.out.println(circuit.getDateDepart());
			System.out.println(circuit.getDateDepart().toString());
			tf6 = new JTextField(circuit.getDateDepart().toString());
			tf7 = new JTextField(String.valueOf(circuit.getNbrPlaceDisponible()));
			tf8 = new JTextField(String.valueOf(circuit.getDuree()));
			tf9 = new JTextField(String.valueOf(circuit.getPrixInscription()));
		}

		l1.setBounds(80, 30, 400, 30);
		l2.setBounds(80, 70, 200, 30);
		l3.setBounds(80, 110, 200, 30);
		l4.setBounds(80, 150, 200, 30);
		l5.setBounds(80, 190, 200, 30);
		l6.setBounds(80, 230, 200, 30);
		l7.setBounds(80, 270, 200, 30);
		l8.setBounds(80, 310, 200, 30);
		l9.setBounds(80, 350, 200, 30);
		l10.setBounds(80, 390, 200, 30);

		tf1.setBounds(300, 70, 200, 30);
		tf2.setBounds(300, 110, 200, 30);
		tf3.setBounds(300, 150, 200, 30);
		tf4.setBounds(300, 190, 200, 30);
		tf5.setBounds(300, 230, 200, 30);
		tf6.setBounds(300, 270, 200, 30);
		tf7.setBounds(300, 310, 200, 30);
		tf8.setBounds(300, 350, 200, 30);
		tf9.setBounds(300, 390, 200, 30);

		btn1.setBounds(300, 430, 100, 30);
		btn2.setBounds(420, 430, 150, 30);

		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(l6);
		frame.add(l7);
		frame.add(l8);
		frame.add(l9);
		frame.add(l10);

		frame.add(tf1);
		frame.add(tf2);
		frame.add(tf3);
		frame.add(tf4);
		frame.add(tf5);
		frame.add(tf6);
		frame.add(tf7);
		frame.add(tf8);
		frame.add(tf9);
		frame.add(btn1);
		frame.add(btn2);

		frame.setSize(600,800);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 

		btn1.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jop1 = new JOptionPane();
				if(tf1.getText().trim().isEmpty() || tf2.getText().trim().isEmpty() || tf3.getText().trim().isEmpty() || tf4.getText().trim().isEmpty()
						|| tf5.getText().trim().isEmpty() || tf6.getText().trim().isEmpty() || tf7.getText().trim().isEmpty()
						|| tf8.getText().trim().isEmpty() || tf9.getText().trim().isEmpty()) {
					jop1.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);

				}else if(circuit == null){
					Random rand = new Random(); 
		    		int nombreAleatoire = rand.nextInt(10000 - 0 + 1) ;
		    		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    		Date date = null;
					try {
						date = sdf.parse(tf6.getText());
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
		    		Calendar cal = Calendar.getInstance();
		    		cal.setTime(date);
					Circuit add = new Circuit(nombreAleatoire, tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText(),
							tf5.getText(), cal , Integer.valueOf(tf7.getText()), Integer.valueOf(tf8.getText()), Integer.valueOf(tf9.getText()));
					ModelReq req= new ModelReq();
					try {
						req.createCircuit(add);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					jop1.showMessageDialog(null, "Le circuit a bien été ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				} else {
					jop1.showMessageDialog(null, "Le circuit a bien été modifié", "Information", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					try {
						new AdminPage();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btn2.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
	}

}
