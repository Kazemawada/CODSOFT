
   


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class database {
	
	
	
	public  Connection connect() {
		
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","@Kazem1");  
		
		//java.sql.Statement stmt=con.createStatement();
		
		//ResultSet rs=stmt.executeQuery("select * from students");  
		//while(rs.next())  
		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		
		
		
		//stmt.executeUpdate("insert into dept values (1,'bkaa')");
		
		
			return con;  
		
		}catch(Exception e){ System.out.println(e+"   no connection!!!!");
		
		
		}
	return null;
		} 
	

}
