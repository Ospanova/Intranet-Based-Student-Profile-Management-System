package project;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

public class Admin extends User {
	public Admin (String name, String lastName, Gender gender, String username, String password) {
		super(name,lastName,gender,username, password);
		this.setDegree(0);
	}
	public int findUser (User s) {
		if (s.getDegree() == 3) {
		for (int i = 0; i < Database.students.size(); ++i)
			if (Database.students.get(i).equals(s))
				return i;
			
		}
		else if (s.getDegree() == 4) {
			for (int i = 0; i < Database.teachers.size(); ++i)
				if (Database.teachers.get(i).equals(s))
					return i;
				
		}
		return -1;
	}
	public void addCourse(Teacher t, Course c) {
		Database.courses.addElement(c);
		t.courses.addElement(c);
		t.students.put(c, new Vector <Student>());
	}
	public void addStudents(Teacher t, Course c, Student s) {
		Database.students.add(s);
		t.students.get(c).add(s);
	}
	public void addUser (User c) throws IOException {
		if (findUser(c) < 0) {
			if (c.getDegree() == 3) {
				Database.students.add((Student)c);
			}
			else if (c.getDegree() == 4) {
				Database.teachers.add((Teacher)c);
			}
	}
	}
	public void removeUser (User c) {
		if (findUser(c) >= 0)
		{
			if (c.getDegree() == 3) {
				Database.students.remove(findUser(c));
			}
			else if (c.getDegree() == 4) {
				Database.teachers.remove(findUser(c));
			}
		}
			//users.remove(findUser(cur));
	}
	public void updateUser (User cur, User newu) {
		if (findUser(cur) >= 0 && findUser(newu) == -1) {
//			users.add(newu);
//			users.remove(findUser(cur));
			if (cur.getDegree() == 3) {
				Database.students.add((Student)newu);
				Database.students.remove(findUser(cur));
			}
			else if (cur.getDegree() == 4) {
				Database.teachers.add((Teacher)newu);
				Database.teachers.remove(findUser(cur));
			}
		}
	}
	
	
}
