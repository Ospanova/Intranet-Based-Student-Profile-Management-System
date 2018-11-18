package project;
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable  {
	private int credits;
	private String name;
	private Course prerequisite;
	private ArrayList<Filee> files = new ArrayList<Filee>();
	ArrayList<SIS> listOfSIS = new ArrayList<SIS> ();
	ArrayList<Lab> listOfLab = new ArrayList<Lab>() ;
	public Course () {
		this.prerequisite = null;
	}
	public Speciality speciality;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + ((files == null) ? 0 : files.hashCode());
		result = prime * result + ((listOfLab == null) ? 0 : listOfLab.hashCode());
		result = prime * result + ((listOfSIS == null) ? 0 : listOfSIS.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((prerequisite == null) ? 0 : prerequisite.hashCode());
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (files == null) {
			if (other.files != null)
				return false;
		} else if (!files.equals(other.files))
			return false;
		if (listOfLab == null) {
			if (other.listOfLab != null)
				return false;
		} else if (!listOfLab.equals(other.listOfLab))
			return false;
		if (listOfSIS == null) {
			if (other.listOfSIS != null)
				return false;
		} else if (!listOfSIS.equals(other.listOfSIS))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prerequisite == null) {
			if (other.prerequisite != null)
				return false;
		} else if (!prerequisite.equals(other.prerequisite))
			return false;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		return true;
	}
	public Course (int credits, String name) {
		this.credits = credits;
		//this.files = files;
		this.name = name;
		this.prerequisite = null;
//		this.prerequisites = prerequisites;
	}
	public void setPrerequisite (Course c) {
		this.prerequisite = c;
	}
	public int getCredits () {
		return this.credits;
	}
	public Course getPrerequisite () {
		return this.prerequisite;
	}
	public ArrayList<Filee> getFiles () {
		return this.files;
	}
	public String getName () {
		return this.name;
	}
	 public String toString1() {
		    return this.name;
		  }
	
}
