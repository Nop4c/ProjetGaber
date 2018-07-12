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
import refClass.Client;
import refClass.Etape;

public class CreateEtape {
	 private JLabel l1;
	 private JLabel l2;
	 private JLabel l3;
	 private JLabel l4;
	 private JLabel l5;
	 private JLabel l6;
	 private JLabel l7;
	 private JLabel l8;
	 private JTextField tf1;
	 private JTextField tf2;
	 private JTextField tf3;
	 private JTextField tf4;
	 private JTextField tf5;
	 private JTextField tf6;
	 private JButton btn1;
	 private JOptionPane jop1;
	 private JOptionPane jop2;
	 
	public  CreateEtape(Circuit circuit) {
	  JFrame frame = new JFrame("Création d'un compte");
	  l1 = new JLabel("Création d'un compte");
	  l1.setFont(new Font("Arial", Font.BOLD, 20));
	 
	  l2 = new JLabel("Ordre");
	  l3 = new JLabel("Nom du lieu");
	  l5 = new JLabel("Ville");
	  l6 = new JLabel("Pays");
	  l7 = new JLabel("Date étape");
	  l8 = new JLabel("Duree");
	  tf1 = new JTextField();
	  tf2 = new JTextField();
	  tf3 = new JTextField();
	  tf4 = new JTextField();
	  tf5 = new JTextField();
	  tf6 = new JTextField();
	  btn1 = new JButton("Valider");
	   
	  l1.setBounds(80, 30, 400, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  l5.setBounds(80, 150, 200, 30);
	  l6.setBounds(80, 190, 200, 30);
	  l7.setBounds(80, 230, 200, 30);
	  l8.setBounds(80, 270, 200, 30);
	  tf1.setBounds(300, 70, 200, 30);
	  tf2.setBounds(300, 110, 200, 30);
	  tf3.setBounds(300, 150, 200, 30);
	  tf4.setBounds(300, 190, 200, 30);
	  tf5.setBounds(300, 230, 200, 30);
	  tf6.setBounds(300, 270, 200, 30);
	  btn1.setBounds(150, 260, 100, 30);
	 
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(l3);
	  frame.add(l5);
	  frame.add(l6);
	  frame.add(l7);
	  frame.add(l8);
	  frame.add(tf1);
	  frame.add(tf2);
	  frame.add(tf3);
	  frame.add(tf4);
	  frame.add(tf5);
	  frame.add(tf6);
	  frame.add(btn1);
	 
	  frame.setSize(600,400);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  frame.setResizable(false);
	  frame.setLocationRelativeTo(null); 
	  
	  btn1.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(tf1.getText().trim().isEmpty() || tf2.getText().trim().isEmpty() || tf3.getText().trim().isEmpty()) {
		    		jop2 = new JOptionPane();
		    		jop2.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
		    	
		    	}else {
		    	ModelReq log = new ModelReq();
		    	try {
		    		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    		Date date = sdf.parse(tf5.getText());
		    		Calendar cal = Calendar.getInstance();
		    		cal.setTime(date);
		    		
		    		Etape etape = new Etape(circuit.getId(), Integer.valueOf(tf1.getText()), tf2.getText(), tf3.getText(),tf4.getText(),cal, Integer.valueOf(tf6.getText()));
					log.createEtape(etape);
					jop1 = new JOptionPane();
			    	jop1.showMessageDialog(null, "Votre étape a bien été créé", "Information", JOptionPane.INFORMATION_MESSAGE);
			    	frame.dispose();
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    	}
		    }
	 });
	}
}
