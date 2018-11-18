package project;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public abstract class User implements Serializable {
	public static final long serialVersionUID = 123456789123L;
	public boolean login = false;
	private int degree ;
	private int ID;
	private String name, email, lastName, userName,  password;
	private Gender gender;
	public User () {
		this.userName = "";
		this.password = "";
		this.name = "";
		this.gender = Gender.BOY;
		this.lastName = "";
	}
	public User (String name, String lastName,Gender gender, String userName,String  password) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.lastName = lastName;
	}
	public String getName () {
		return this.name;
	}
	public String getUserName () {
		return this.userName;
	}
	public String getLastName () {
		return this.lastName;
	}
	public String getEmail () {
		return this.email;
	}
	public String  getPassword() {
		return this.password;
	}
	public Gender getGender () {
		return this.gender;
	}
	public int getID () {
		return this.ID;
	}
	public void setID (int ID) {
		this.ID = ID;
	}
	public void setGender(Gender g) {
		this.gender = g;
	}
	public void setName (String name) {
		this.name = name;
	}
	public void setUserName (String user) {
		this.userName = user;
	}
	public void setLastName (String last) {
		this.lastName = last;
	}
	public void setEmail (String last) {
		this.email = last;
	}
	public void changePassword(String p) {
		if (checkP(p)){
			this.password = p;
		}
		
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean checkLogin() {
		if (this.userName.length() < 5) 
			/*for (int j = 0; j < userName.length(); ++j)
			for (int i = 32; i <= 47; ++i) 
				if (this.userName.charAt(j) == char(i));*/
			return false;
		return true;
	}
	public boolean checkP(String p) {
//		if (p.length() <= 6)
//			return false;
//		else
		return true;}
	public boolean equals (Object o) {
			User cur = (User)o;
			if (this.hashCode() != cur.hashCode() && this.ID != cur.ID) return false;
			else return true;
	}
	public int hashCode () {
		return Objects.hash(ID);
	}
	public String toString1() {
	    return this.lastName  + " " + this.name;
	 }
	public boolean checkOP(String oldp) {
		if (oldp.hashCode() == this.getPassword().hashCode()) 
			return true;
		return false;
	}
	public boolean  login (String username, String password){
			if (this.userName.equals(username) &&  this.password.hashCode() == password.hashCode()) {
			login = true;
			return true;
			}
			return false;
	}
	
	public void logout_ () {
		login = false;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
}
