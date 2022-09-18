package org.abstaraction;

public abstract class MultipleLangauge implements Language,TestTool {
	public void python() {
		System.out.println("Python code");
	}
	
	public abstract void ruby();

}
