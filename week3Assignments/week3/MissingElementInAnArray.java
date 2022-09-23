package assignments.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		//MissingElement in an Array
		
		int[] arr = {2,1,3,4,7,6,8,10};
		
		List <Integer> value= new ArrayList<Integer>();
		
		for (Integer num : arr) {
			value.add(num);
		}
		Collections.sort(value);
		System.out.println(value);
		
		//Finding the Missing element
		
		for (int i=value.size()-1; i>0;i--)
			if(value.get(i)-value.get(i-1)!=1) {
				System.out.println((value.get(i-1)+1));
			}
			else {
			
			}
		}

}
