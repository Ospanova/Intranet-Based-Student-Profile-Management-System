package project;

public class Employee extends User{
	public Employee() {
		super();
	}
	public Employee (String name, String lastName, Gender gender, String username, String password) {
		super(name,lastName,gender,username, password);
	}
	private int salary;
	
	public int getSalary () {
		return this.salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String toString1() {
	   return super.toString1();
	  }
}
