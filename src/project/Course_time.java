package project;
import java.io.Serializable;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Course_time  implements Serializable{
	public Days day;
	public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
	public Course_time () {
		
	}
	public Course_time (Days day, DateTimeFormatter dtf) {
		this.day = day;
		this.dtf = dtf;
	}
}
