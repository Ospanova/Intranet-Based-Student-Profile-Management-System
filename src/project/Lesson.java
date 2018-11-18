package project;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Lesson  implements Serializable	 {
	public Days d;
	public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
	public Course course;
}
