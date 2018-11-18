package project;
import java.util.ArrayList;

public class Executor extends Employee{
	
	public Executor (String name, String lastName, Gender gender, String username, String password) {
		this.setDegree(1);
		this.setPassword(password);
		this.setUserName(username);
		this.setGender(gender);
		this.setName(name);
		this.setLastName(lastName);
	}
	
	
	static int cnt = 0;
	public int getSalary() {
		int s = super.getSalary();
		s += (0.01* cnt*s);
		return s;
	}
	public void getOrder(Order o) {
		o.isDone = true;
	
		Database.orders.remove(o);
	}
	
}
