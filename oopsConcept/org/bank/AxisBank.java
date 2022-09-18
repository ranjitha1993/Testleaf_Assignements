package org.bank;

public class AxisBank extends BankInfo {
	
	public void deposit(String a)
	{
		System.out.println("The new deposit amount is here ");
	}

	public static void main(String[] args) {
		//Over-ride
		
		AxisBank mydetails=new AxisBank();
		mydetails.deposit("");

	}

}
