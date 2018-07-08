package vue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InfoCircuit {
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JTextField tf1;
	private JTextField tf2;
	private JButton btn1;
	private JButton btn2;
	private JOptionPane jop1;
	private JOptionPane jop2;

	public  InfoCircuit() {
		JFrame frame = new JFrame("Information circuit");
		l1 = new JLabel("Information circuit : Despcriptif");
		l1.setFont(new Font("Arial", Font.BOLD, 20));

		l3 = new JLabel("Ville départ, PaysDépart 	------>  	VilleArrivé, PaysArrivée");
		l4 = new JLabel("Etapes ");
		l5 = new JLabel("Réservation");
		l6 = new JLabel("Nombre de place : ");
		tf1 = new JTextField();
		tf2 = new JTextField();

		btn1 = new JButton("Réservation");

		l1.setBounds(80, 30, 400, 30);
		l3.setBounds(80, 110, 1000, 30);
		l4.setBounds(80, 150, 400, 30);
		l5.setBounds(1300, 200, 200, 30);
		l6.setBounds(1300, 230, 200, 30);
		tf1.setBounds(1300, 260, 50, 30);
		btn1.setBounds(1300, 300, 150, 30);

		frame.add(l1);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(l6);
		frame.add(tf1);

		frame.add(btn1);

		frame.setSize(1500,700);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 

		btn1.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jop1 = new JOptionPane();			
				int option = jop1.showConfirmDialog(null, "Etes-vous sur de vouloir réservé "+ tf1.getText() +" place pour le circuit  ?", "Réservation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == 0) {
					jop2 = new JOptionPane();
					jop2.showMessageDialog(null, "Payement Accepté  , Résservation validée", "Information", JOptionPane.INFORMATION_MESSAGE);
					//requete
					frame.dispose();
				}
			}
		});

	}
}
