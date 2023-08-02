import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class allstudent extends JFrame{

	static  Connection con;
	  private JTable table;
	
	allstudent(){
		database db = new database();
		con=db.connect();
		
		 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // Initialize the table with data
	        String[] columnNames = {"Roll Number", "Name", "Grade"};
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
	       
	        String query = "SELECT * FROM students";

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
	                int rollNumber = resultSet.getInt("rollnumber");
	                String name = resultSet.getString("name");
	                double grade = resultSet.getDouble("grade");
	                data[rowIndex][0] = rollNumber;
	                data[rowIndex][1] = name;
	                data[rowIndex][2] = grade;
	                rowIndex++;
	            }

	            return data;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return new Object[0][0];
	        }
	    }
	
	
}
