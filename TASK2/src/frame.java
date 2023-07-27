import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;


public class frame implements ActionListener {

	    JFrame frame = new JFrame();
		JButton btnNewButton = new JButton("submit");
		JButton btnNewButton1 = new JButton("chose file");
		JTextArea textArea = new JTextArea();
		
		
		
		
	public frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		JLabel lblNewLabel = new JLabel("Word counter");
		lblNewLabel.setBounds(172, 11, 100, 35);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		scrollPane.setBounds(41, 96, 200, 100);
		frame.getContentPane().add(scrollPane);


		
		JLabel lblNewLabel1 = new JLabel("write here");
		lblNewLabel1.setBounds(31, 57, 100, 14);
		frame.getContentPane().add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel("Choose File (.txt)");
		lblNewLabel2.setBounds(325, 57, 100, 14);
		frame.getContentPane().add(lblNewLabel2);
		
	
		btnNewButton.setBounds(41, 220, 110, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		
		btnNewButton1.setBounds(325, 120, 89, 23);
		frame.getContentPane().add(btnNewButton1);
		btnNewButton1.addActionListener(this);
		
		
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnNewButton) {
			
	String	txt=	textArea.getText();
	if(txt.isEmpty()) {
		JOptionPane.showMessageDialog(frame, "Error  you did not enter any text " , " An error occurred:", JOptionPane.ERROR_MESSAGE);
	}else {
			System.out.println("you entered "+txt);
			
			
			
			
			wordcount count =new wordcount(txt);
		String result=	count.output();
		
		JOptionPane.showMessageDialog(frame, result , " the result :", JOptionPane.DEFAULT_OPTION);
			
	}
	
	
		
		}else {
			System.out.println("enter a file");
			
			
			
			
			 JFileChooser fileChooser = new JFileChooser();

      
             fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                 public boolean accept(File file) {
                     return file.getName().toLowerCase().endsWith(".txt") || file.isDirectory();
                 }

                 public String getDescription() {
                     return "Text Files (*.txt)";
                 }
             });

             int returnVal = fileChooser.showOpenDialog(frame);

             if (returnVal == JFileChooser.APPROVE_OPTION) {
                 File selectedFile = fileChooser.getSelectedFile();
                
                 String fileContent = null;
                 if (selectedFile.getName().toLowerCase().endsWith(".txt")) {
                      fileContent = readTextFile(selectedFile);
                      if(fileContent.isEmpty()) {
                  		JOptionPane.showMessageDialog(frame, "Error  you did not enter any text " , " An error occurred:", JOptionPane.ERROR_MESSAGE);
                  	}else {
                  		
                 
                      
          			wordcount count =new wordcount(fileContent);
          			String result=	count.output();
          			
          			JOptionPane.showMessageDialog(frame, result , " the result :", JOptionPane.DEFAULT_OPTION);
                      
                      
                      
                     System.out.println(fileContent); // Print the content of the file to the console
                      	}
                     
                 } else {
                     JOptionPane.showMessageDialog(frame, "Error: You selected a file with no .txt extension.",
                             "An error occurred", JOptionPane.ERROR_MESSAGE);
                 }
                 
                
             }
         
			
			
			
			
			
			
			
			
			
		}
		
		
		
	}
	
	
	
    private static String readTextFile(File file) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
	
	
}
