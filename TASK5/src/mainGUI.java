import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class mainGUI implements ActionListener {
	
	

 JFrame frame;
 JTextField textField;
 JButton btnNewButton; //search
 JLabel lblNewLabel_1;
 JButton btnNewButton_2;
 JButton btnNewButton_3;
  contact  i ;
  JButton btnNewButton_4;
  JButton btnNewButton_1;
  addressbook sys ;
  
  
  
 mainGUI() throws SQLException{
	 frame = new JFrame();
	 addressbook sys = new addressbook();
	this.sys=sys;
	 
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 103, 89, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		 btnNewButton = new JButton("search");
		 btnNewButton.addActionListener(this);
		btnNewButton.setBounds(109, 102, 75, 23);
		frame.getContentPane().add(btnNewButton);
		
		 btnNewButton_1 = new JButton("update");
		btnNewButton_1.setBounds(10, 160, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		 btnNewButton_2 = new JButton("delete");
		btnNewButton_2.setBounds(109, 160, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		
		 btnNewButton_3 = new JButton("ADD contact");
		btnNewButton_3.setBounds(280, 102, 110, 23);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);
		
		 btnNewButton_4 = new JButton("show all ");
		
		btnNewButton_4.setBounds(300, 160, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(this);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 60, 414, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("contacts mangment system");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(67, 11, 323, 26);
		frame.getContentPane().add(lblNewLabel);
		
		
		 lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 213, 486, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		frame.setVisible(true);
 }

@Override
public void actionPerformed(ActionEvent e) {
	
	
	
if(e.getSource()==btnNewButton) {
	String s=textField.getText();
	if(s.equals("")) {
	    JOptionPane.showMessageDialog(null, "the text feild is empty", "Error", JOptionPane.ERROR_MESSAGE);

	}else {
 //i=		sys.searchbyname(s);
		i=sys.searchbyname(s);
if(i==null) {
	lblNewLabel_1.setText("Not found");
}else {
	lblNewLabel_1.setText("name : "+i.getName()+ " phone : "+i.getPhonenumber()+" Email : "+i.getEmail());
	
	
}

	}
	
}




if(e.getSource()==btnNewButton_2) {
	
	if(i==null ) {
		  JOptionPane.showMessageDialog(null, "NOT FOUND", "Error", JOptionPane.ERROR_MESSAGE);
	}else {

		try {
			sys.deletecontact(i);
			JOptionPane.showMessageDialog(null, "deleted succsusfuly ", "Done", JOptionPane.INFORMATION_MESSAGE);
			textField.setText("");
			lblNewLabel_1.setText("Deleted");
			
		} catch (SQLException e1) {
			System.out.println("can't delete");
			e1.printStackTrace();
		}
	
}
}




 if(e.getSource()==btnNewButton_1) {  //update
	 
		if(i==null ) {
			  JOptionPane.showMessageDialog(null, "NOT FOUND ", "Error", JOptionPane.ERROR_MESSAGE);
		}else {

		updateGUI up = new updateGUI(sys,i);
		
	}
	 
	 
		
		
 }









if(e.getSource()==btnNewButton_3) { //add
addcontactGUI add =new addcontactGUI(sys);

}




if(e.getSource()==btnNewButton_4) { //show all
	allcontactsGUI a= new allcontactsGUI();
}


}
 
 
 
 
 
 
 
 
 
}
