package project;

import java.io.Serializable;

public class Speciality  implements Serializable
{
	private int ID;
	private String name;
	
	public Speciality (String name, int id) {
		this.name = name;
		this.ID = id;
	}
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

}
