import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D.Double;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addcontactGUI implements ActionListener, KeyListener {

	 JFrame frame;
	 JTextField textField;
	 JTextField textField_1;
	addressbook sys;
	JButton btnNewButton;
	
	JTextField textField_2;
	
	addcontactGUI(	addressbook sys){
		this.sys=sys;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD Contact");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(141, 11, 130, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name  :");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 15));
		lblNewLabel_1.setToolTipText("name");
		lblNewLabel_1.setBounds(33, 74, 60, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(103, 79, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone :");
		lblNewLabel_2.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblNewLabel_2.setBounds(33, 155, 60, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		
		
			textField_2 = new JTextField();
		textField_2.setBounds(103, 120, 86, 20);
		frame.getContentPane().add(textField_2);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("email :");
		lblNewLabel_3.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblNewLabel_3.setBounds(33, 120, 60, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		
		 btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(273, 154, 89, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 450, 300);
		
		btnNewButton.addActionListener(this);
		
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 155, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.addKeyListener(this);
		
		
		
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")) {
				  JOptionPane.showMessageDialog(null, "the text feild is empty", "Error", JOptionPane.ERROR_MESSAGE);

			}else{
				int number = java.lang.Integer.parseInt(textField_1.getText());
			String	email=textField_2.getText();
				
			if(isValidEmail(email)) {
				
			
				
				try {
					sys.addcontact(textField.getText(), number ,  email    );
					 JOptionPane.showMessageDialog(null, "Contact added !!.", "Information", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}else {
					
					  JOptionPane.showMessageDialog(null, "error your email is not Valid Email", "Error", JOptionPane.ERROR_MESSAGE);

				}
				
				
			}
			
		textField.setText("");	
		textField_1.setText("");
		textField_2.setText("");
		
}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		  char c = e.getKeyChar();
          if (!(Character.isDigit(c)  || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
              e.consume();
          }
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	
	
	  public static boolean isValidEmail(String email) {
	      
	        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }

}
