package project;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class Attestation  implements Serializable {
	public HashMap <Course, Mark > marksofAt = new HashMap <Course, Mark >();
	private boolean isFinish  = false;
	public boolean isFinish() {
		return isFinish;
	}
	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}
	public void setMark(Course c, Mark m) {
		if(this.marksofAt.containsKey(c)) {
			if (this.marksofAt.get(c) == null) {
				this.marksofAt.put(c, new Mark()); 
			}
			Mark h = this.marksofAt.get(c);
			h.setMark(this.marksofAt.get(c).getMark() + m.getMark());
		this.marksofAt.put(c, h);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isFinish ? 1231 : 1237);
		result = prime * result + ((marksofAt == null) ? 0 : marksofAt.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attestation other = (Attestation) obj;
		if (isFinish != other.isFinish)
			return false;
		if (marksofAt == null) {
			if (other.marksofAt != null)
				return false;
		} else if (!marksofAt.equals(other.marksofAt))
			return false;
		return true;
	}
	public int getTotalMark(Course c) {
		return this.marksofAt.get(c).getMark(); 
	}
	public boolean isAcceptedForFinal(Course c, Student s) {
		this.isFinish = true;
		if (this.getTotalMark(c) < 30)
			if (s.attendenceOfSt.containsKey(c)) {
				if (s.attendenceOfSt.get(c).propuski > c.getCredits() * 3)
					return false;
			}
			else
				return false;
		return true;			
	}
	public String ToString () {
		String res = "";
		Set <Course> s = this.marksofAt.keySet();
		for (Course c : s) {
			res += c.getName() + " "+ this.getTotalMark(c) + "\n";
		}
		return res;
	}
}
