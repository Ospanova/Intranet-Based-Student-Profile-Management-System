package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Database implements Serializable {
	static Vector<Course> courses = new Vector<Course>();;
	static Vector<Student> students  = new Vector<Student>();
	static Vector <Teacher> teachers = new Vector <Teacher>();
	static Vector <Facultity> facultities = new Vector <Facultity>();
	static Vector<Executor> executors  = new Vector<Executor>();
	static Vector <Transcript> transcripts = new Vector <Transcript> ();
	static Vector <News> news = new Vector <News> ();
	//static Queue <Order> orders = (Queue<Order>) new  Vector <Order>();
	static Vector <Order> orders =  new  Vector <Order>();
	static Vector <Manager> managers = new Vector <Manager>();
	static final Admin admin = new Admin("Aida", "Ospanova", Gender.GIRL, "a.", "1");
	
	public static void desFaculties() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("faculties");
		oin = new ObjectInputStream(fis);
		facultities = (Vector<Facultity>) oin.readObject();
	}
	
	public static void serFaculties()throws IOException{
		fos = new FileOutputStream("faculties");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(facultities);
		oos.close();
	}
	
	public static void desTranscripts() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("transcripts");
		oin = new ObjectInputStream(fis);
		transcripts = (Vector<Transcript>) oin.readObject();
	}
	
	public static void serTranscripts()throws IOException{
		fos = new FileOutputStream("transcripts");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(transcripts);
		oos.close();
	}
	
	public static void desExecutors() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("executors");
		oin = new ObjectInputStream(fis);
		executors = (Vector <Executor>) oin.readObject();
	}
	
	public static void serExecutors()throws IOException{
		fos = new FileOutputStream("executors");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(executors);
		oos.close();
	}
	
	public static void addTeacher(Teacher teacher) {

		teachers.add(teacher);
	}
	public static void addStudent(Student student) {
		students.add(student);
	}
	public static void addNews(News n) {
		news.add(n);
	}
	static FileInputStream fis;
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	static ObjectInputStream oin;
	public static void desCourses() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("courses");
		oin = new ObjectInputStream(fis);
		courses = (Vector<Course>) oin.readObject();
	}
	public static void serCourses()throws IOException{
		fos = new FileOutputStream("courses");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		oos.close();
	}
	public  static void desStudents() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("students");
		oin = new ObjectInputStream(fis);
		students = (Vector<Student>) oin.readObject();
	}
	public static void serStudents()throws IOException{
		fos = new FileOutputStream("students");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(students);
		oos.close();
	}
	public  static void desTeachers() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("teachers");
		oin = new ObjectInputStream(fis);
		teachers = (Vector<Teacher>) oin.readObject();
	}
	public static void serTeachers()throws IOException{
		fos = new FileOutputStream("teachers");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(teachers);
		oos.close();
	}
//	

	
	
}
