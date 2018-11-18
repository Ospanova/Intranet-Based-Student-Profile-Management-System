package project;

import java.io.Serializable;

public class Attendence implements Serializable  {
	int propuski;
	public Attendence () {
		this.propuski = 0;
	}
	public void setPr() {
		this.propuski++;
	}
	public int getPr() {
		return this.propuski;
	}
}
