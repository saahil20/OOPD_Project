
public class Doctor {
	private int doctor_id;
	private String name;
	private String username;
	private int age;
	private String email;
	
	Doctor(String name, String username, int age, String email, int doctor_id) {
		this.doctor_id = doctor_id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.username = username;
	}
	
	void showPatients() {
		// write query for patients
			
	}
	
	//getters
	public int getDoctorId() {
		return this.doctor_id;
	}
	
	public int getDoctorAge() {
		return this.age;
	}
	
	public String getDoctorName() {
		return this.name;
	}
	
	public String getDoctorEmail() {
		return this.email;
	}
	
	public String getDoctorUsername() {
		return this.username;
	}
	
	//setters
	void setDoctorEmail(String new_email) {
		this.email = new_email;
	}
	
}
