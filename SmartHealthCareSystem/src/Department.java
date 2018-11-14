import java.util.ArrayList;

public class Department {
	// all docs
	
	private String name;
	public ArrayList <Doctor> all_doctors = new ArrayList<> ();
	
	Department(String name) {
		this.name = name;
	}
	
	void addDoctor(Doctor doc) {
		all_doctors.add(doc);
	}
	
	void removeDoctor(Doctor doc) {
		all_doctors.remove(doc);
	}
	
	
}
