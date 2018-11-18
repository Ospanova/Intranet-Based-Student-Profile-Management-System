package project;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

public class Final  implements Serializable
{
	public HashMap <Course, Mark> marksofF;
	public int getMark(Course c, Student s) {
		if (this.marksofF.containsKey(c)) {
			return this.marksofF.get(c).getMark();
		}
		return -100;	
	}
}
