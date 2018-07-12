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
import refClass.Client;

public class CreateUser {
	 private JLabel l1;
	 private JLabel l2;
	 private JLabel l3;
	 private JLabel l4;
	 private JLabel l5;
	 private JLabel l6;
	 private JTextField tf1;
	 private JTextField tf2;
	 private JTextField tf3;
	 private JTextField tf4;
	 private JPasswordField p1;
	 private JButton btn1;
	 private JButton btn2;
	 private JOptionPane jop1;
	 private JOptionPane jop2;
	 
	public  CreateUser() {
	  JFrame frame = new JFrame("Création d'un compte");
	  l1 = new JLabel("Création d'un compte");
	  l1.setFont(new Font("Arial", Font.BOLD, 20));
	 
	  l2 = new JLabel("Nom");
	  l3 = new JLabel("Prénom");
	  l6 = new JLabel("Mot de passe");
	  l5 = new JLabel("Date de naissance");
	  tf1 = new JTextField();
	  tf2 = new JTextField();
	  tf3 = new JTextField();
	  tf4 = new JTextField();
	  p1 = new JPasswordField();
	  btn1 = new JButton("Valider");
	  btn2 = new JButton("Retour");
	   
	  l1.setBounds(80, 30, 400, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  l6.setBounds(80, 190, 200, 30);
	  l5.setBounds(80, 150, 200, 30);
	  tf1.setBounds(300, 70, 200, 30);
	  tf2.setBounds(300, 110, 200, 30);
	  tf3.setBounds(300, 150, 200, 30);
	  p1.setBounds(300, 190, 200, 30);
	  btn1.setBounds(150, 260, 100, 30);
	  btn2.setBounds(430, 290, 150, 30);
	 
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(l3);
	  frame.add(l5);
	  frame.add(l6);
	  frame.add(tf1);
	  frame.add(tf2);
	  frame.add(tf3);
	  frame.add(p1);
	  frame.add(btn1);
	  frame.add(btn2);
	 
	  frame.setSize(600,400);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  frame.setResizable(false);
	  frame.setLocationRelativeTo(null); 
	  
	  btn1.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(tf1.getText().trim().isEmpty() || tf2.getText().trim().isEmpty() || tf3.getText().trim().isEmpty() || String.valueOf(p1.getPassword()).trim().isEmpty()) {
		    		jop2 = new JOptionPane();
		    		jop2.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
		    	
		    	}else {
		    	ModelReq log = new ModelReq();
		    	try {
		    		Random rand = new Random(); 
		    		Integer nombreAleatoire = rand.nextInt(10000 - 0 + 1) ;
		    		 
		    		
		    		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    		Date date = sdf.parse(tf3.getText());
		    		Calendar cal = Calendar.getInstance();
		    		cal.setTime(date);
		    		
		    		Client client = new Client(nombreAleatoire, tf1.getText(), tf2.getText(), cal);
					log.createUser(client, String.valueOf(p1.getPassword()));
					jop1 = new JOptionPane();
			    	jop1.showMessageDialog(null, "Votre compte a bien été créé", "Information", JOptionPane.INFORMATION_MESSAGE);
			    	new Login();
			    	frame.dispose();
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
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
	  
	}
}
