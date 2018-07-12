package vue;

import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ModelReq;
import refClass.Etape;

public class ListEtape {
	 private JLabel l1;
	 private JTable tableau;
	 private JScrollPane scrollPane;
	 
	 public ListEtape(Integer id) throws SQLException{
		 JFrame frame = new JFrame("Liste des étapes");
		  l1 = new JLabel("Liste des étapes");
		  l1.setFont(new Font("Arial", Font.BOLD, 20));
		  
		  ModelReq req = new ModelReq();
		  List<Etape> listEtape = req.getListEtape(id);
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

		  scrollPane = new JScrollPane(tableau);
		  scrollPane.setBounds(100,130,1600,700);
		  
		  frame.add(l1);
		  frame.add(scrollPane);
		  frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		  frame.setLayout(null);
		  frame.setVisible(true);
		  frame.setResizable(false);
		  frame.setLocationRelativeTo(null); 
	 }
}
