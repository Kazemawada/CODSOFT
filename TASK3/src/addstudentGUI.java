import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D.Double;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addstudentGUI implements ActionListener, KeyListener {

	 JFrame frame;
	 JTextField textField;
	 JTextField textField_1;
	studentmangmentsystem sys;
	JButton btnNewButton;
	
	
	addstudentGUI(	studentmangmentsystem sys){
		this.sys=sys;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD student");
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
		
		JLabel lblNewLabel_2 = new JLabel("Grade :");
		lblNewLabel_2.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblNewLabel_2.setBounds(33, 155, 60, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
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
			if(textField.getText().equals("")||textField_1.getText().equals("")) {
				  JOptionPane.showMessageDialog(null, "the text feild is empty", "Error", JOptionPane.ERROR_MESSAGE);

			}else{
				double number = java.lang.Double.parseDouble(textField_1.getText());
				
				try {
					sys.addstudent(textField.getText(), number       );
					 JOptionPane.showMessageDialog(null, "student added !!.", "Information", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
