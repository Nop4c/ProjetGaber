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
import refClass.Etape;

public class ListEtape {
	private JLabel l1;
	private JTable tableau;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JScrollPane scrollPane;

	public ListEtape(Circuit circuit) throws SQLException{
		JFrame frame = new JFrame("Liste des étapes");
		l1 = new JLabel("Liste des étapes du circuit :"+circuit.getDescriptif());
		l1.setFont(new Font("Arial", Font.BOLD, 20));
		btn1 = new JButton("Ajouter");
		btn2 = new JButton("Modifier");
		btn3 = new JButton("Supprimer");
		ModelReq req = new ModelReq();
		List<Etape> listEtape = req.getListEtape(circuit.getId());
		String [] title = {"Ordre", "Date", "Durée"};

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Object[][] data = new Object[listEtape.size()][10];

		for(int i = 0; i < listEtape.size(); i++) {
			data[i][0]= listEtape.get(i).getOrdre();
			data[i][1]= sdf.format(listEtape.get(i).getDateEtape().getTime());
			data[i][2]= listEtape.get(i).getDuree();
		}


		tableau = new JTable(data, title);
		tableau.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
		l1.setBounds(80, 30, 400, 30);
		btn1.setBounds(825, 200, 150, 30);
		btn2.setBounds(825, 240, 150, 30);
		btn3.setBounds(825, 280, 150, 30);
		scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(100,130,700,400);

		frame.add(l1);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(scrollPane);
		frame.setSize(1000,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 
		
		
		 btn1.addActionListener( new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			       new CreateEtape(circuit);
			    }
		 });
		  
		  btn2.addActionListener( new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
//			       new Login();
//			       frame.dispose();
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
	}
}
