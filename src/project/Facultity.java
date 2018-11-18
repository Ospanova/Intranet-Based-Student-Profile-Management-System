package project;

import java.io.Serializable;
import java.util.ArrayList;

public class Facultity  implements Serializable {
	private int ID;
	private String name ;
	
	public Facultity (int id) {
		
		this.ID = id;
	}
	ArrayList<Speciality> specialities  = new ArrayList<Speciality>();
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addSpec() {
		if (this.ID == 1) {
			this.name = "FIT";
			this.specialities.add(new Speciality ("AC", 1));
			this.specialities.add(new Speciality ("IS", 2));
			this.specialities.add(new Speciality ("CSE", 3));
		}
		else if (this.ID == 2) {
			this.name = "BS";
			this.specialities.add(new Speciality ("Finance", 1));
			this.specialities.add(new Speciality ("Management", 2));
		}
	}
}
