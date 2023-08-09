import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class updateGUI implements ActionListener, KeyListener {
	 JFrame frame;
	 JTextField textField;
	 JTextField textField_1;
	 JButton	 btnNewButton;
	 JTextField	textField_3 ;
	 
	 addressbook sys;
	 
	 contact i;
	updateGUI(addressbook sys ,contact i){
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.sys=sys;
		this.i=i;
		JLabel lblNewLabel = new JLabel("update contact");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(140, 11, 140, 35);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		textField = new JTextField();
		textField.setBounds(194, 80, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(i.getName());
		textField.setEditable(false);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 121, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(i.getEmail()+"");
		textField_1.addKeyListener(this);
		
		
		JLabel lblNewLabel_1 = new JLabel("name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(123, 80, 61, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(123, 112, 61, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(123, 150, 61, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		
			textField_3 = new JTextField();
		textField_3.setBounds(194, 160, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(i.getPhonenumber()+"");
		textField_3.addKeyListener(this);
		
		
		
		
		
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		
		
		
		
		
			 btnNewButton = new JButton("Submit");
			btnNewButton.setBounds(273, 200, 89, 23);
			frame.getContentPane().add(btnNewButton);
			
			frame.setBounds(100, 100, 450, 300);
			
			btnNewButton.addActionListener(this);
			
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			boolean b = false;
			
				if(textField_1.getText().equals("")||textField_3.getText().equals("")) {
					  JOptionPane.showMessageDialog(null, "the text feild is empty", "Error", JOptionPane.ERROR_MESSAGE);

				}else{
					int phonenb = Integer.parseInt(textField_3.getText());
					String email = textField_1.getText();
					
					if(isValidEmail(email)) {
						try {
						b=	sys.updatecontact(i.getName(),phonenb,email);
						} catch (SQLException e1) {
						
							e1.printStackTrace();
						}
						
						
					}else {
						 JOptionPane.showMessageDialog(null, "enter an verified email ", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
					if(b==true) {
							 JOptionPane.showMessageDialog(null, "contact updated !!.", "Information", JOptionPane.INFORMATION_MESSAGE);
							 frame.dispose();
						}else {
							  JOptionPane.showMessageDialog(null, "error", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					
				}
	
	
			
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource()==textField_3) {
		  char c = e.getKeyChar();
          if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
              e.consume();
          }
		}
          
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
