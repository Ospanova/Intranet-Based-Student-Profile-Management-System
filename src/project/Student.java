package project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class Student extends User{
	private Double GPA;
	private Transcript transcript = new Transcript();;
	//private HashMap <Course, Mark > courses;
	private Schedule schedule;
	private Speciality speciality;
	private Facultity facultity;
	public ArrayList <Course> doneCources =  new ArrayList <Course> ();
	public HashMap < Course, Attendence > attendenceOfSt = new HashMap < Course, Attendence >();
	Vector<Course> courses = new Vector<Course>();
	public Student(String name, String lastName, Gender gender, String username, String password, int fId, int sId, double gpa) {
		super(name,lastName,gender,username, password);
		for (Facultity f : Database.facultities) {
			if (f.getID() == fId) {
				this.facultity = f;
				for (Speciality s : f.specialities)
					if (s.getID() == sId)
						this.speciality = s;
			}
		}
		
		this.GPA = gpa;
		this.setDegree(3);
		this.setID(Database.students.size()+1);
	}
	public void  setGPA(Double gpa) {
		this.GPA = gpa;
	}
	public double getGPA() {
		return this.GPA;
	}
	public Student () {
		this.facultity = new Facultity(1);
		//this.facultity.addSpec();
		//this.speciality = this.facultity.specialities.get(0);
		this.setDegree(3);
		this.GPA = (double) 0;
	}
	public void registerForCourse (Course c) {
		
		 Manager.asignCourses(c, this);
	}
	public void setPr(Course c) {
		this.attendenceOfSt.get(c).setPr();
	}
	public void rateTeacher (Teacher t, int rate) {
		t.rates.addElement(rate);
	}
	public Transcript viewTranscript() {
		return this.transcript;
	}
	public void setMark(Course c, Mark m) {
		this.transcript.setMark(c, m);
	}
	public Transcript getTranscript() {
		return this.transcript;
	}
	public String toString1() {
	   return super.toString1() + " " + this.getID();
	}
	public String showTranscript() {
		String res = "";
		res  += "Transcript : " + this.getGPA();
		if (this.transcript.attestation.isFinish()){
			Set <Course> keySet = this.transcript.attestation.marksofAt.keySet();
		
		for (Course course : keySet) {
			if (this.transcript.getTotalMark(course, this) >= 95) {
				res += course.getName() + " " + "A\n";
			}
			else if (this.transcript.getTotalMark(course, this) >= 90) {
				res += course.getName() + " " + "A-\n";
			}
			else if (this.transcript.getTotalMark(course, this) >= 85) {
				res += course.getName() + " " + "B\n";
			}
			else if (this.transcript.getTotalMark(course, this) >= 80) {
				res += course.getName() + " " + "B\n";
			}
			else if (this.transcript.getTotalMark(course, this) >= 75) {
				res += course.getName() + " " + "B-\n";
			}
			else if (this.transcript.getTotalMark(course, this) >= 70) {
				res += course.getName() + " " + "C\n";
			}
			else if (this.transcript.getTotalMark(course, this) >= 65) {
				res += course.getName() + " " + "C-\n";
			}
			else if (this.transcript.getTotalMark(course, this) >= 50) {
				res += course.getName() + " " + "D\n";
			}
			else if (this.transcript.getTotalMark(course, this)< 50) {
				res += course.getName() + " " + "F\n";
			}
		}
		return res;
		}
		return "Attestation isn't finished";

	}
}
