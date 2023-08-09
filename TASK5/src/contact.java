
public class contact {
	private int id;
	
	



	private String name ;
	private int phonenumber;
	private String email;
	
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getName() {
		return name;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public String getEmail() {
		return email;
	}
	
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public contact(int id ,String name, int phonenumber, String email) {
		        this.id=id;
				this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	
	
	

}
