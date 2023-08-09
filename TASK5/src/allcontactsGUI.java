
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class allcontactsGUI extends JFrame{

	static  Connection con;
	  private JTable table;
	
	allcontactsGUI(){
		database db = new database();
		con=db.connect();
		
		 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // Initialize the table with data
	        String[] columnNames = {"ID", "Name", "Phone","Email"};
	        Object[][] data = getStudentDataFromDatabase();

	        // Create the JTable
	        table = new JTable(data, columnNames);

	        // Add the table to a scroll pane
	        JScrollPane scrollPane = new JScrollPane(table);
	        add(scrollPane, BorderLayout.CENTER);

	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
		
		table.setEnabled(false);;
		
		
	}
	
	
	 private Object[][] getStudentDataFromDatabase() {
	       
	        String query = "SELECT * FROM contact";

	        try (
	        		
	             PreparedStatement statement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	             ResultSet resultSet = statement.executeQuery()
	            		 
	        		) {

	            // Get the number of rows in the result set
	           
	           int rowCount =  resultSet.getFetchSize();
	            if (resultSet.last()) {
	                rowCount = resultSet.getRow();
	                resultSet.beforeFirst(); // Move the cursor back to the beginning
	            }

	            // Create a 2D array to hold the data
	            Object[][] data = new Object[rowCount][3];
	            int rowIndex = 0;

	            // Iterate through the result set and populate the data array
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                double phone = resultSet.getInt("phonenumber");
	                String email = resultSet.getString("email");
	                data[rowIndex][0] = id;
	                data[rowIndex][1] = name;
	                data[rowIndex][2] = phone;
	                data[rowIndex][3]=email;
	                rowIndex++;
	            }

	            return data;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return new Object[0][0];
	        }
	    }
	
	
}
