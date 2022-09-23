package assignments.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class FindSecondLargest {

	public static void main(String[] args) {
		// FindSecondLargest 
		
		int[] data = {3,2,11,4,6,7};
		
		List<Integer> num= new ArrayList<Integer>();
		
		for (Integer n : data) {
			
			num.add(n);	
			
		}
		Collections.sort(num);
		System.out.println(num);
		int secondlargestvalue=num.get(num.size()-2);
				
		System.out.println("The second largestNumer is " +secondlargestvalue);

	}

}
