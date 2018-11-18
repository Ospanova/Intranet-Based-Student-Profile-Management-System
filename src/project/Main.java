package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static boolean isExit = false;
	public static User cur = null;
	static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	public static void save() throws IOException{
		
		Database.serStudents();
		Database.serCourses();
		Database.serFaculties();
		Database.serTranscripts();
		Database.serTeachers();
	}
	public static void load() throws IOException, ClassNotFoundException{
		if(new File("courses").exists()) {Database.desCourses();}
		if(new File("teachers").exists()) {Database.desTeachers();}
		if(new File("students").exists()) {Database.desStudents();}
		if(new File("faculties").exists())Database.desFaculties();
		if(new File("transcripts").exists())Database.desTranscripts();
	}
	public static void main(String args[]) throws ClassNotFoundException, IOException {
		
		load();
		//if (showStudents())
			//System.out.println("Good Job");
		//showTeachers();
		//update();
		//Scanner sc = new Scanner(System.in);
		addFac();
		//showFacultity();
		addNews();
		while(true){
		System.out.println("Please write your username:");
		String username = console.readLine();
		System.out.println("Please write your password:");
		String password = console.readLine();
		UserFactory factory = new UserFactory();
		cur = factory.getUser(username, password);
		if (cur == null || !cur.login ) {
			System.out.println("Wrong username or password!!!");
			//break;
			continue;
		}
		
		try {
			menu: while(true){
				System.out.println("What do you want to do?");
				System.out.println("\n 1) Show news \n 2) Change password  \n 3) Show faculties");
				if (cur.getDegree() == 0 ) {
					System.out.println(" 5) Add student \n 6) Add course to teacher \n 7) Add teacher   \n 8) View students \n ");
				}
				else if (cur.getDegree() == 1) {
					System.out.println(" 5) Show orders \n 6) Remove order  \n ");
				}
				else if (cur.getDegree() == 2) {
					System.out.println(" 5) Open registration \n 6) Add news  ");
				}
				else if (cur.getDegree() == 3) {
					System.out.println(" 5) Register for course \n 6) Rate teachers \n 7) View Transcript  ");
				}
				else if (cur.getDegree() == 4) {
					System.out.println(" 5) Put mark \n 6) Give rate \n 7) Set propuski \n 8) Sent order ");
				}
				System.out.println(" 0) Exit\n");
				int choice = Integer.parseInt(console.readLine());
				//System.out.println(choice);
				if (choice < 4) {
					if (choice == 0) {
						System.out.println("Bye!!!"); save();  break menu;
					}
					if(choice == 1){
						while(true){
							if(!showNews()) continue menu;
							System.out.println("\n 1) Return back \n 2) Exit");
							choice = Integer.parseInt(console.readLine());
							if(choice==1) break;
							if(choice==2) {System.out.println("Bye!"); save(); isExit = true;} 
							break;
						}
				}
				else if (choice==2){
							changePassword: while(true){
								System.out.println("Enter your current password:");
								String oldP = console.readLine();
								if (cur.checkP(oldP)) {
									while (true) {
									System.out.println("Enter your new password:");
									String newP = console.readLine();
									System.out.println(newP);
									if (cur.checkP(newP)) {
										cur.changePassword(newP);
										System.out.println("Password is changed!");
										System.out.print("\n 1) Add another teacher  \n 2) Return back \n 3) Exit");
										choice = Integer.parseInt(console.readLine());
										if(choice == 1) continue changePassword;
										if(choice == 2) continue menu;
										if(choice == 3) {System.out.println("Bye!!!"); save();  break menu;}
										break;
									}
									else {
										System.out.println("Minimum length of password is 6");
										continue changePassword;
									}
									}
									//updateUsers();
								}
								else {
									System.out.println("Enter your correct current password again");
									continue changePassword;
								}
							}
						}
						else if (choice==3){
							while(true){
								if(!showFacultity()) continue menu;
								System.out.println(" 1) Return back \n 2) Exit");
								choice = Integer.parseInt(console.readLine());
								if(choice==1) break;
								if(choice==2) {System.out.println("Bye!!!"); save();  isExit = true;} 
							}
							}
				}
				else {
					
					if (cur.getDegree() == 0) {
						//Database.addFac();
						//Database.showFac();
						Admin admin = (Admin) cur;
						if(choice == 5){
							//System.out.println(0);
						addStudent: while(true){
								//System.out.println(Database.fac.get(1).getID());
								System.out.print("Enter name: \n");
								Student d = new Student();
								d.setName(console.readLine());
								
								System.out.print("Enter last name : \n ");
								d.setLastName(console.readLine());
								d.setUserName(d.getName() + "_" + d.getLastName());
								d.setPassword("kbtu2");
								Course c = new Course (0, "Basic");
								d.courses.add(c);
								d.getTranscript().attestation.marksofAt.put(c, new Mark());
								Database.transcripts.add(d.getTranscript());
								
								Database.addStudent(d);
								
								System.out.print("Student added! ");
								System.out.print("\n 1) Add another student  \n 2) Return back \n 3) Exit");
								choice = Integer.parseInt(console.readLine());
								if(choice == 1) continue addStudent;
								if(choice == 2) continue menu;
								if(choice == 3) {System.out.println("Bye!!!"); save();  break menu;}
								break;
							}
						}
						else if (choice == 6){
							addCourse: while(true){
								System.out.println("Enter name of the course: ");
								String name = console.readLine();
								System.out.println("Enter number of the credits of course: ");
								
								Database.courses.add(new Course(Integer.parseInt(console.readLine()), name ));
//								if (!showTeachers()) continue menu;
//								System.out.println("Choose teacher: (Enter number)\n");
//								int id = Integer.parseInt(console.readLine());
//								admin.addCourse(Database.teachers.get(id), new Course(Integer.parseInt(console.readLine()), name ) );
								System.out.println("Course added!");
								System.out.println("\n 1) Add another course  \n 2) Return back \n 3) Exit");
								choice = Integer.parseInt(console.readLine());
								if(choice == 1) continue addCourse;
								if(choice == 2) continue menu;
								if(choice == 3) {System.out.println("Bye!!!"); save();  break menu;}
								break;
							}
						}
						else if (choice == 7){
							addTeacher: while(true){
								System.out.print("Enter name: \n");
								Teacher t = new Teacher();
								t.setName(console.readLine());
								System.out.print("Enter last name : \n ");
								t.setLastName(console.readLine());
								t.setUserName(t.getName() + "-" + t.getLastName());
								t.setPassword("kbtu1");
								Database.addTeacher(t);
								System.out.print("Teacher added! ");
								
								System.out.print("\n 1) Add another teacher  \n 2) Return back \n 3) Exit");
								choice = Integer.parseInt(console.readLine());
								if(choice == 1) continue addTeacher;
								if(choice == 2) continue menu;
								if(choice == 3) {System.out.println("Bye!!!"); save();  break menu;}
								break;
							
						}
						}
						else if (choice == 8){
							if(!showStudents()) continue menu;
							System.out.println("\n 1) Return back \n 2) Exit");
							choice = Integer.parseInt(console.readLine());
							if(choice == 1) continue menu;
							if(choice == 2) {System.out.println("Bye!!!"); save();  break menu;}
							break;
						}
					
						
					}
					
				
				else if (cur.getDegree() == 1) {
					if (choice == 5){
						if(!showStudents()) continue menu;
						System.out.println("\n 1) Return back \n 2) Exit");
						choice = Integer.parseInt(console.readLine());
						if(choice == 1) continue menu;
						if(choice == 2) {System.out.println("Bye!!!"); save();  break menu;}
						break;
					
					}
					else if (choice == 6) {
						System.out.println("Choose order which you want to remove: (Enter number)");
						if(!showStudents()) continue menu;
						Database.orders.remove(Integer.parseInt(console.readLine()) - 1);
						System.out.println("Order is removed!");
						System.out.println("\n 1) Return back \n 2) Exit");
						choice = Integer.parseInt(console.readLine());
						if(choice == 1) continue menu;
						if(choice == 2) {System.out.println("Bye!!!"); save();  break menu;}
						break;
					}
				}
				else if (cur.getDegree() == 2) {
					if (choice == 5) {
					Manager.isRegisterOpen = true;
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(console.readLine());
					if(choice == 1) continue menu;
					if(choice == 2) {System.out.println("Bye!!!"); save();  break menu;}
					break;
					}
					else if (choice == 6) {
						addNews: while(true){
							News n = new News();
							n.setAuthor((Manager) cur);
							System.out.print("Enter aricle: \n");
							n.setArticle(console.readLine());
							System.out.print("Enter content : \n ");
							n.setContent(console.readLine());
							Database.addNews(n);
							System.out.print("News added! ");
							System.out.print("\n 1) Add another news  \n 2) Return back \n 3) Exit");
							choice = Integer.parseInt(console.readLine());
							if(choice == 1) continue addNews;
							if(choice == 2) continue menu;
							if(choice == 3) {System.out.println("Bye!!!"); save();  break menu;}
							break;
						
					}
					}
					
				}
				else if (cur.getDegree() == 3) {
					Student s = (Student) cur;
					if (choice == 5) {
						Register: while(true){
							System.out.println("Choose course: (Enter id)");
							if(!showCourses()) continue menu;
							int i = Integer.parseInt(console.readLine()) - 1;
							s.registerForCourse(Database.courses.get(i));
							//System.out.println("Course " + Database.courses.get(i) +" added to  " + s.firstName);
							System.out.println("\n 1) Add another course  \n 2) Return back \n 3) Exit");
							choice = Integer.parseInt(console.readLine());
							if(choice == 1) continue Register;
							if(choice == 2) continue menu;
							if(choice == 3) {System.out.println("Bye!!!"); save();  break menu;}
							break;
						}
					}
					else if (choice == 6) {
						RateT: while(true){
							if(!showTeachers()) continue menu;
							System.out.println("Choose teacher: (Enter id)");
							if(!showTeachers()) continue menu;
							int i = Integer.parseInt(console.readLine()) - 1;
							System.out.println("Enter rate :");
							int rate = Integer.parseInt(console.readLine());
							s.rateTeacher(Database.teachers.get(i), rate);
							//System.out.println("Course " + Database.courses.get(i) +" added to  " + s.firstName);
							System.out.println("\n 1) Rate another teacher  \n 2) Return back \n 3) Exit");
							choice = Integer.parseInt(console.readLine());
							if(choice == 1) continue RateT;
							if(choice == 2) continue menu;
							if(choice == 3) {System.out.println("Bye!!!"); save();  break menu;}
							break;
						}
					}
					else if (choice == 7) {
						s.showTranscript();
						System.out.println("\n 1) Return back \n 2) Exit");
						choice = Integer.parseInt(console.readLine());
						if(choice == 1) continue menu;
						if(choice == 2) {System.out.println("Bye!!!"); save();  break menu;}
						break;
					}
				}
				else if (cur.getDegree() == 4) {
					Teacher t = (Teacher) cur;
					if (choice  == 5) {
						PutMark : while(true){
							System.out.println("Choose course: (Enter id)");
							if(!showCourses()) continue menu;
							int i = Integer.parseInt(console.readLine()) - 1;
							System.out.println("Choose student: (Enter id)");
							if (!t.showStbyCourse(t.courses.get(i))) {
								System.out.println("\n 1) Choose another course  \n  2) Exit");
								choice = Integer.parseInt(console.readLine());
								if(choice == 1) continue PutMark;
								if(choice == 2) {System.out.println("Bye!!!"); save();  break menu;}
								break;
							}
							int id = Integer.parseInt(console.readLine()) - 1;
							System.out.println(Database.students.get(id).toString1());
							//Student s = Database.students.get(id);
							System.out.println("Enter mark");
							int m = Integer.parseInt(console.readLine());
							Mark mark = new Mark();
							mark.setMark(m);
							//Course c = t.courses.get(i);
							//System.out.println(c.toString1());
							Mark cur = t.students.get(t.courses.get(i)).get(id).getTranscript().attestation.marksofAt.get(t.courses.get(i));
							t.putMark(id, t.courses.get(i), mark);
							Mark cur2 = t.students.get(t.courses.get(i)).get(id).getTranscript().attestation.marksofAt.get(t.courses.get(i));
							//System.out.println(t.courses.get(i).toString1());
							//System.out.println(cur.getMark());
							//System.out.println(cur2.getMark());
							System.out.println(Database.students.get(i).getTranscript().attestation.marksofAt.get(t.courses.get(i)));
							System.out.println(Database.students.get(i).getTranscript().attestation.ToString());
							System.out.println("\n 1) Put mark again  \n 2) Return back \n 3) Exit");
							choice = Integer.parseInt(console.readLine());
							if(choice == 1) continue PutMark;
							if(choice == 2) continue menu;
							if(choice == 3) {System.out.println("Bye!!!"); save();  break menu;}
							break;
					}
					}
					else if (choice == 6) {
						GiveRate : while(true){
							System.out.println(t.giveRate());
								System.out.println("\n 1) Return back  \n  2) Exit");
								choice = Integer.parseInt(console.readLine());
								if(choice == 1) continue menu;
								if(choice == 2) {System.out.println("Bye!!!"); save();  break menu;}
								break;
							}
							
					}
					else if (choice == 7) {
						SetPr :System.out.println("Choose course: (Enter id)");
						if(!showCourses()) continue menu;
						int i = Integer.parseInt(console.readLine()) - 1;
						System.out.println("Choose student: (Enter id)");
						if (!t.showStbyCourse(t.courses.get(i))) {
							System.out.println("\n 1) Choose another course  \n  2) Exit");
							choice = Integer.parseInt(console.readLine());
							if(choice == 1) continue menu;
							if(choice == 2) {System.out.println("Bye!!!"); save();  break menu;}
							break;
						}
						int id = Integer.parseInt(console.readLine()) - 1;
						//Vector <Student > v = new Vector <Student >();
						//v.add(t.students.get(t.courses.get(i)).get(id));
						t.setPr(t.courses.get(i), t.students.get(t.courses.get(i)).get(id) );
						System.out.println("\n 1) Return back  \n  2) Exit");
						if(choice == 1) continue menu;
								if(choice == 2) {System.out.println("Bye!!!"); save();  break menu;}
								break;
							}
					
					else if (choice == 8) {
						SendOrder: while(true){
							System.out.println("Enter order: ");
							String s = console.readLine();
							
							t.sendOrder(new Order(s));
							System.out.println("\n 1) send order again  \n 2) Return back \n 3) Exit");
							choice = Integer.parseInt(console.readLine());
							if(choice == 1) continue SendOrder;
							if(choice == 2) continue menu;
							if(choice == 3) {System.out.println("Bye!!!"); save();  break menu;}
							break;
						}
					}
				}
				 	
			}
		}
		}
			catch (Exception e) {
					System.out.println("Something bad happened... \n Saving resources...");
					e.printStackTrace();
					save();
			}
				cur = null;
		}
	}
	
	private static void update() {
		Course c = new Course (3, "Muzyka");
		Student st= new Student("s1", "s1", Gender.GIRL ,"s1_", "qwertyuiop", 0, 1, 3*(1.0));
		st.courses.add(c);
		st.getTranscript().attestation.marksofAt.put(c, new Mark());
		Database.transcripts.add(st.getTranscript());
		Database.addStudent(new Student("s1", "s1", Gender.GIRL ,"s1_", "qwertyuiop", 0, 1, 3*(1.0)));
		
		Teacher t = new Teacher("t1", "t1", Gender.GIRL,"t1-", "qwertyuiop");
		
		Database.courses.add(c);
		t.courses.add(c);
		
		t.students.put(c, Database.students);
		for (Student s  : Database.students) {
			s.getTranscript().attestation.marksofAt.put(c, new Mark());
		}
		Database.addTeacher(t);
		
		
	}

	public static void addFac () {
		for (int i = 1; i <=2; ++i) {
			Facultity f = new Facultity(i);
			f.setID(i);
			if (f.getID() == 1) {
			f.setName("FIT");
			f.specialities.add(new Speciality ("AC", 1));
			f.specialities.add(new Speciality ("IS", 2));
			f.specialities.add(new Speciality ("CSE", 3));
			}
			if (f.getID() == 2) {
				f.setName("BS");
				f.specialities.add(new Speciality ("Finance", 1));
				f.specialities.add(new Speciality ("Management", 2));
			}
			//f.addSpec();
			Database.facultities.add(f);
			
		}
		
	}
	public static void addNews () {
	
			News news = new News();
			news.setArticle("Delivery of projects of OOP in 1 December");
			Database.news.add(news);
	}
	public static boolean showNews(){
		if(Database.news.size() == 0 ) {
			System.out.println("No news yet...");
			return false;
		}
		for(int i = 0; i < Database.news.size(); i++)
			System.out.println(i + 1 + ")" + Database.news.get(i).toString1());
		return true;
	} 	
	public static boolean showExecutors(){
		if(Database.executors.size()==0) {
			System.out.println("No executors yet...");
			return false;
		}
		for(int i=0; i<Database.executors.size(); i++)
			System.out.println(i+1+ ")" +Database.executors.get(i));
		return true;
	}
	
	public static boolean showFacultity(){
		if(Database.facultities.size() == 0 ) {
			System.out.println("No teachers yet...");
			return false;
		}
		for(int i = 0; i < Database.facultities.size(); i++)
			System.out.println(i + 1 + ")" + Database.facultities.get(i).getName());
		return true;
	} 	
	public static boolean showTeachers(){
		if(Database.teachers.size() == 0 ) {
			System.out.println("No teachers yet...");
			return false;
		}
		for(int i = 0; i < Database.teachers.size(); i++)
			System.out.println(i + 1 + ")" + Database.teachers.get(i).toString1());
		return true;
	} 	
	
	public static boolean showStudents(){
		if(Database.students.size() ==0 ) {
			System.out.println("No students yet...");
			return false;
		}
		for(int i = 0; i < Database.students.size(); i++)
			System.out.println(i + 1 + ")" +Database.students.get(i).toString1());
		return true;
	}
	public static boolean showOrders(){
		if(Database.orders.size() ==0 ) {
			System.out.println("No orders yet...");
			return false;
		}
		for(int i = 0; i < Database.orders.size(); i++)
			System.out.println(i + 1 + ")" +Database.orders.get(i));
		return true;
	}
	public static boolean showCourses(){
		if(Database.courses.size() == 0) {
			System.out.println("No courses yet...");
			return false;
		}
		for(int i = 0; i < Database.courses.size(); i++)
			System.out.println( i + 1 + ")" + Database.courses.get(i).toString1());
		return true;
	}
	
}
