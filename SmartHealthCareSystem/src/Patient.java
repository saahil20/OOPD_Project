
public class Patient {
	// 
	private int patient_id;
	private String name;
	private String phone_num;
	private String username;
	private String email;
	
	// for patient id
	static int count = 0;
	
	Patient(String name, String phone_num, String username, String email ){
		this.name = name;
		this.phone_num = phone_num;
		this.username = username;
		this.email = email;
		this.patient_id = count+1;
	}
	
	//getters 
	int getPatientId() {
		return this.patient_id;
	}
	
	String getName() {
		return this.name;
	}
	
	String getPhone() {
		return this.phone_num;
	}
	
	String getUserName() {
		return this.username;
	}
	
	String getEmail() {
		return this.email;
	}
	
	//setters
	
	void setName(String n) {
		this.name = n;
	}
	
	void setPhone(String p) {
		this.phone_num = p;
	}
	
	void setUserName(String u) {
		this.username = u;
	}
	
	void setEmail(String e) {
		this.email = e;
	}
	
	// methods
	
	
}

