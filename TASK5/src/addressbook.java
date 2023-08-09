import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class addressbook {
 static   ArrayList<contact> contacts=new ArrayList();
 static  Connection con;
 static java.sql.Statement stmt;
 
 
 addressbook() throws SQLException{
	 
		database db = new database();
		con=db.connect();
		java.sql.Statement stmt=con.createStatement();
		this.stmt=stmt;
		
		ResultSet rs=stmt.executeQuery("select * from contact");  
		while(rs.next()) {
			System.out.println( rs.getInt(1) +"   "+rs.getString(2)+" " +rs.getString(3)+ rs.getString(4));
			int phonenb=Integer.parseInt(     rs.getString(3));
			
			contact c = new contact(rs.getInt(1),rs.getString(2),phonenb,rs.getString(4));
			contacts.add(c);
		}
 }
 
 
public void addcontact(String name ,int phone , String email) throws SQLException {
	
	
	  PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO contact (name,phonenumber,email) VALUES (?,?,?)");
	  
      preparedStatement.setString(1, name);
     
      preparedStatement.setInt(2, phone );
      preparedStatement.setString(3, email);


      // Execute the INSERT statement
      int rowsAffected = preparedStatement.executeUpdate();

      
      
      
      
      
      
     
      
      
      
      
      
      
      
      
      
      
      if (rowsAffected > 0) {
          System.out.println("Data inserted successfully!");
      } else {
          System.out.println("Failed to insert data.");
      }
	
      
      
      
   preparedStatement = con.prepareStatement("select id from  contact where   name like ? ");
	  
      preparedStatement.setString(1, name);
     
     


     
         ResultSet resultSet =  preparedStatement.executeQuery();

       int id=0;
         while (resultSet.next()) {
              id = resultSet.getInt("id");
         }
      
      
    
		 
      
      contact e =new contact(id ,name ,phone, email);
      contacts.add(e);
	
	
	
	
	
	
}

public void deletecontact(contact c) throws SQLException {
	contacts.remove(c);
	
	stmt.executeUpdate(" delete from contact where id ="+c.getId());
	contacts.remove(c);
}


public contact searchbyname(String n) {
	for (contact i : contacts) {
		if(i.getName().equals(n)) {
			return i;
		}
	}
	return null;
	
}


public  boolean updatecontact(String name , int phone , String email) throws SQLException {
	contact i = searchbyname(name);
	if (i==null) {
		return false;
	}else {
		contacts.get(contacts.indexOf(i)).setPhonenumber(phone);
		contacts.get(contacts.indexOf(i)).setEmail(email);
		
		String sqlUpdate = "UPDATE contact SET phonenumber = ? ,name=?  WHERE id = ?";

        // Create a PreparedStatement and set the parameter values
        PreparedStatement preparedStatement = con.prepareStatement(sqlUpdate);
        preparedStatement.setInt(1, phone);
        preparedStatement.setString(2, email);
        
        preparedStatement.setInt(3, i.getId());

        
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
