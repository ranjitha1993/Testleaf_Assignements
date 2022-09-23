package assignments.week3;

import java.util.ArrayList;

import java.util.List;

public class PrintDuplicatesInArray {

	public static void main(String[] args) {
		//print duplicate in array
		
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		
		List<Integer> value =new ArrayList<Integer>();
		for (Integer dd : arr) {
			value.add(dd);
			
		}
		for(int i=0;i<value.size();i++) {
			for (int j=i+1;j<value.size();j++) {
				if((value.get(i))==(value.get(j))& i!=j) {
					System.out.println(value.get(i));
				}
			}
			
		}

	}

}
