package project;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;

public class Manager extends Employee {
	public Manager () {
		super();
	}
	public Manager (String name, String lastName, Gender gender,String username, String password) {
		this.setDegree(2);
		this.setPassword(password);
		this.setUserName(username);
		this.setGender(gender);
		this.setName(name);
		this.setLastName(lastName);
	}
	public void addNews(News n) {
		Database.news.add(n);
	}
	public static boolean isRegisterOpen = false;
	public void openReg() {
		isRegisterOpen = true;
	}
	
	public static boolean asignCourses(Course c, Student s) {
		
		int sum = 0;
		if (isRegisterOpen) {
			Set <Course> keySet = s.attendenceOfSt.keySet();
			for (Course course : keySet) {
				sum += c.getCredits();
			}
		}
		if (sum >= 21 - c.getCredits()) {
			return false;
		}
		if (c.getPrerequisite() != null) {
			for (Course course : s.doneCources) {
				if (course.equals(c.getPrerequisite()))
					return true;
			}
		return false;
		}
		return true;
	
	}
}
