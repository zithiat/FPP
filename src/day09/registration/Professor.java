package day09.registration;

public class Professor extends Person implements Cloneable {
	
	public Professor clone() {
		Professor p = new Professor();
		p.setName(this.getName());
		return p;
	}
}
