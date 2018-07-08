package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	
	 private JLabel l1;
	 private JLabel l2;
	 private JLabel l3;
	 private JTextField tf1;
	 private JButton btn1;
	 private JButton btn2;
	 private JPasswordField p1;
	 
	public  Login() {
	  JFrame frame = new JFrame("Login Form");
	  l1 = new JLabel("Authentification");
	  l1.setFont(new Font("Arial", Font.BOLD, 20));
	 
	  l2 = new JLabel("Identifiant");
	  l3 = new JLabel("Mot de passe");
	  tf1 = new JTextField();
	  p1 = new JPasswordField();
	  btn1 = new JButton("Valider");
	  btn2 = new JButton("Créer un compte");
	   
	  l1.setBounds(80, 30, 400, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  tf1.setBounds(300, 70, 200, 30);
	  p1.setBounds(300, 110, 200, 30);
	  btn1.setBounds(150, 160, 100, 30);
	  btn2.setBounds(430, 230, 150, 30);
	 
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(tf1);
	  frame.add(l3);
	  frame.add(p1);
	  frame.add(btn1);
	  frame.add(btn2);
	 
	  frame.setSize(600,300);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  frame.setResizable(false);
	  frame.setLocationRelativeTo(null); 
	  
	  btn1.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	if("admin".equals(tf1.getText()) && ("admin".equals(String.valueOf(p1.getPassword())))){
		    		new AdminPage();
		    		frame.dispose();
		    	}else {
		    	new ListCircuit();
		     	frame.dispose();
		    	}
		    }
	 });
	  
	  btn2.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		       new CreateUser();
		       frame.dispose();
		    }
	 });
	}
	
}

	

