package project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;
import java.util.ArrayList;
public class Teacher extends Employee {
	 HashMap<Course, Vector<Student>>  students = new HashMap<Course, Vector<Student>>();
	 Vector <Course> courses = new Vector <Course>();
	 //TreeMap <Student, ArrayList <Course_time> >  times;
	 HashMap <Course, Vector <Filee>> filesOfCourse = new HashMap <Course, Vector <Filee>>();
	 
	public Teacher() {
		super();
		this.setDegree(4);
	}
	public Teacher(String name, String lastName, Gender gender, String username, String password) {
		super(name,lastName,gender,username, password);
		this.setDegree(4);
	}
	Vector<Integer> rates = new Vector<>(); 
	
	public void putMark(int id,Course c, Mark mark) {
		Database.students.get(id).setMark(c, mark);
	}
	public double giveRate () {
		double sum = 0;
		for (Integer i : rates) {
			sum += i;
		}
		return sum/rates.size(); 
	}
	public void sendOrder(Order o) {
		
		Database.orders.add(o);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((filesOfCourse == null) ? 0 : filesOfCourse.hashCode());
		result = prime * result + ((rates == null) ? 0 : rates.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (filesOfCourse == null) {
			if (other.filesOfCourse != null)
				return false;
		} else if (!filesOfCourse.equals(other.filesOfCourse))
			return false;
		if (rates == null) {
			if (other.rates != null)
				return false;
		} else if (!rates.equals(other.rates))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}
	public void setPr(Course c, Student s) {
		
			s.setPr(c);
		
	}
	public boolean showStbyCourse(Course c) {
		if (!this.students.containsKey(c) && this.students.get(c).size() == 0 )
			return false;
		for(int i = 0; i < this.students.get(c).size(); ++i)  {
			System.out.println((i + 1)  + " "+ this.students.get(c).get(i).getName() + " " + this.students.get(c).get(i).getLastName());
		}
		return true;
	}
}
