package assignments.week3;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		// FindIntersection 
		
		int[] Arr1= {3,2,11,4,6,7};
		int[] Arr2= {1,2,8,4,9,7};
		
		List <Integer> IV1= new ArrayList<Integer>();
		
		for (Integer i : Arr1) {
			
			IV1.add(i);
			
		}
		
		List <Integer> IV2= new ArrayList<Integer>();
		
		for (Integer j : Arr2) {
			
			IV2.add(j);
		}
		
		IV2.retainAll(IV1);
		System.out.println(IV2);
		

	}

}
