package day09.registration;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String name;
	private Professor professor;
	private List<Student> studentList;
	
	public Course() {
		
	}
	
	public Course(String name) {
		this.name = name;
		this.studentList = new ArrayList<Student>();
	}
	
	public Course(String name, Professor professor) {
		this.name = name;
		this.professor = (Professor) professor.clone();
		this.studentList = new ArrayList<Student>();
	}
	
	public void addStudent(Student s) {
		if (studentList == null) {
			studentList = new ArrayList<Student>();
		}
		studentList.add(s);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
