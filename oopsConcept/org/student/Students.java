package org.student;

public class Students {
	
	public int getStudentInfo(int id) {
		return 1234;
	}
	
	public void getStudentInfo(int id, String name)
	{
		System.out.println(id);
		System.out.println(name);
	}
	
	public void getStudentInfo(String emailID, double PhoneNumber)
	{
		System.out.println(emailID);
		System.out.println(PhoneNumber);
	}

	public static void main(String[] args) {
		Students myStudents= new Students();
		myStudents.getStudentInfo(1234);
		myStudents.getStudentInfo(1234, "Ranjitha");
		myStudents.getStudentInfo("ranjitha@gmail.com", 1234567890);

	}

}
