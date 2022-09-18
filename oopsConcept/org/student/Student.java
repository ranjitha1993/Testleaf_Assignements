package org.student;

import org.department.Department;

public class Student extends Department{
	public String studentName()
	{
		return "Ranjitha";
	}
	
	public String studentDept()
	{
		return "ECE";
	}
	
	public int studentId()
	{
		return 1234;
	}

	public static void main(String[] args) {
		Student mystudent=new Student();
		mystudent.studentName();
		mystudent.studentDept();
		mystudent.studentId();
		mystudent.deptName();
		mystudent.collegeName();
		mystudent.collegeCode();
		mystudent.collegeRank();

	}

}
