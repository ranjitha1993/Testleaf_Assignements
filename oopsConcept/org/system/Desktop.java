package org.system;

public class Desktop extends Computer{
	public void desktopSize() {
		System.out.println("The Desktop size 15.6 inch ");
	}

	public static void main(String[] args) {
		Desktop mysystem= new Desktop();
		mysystem.desktopSize();
		mysystem.computerModel();
		
	}

}
