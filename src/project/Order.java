package project;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Order   implements Serializable{
	String order;
	LocalDateTime now;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	public boolean isDone = false;
	public Order(String order ) {
		this.order = order;
		this.now = LocalDateTime.now();
	}
	//dtf.format(now)
}
