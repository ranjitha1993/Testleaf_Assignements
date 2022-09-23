package assignments.week3;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// Remove duplicates using set
		
		String text = "We learn java basics as part of java sessions in java week1";
		text= text.toLowerCase();
		
		String[] split = text.split(" ");
		Set<String> value= new LinkedHashSet<String>();
		
		for (String s : split) {
			
			value.add(s);
		}
		
		//System.out.println(value);
		
		for (String set : value) {
			System.out.print(set + " ");
			
		}

	}

}
