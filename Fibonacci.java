package week1.day1;

public class Fibonacci {

	public static void main(String[] args) {
		// Fibonacci series
		
		int n=11;
		int firstNum=0;
		int secNum=1;
		int sum=0;
		
		System.out.print("The value are : "+firstNum +" "+secNum);
		
		for (int i=2; i<=n ;i++) 
		{
			sum= firstNum + secNum;
			System.out.print(" "+sum);
			firstNum=secNum;
			secNum=sum;
		}
		

	}

}
