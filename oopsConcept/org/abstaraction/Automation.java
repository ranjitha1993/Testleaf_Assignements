package org.abstaraction;

public class Automation extends MultipleLangauge {

	public void Java() {
		System.out.println("Java method calling from Language Interface");
		
	}

	public void Selenium() {
		System.out.println("Selenium method calling from TestTool Interface");
		
	}

	@Override
	public void ruby() {
		System.out.println("The overrided method");
	}

	public static void main(String[] args) {
		
		Automation myabstract= new Automation();
		myabstract.Java();
		myabstract.Selenium();
		myabstract.ruby();
		myabstract.python();
		
	}

}
