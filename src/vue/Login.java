package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.ModelReq;
import refClass.Client;

public class Login {

	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JTextField tf1;
	private JButton btn1;
	private JButton btn2;
	private JPasswordField p1;
	private JOptionPane jop1;

	public  Login() {
		JFrame frame = new JFrame("Login Form");
		l1 = new JLabel("Authentification");
		l1.setFont(new Font("Arial", Font.BOLD, 20));

		l2 = new JLabel("Identifiant");
		l3 = new JLabel("Mot de passe");
		tf1 = new JTextField();
		p1 = new JPasswordField();
		btn1 = new JButton("Valider");
		btn2 = new JButton("Cr�er un compte");

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
				ModelReq log = new ModelReq();
				if("admin".equals(tf1.getText()) && ("admin".equals(String.valueOf(p1.getPassword())))){
					try {
						new AdminPage();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();
				}else {
					try {
						if(!tf1.getText().contains("-")) {
							jop1 = new JOptionPane();
							jop1.showMessageDialog(null, "Identifiant ou mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
						}else {
							String [] tabLogin = tf1.getText().split("-");
							String nom = tabLogin[0];
							String prenom = tabLogin[1];
							if(log.getLoginPassword(nom, prenom, String.valueOf(p1.getPassword()))) {
								Client client = new Client(nom, prenom);
								new ListCircuit(client);
								frame.dispose();
							}else {
								jop1 = new JOptionPane();
								jop1.showMessageDialog(null, "Identifiant ou mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
						}
					} catch (SQLException e1) {
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
				new CreateUser();
			}
		});
	}

}



