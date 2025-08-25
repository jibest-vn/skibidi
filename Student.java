package javnangcao;

public class Student {
	//khai bao 4 thuoc tinh khop voi ben DB
	private int id;
	private String fistname;
	private String lastname;
	private String email;
	
	public Student() {
		
	}
    public Student(int id, String fistname, String lastname, String email) {
		super();
		this.id = id;
		this.fistname = fistname;
		this.lastname = lastname;
		this.email = email;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFistname() {
		return fistname;
	}
	public void setFistname(String fistname) {
		this.fistname = fistname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "student [id=" + id + ", fistname=" + fistname + ", lastname=" + lastname + ", email=" + email + "]";
	}
}
