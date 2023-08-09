import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class studentmangmentsystem {
	
	
	static ArrayList<student> students= new ArrayList<>();
	 static  Connection con;
	
	
	studentmangmentsystem() throws SQLException{
		database db = new database();
		con=db.connect();
		java.sql.Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from students");  
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" " +rs.getString(2)+ rs.getDouble(3));
			student s = new student(rs.getString(2), rs.getInt(1), rs.getDouble(3));
			students.add(s);
		}
		
		
	}
	//ResultSet rs=stmt.executeQuery("select * from students");  
	//while(rs.next())  
	//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	//stmt.executeUpdate
	
	
	public void addstudent(String name ,double grade ) throws SQLException {
		  PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO students (name,grade) VALUES (?, ?)");
          preparedStatement.setString(1, name);
         
          preparedStatement.setDouble(2, grade);

          // Execute the INSERT statement
          int rowsAffected = preparedStatement.executeUpdate();

          if (rowsAffected > 0) {
              System.out.println("Data inserted successfully!");
          } else {
              System.out.println("Failed to insert data.");
          }
		
          
          
          preparedStatement = con.prepareStatement("select rollnumber from  students  where   name like ? ");
    	  
          preparedStatement.setString(1, name);
         
         


         
             ResultSet resultSet =  preparedStatement.executeQuery();

           int id=0;
             while (resultSet.next()) {
                  id = resultSet.getInt("rollnumber");
             }
          
          
          
  
  		 
          
          student e =new student(name,id,grade);
		students.add(e);
	}
	
	
	public void dellstudent(student e) throws SQLException {
		java.sql.Statement stmt=con.createStatement();
		stmt.executeUpdate(" delete from students where rollnumber ="+e.getRollnumber());
		students.remove(e);
	}
	
	
	public student searchbyname(String name) {
		
		for (student i:students) { 
			if(i.getName().equals(name)) {
				return i;
			}
			
		}
		return null;
			
	}
	
	public  boolean updategrade(String name , double newgrade) throws SQLException {
		student i = searchbyname(name);
		if (i==null) {
			return false;
		}else {
			students.get(students.indexOf(i)).setGrade(newgrade);
			
			String sqlUpdate = "UPDATE students SET grade = ?  WHERE rollnumber = ?";

            // Create a PreparedStatement and set the parameter values
            PreparedStatement preparedStatement = con.prepareStatement(sqlUpdate);
            preparedStatement.setDouble(1, newgrade);
            preparedStatement.setInt(2, i.getRollnumber());

            
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Failed to update data.");
            }
			return true;
		}
	}
	

}
