package project;

import java.io.Serializable;

public class Mark  implements Serializable{
	private int mark;
	public Mark() {
		this.mark = 0;
	}
	public int getMark() {
		return this.mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}

}
