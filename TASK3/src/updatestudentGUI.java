import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class updatestudentGUI implements ActionListener, KeyListener {
	 JFrame frame;
	 JTextField textField;
	 JTextField textField_1;
	 JButton	 btnNewButton;
	 studentmangmentsystem sys;
	 student i;
	updatestudentGUI(studentmangmentsystem sys ,student i){
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.sys=sys;
		this.i=i;
		JLabel lblNewLabel = new JLabel("update Student");
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
		textField_1.setText(i.getGrade()+"");
		textField_1.addKeyListener(this);
		
		
		JLabel lblNewLabel_1 = new JLabel("name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(123, 80, 61, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Grade :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(123, 112, 61, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		
		
		
		
		
			 btnNewButton = new JButton("Submit");
			btnNewButton.setBounds(273, 154, 89, 23);
			frame.getContentPane().add(btnNewButton);
			frame.setBounds(100, 100, 450, 300);
			
			btnNewButton.addActionListener(this);
			
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			boolean b = false;
			
				if(textField_1.getText().equals("")) {
					  JOptionPane.showMessageDialog(null, "the text feild is empty", "Error", JOptionPane.ERROR_MESSAGE);

				}else{
					double number = java.lang.Double.parseDouble(textField_1.getText());
					try {
					b=	sys.updategrade(i.getName(), number);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
						if(b==true) {
							 JOptionPane.showMessageDialog(null, "student updated !!.", "Information", JOptionPane.INFORMATION_MESSAGE);
							 frame.dispose();
						}else {
							  JOptionPane.showMessageDialog(null, "error", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					
				}
				
			textField.setText("");	
			textField_1.setText("");
			
	
			
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		  char c = e.getKeyChar();
          if (!(Character.isDigit(c) || c == '.' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
              e.consume();
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
	
	
	
	
	
	
	
	
}
