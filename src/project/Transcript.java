package project;

import java.io.Serializable;
import java.util.Set;

public class Transcript  implements Serializable {
	Attestation attestation = new Attestation();
	Final final_exam;
	public void setMark(Course c, Mark m) {
		this.attestation.setMark( c, m);
	}
	public int getTotalMark(Course c, Student s) {
		if(this.isAcceptedForFinal(c, s)){
			return this.attestation.getTotalMark(c) + this.final_exam.getMark(c, s);
		}
		return this.attestation.getTotalMark(c);
	}
	public boolean isAcceptedForFinal(Course c, Student s) {
		if (this.attestation.isAcceptedForFinal(c, s)) {
			this.final_exam.marksofF.put(c, new Mark());
				return true;
		}
			return false;
	}
		
}
